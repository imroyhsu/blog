package cn.royhsu.blogsso.admin.controller;

import cn.royhsu.blogsso.admin.entity.User;
import cn.royhsu.blogsso.admin.entity.UserToken;
import cn.royhsu.blogsso.admin.service.impl.UserServiceImpl;
import cn.royhsu.blogsso.admin.service.impl.UserTokenServiceImpl;
import cn.royhsu.blogsso.admin.utils.PasswordUtils;
import cn.royhsu.blogsso.admin.vo.LoginBean;
import cn.royhsu.common.utils.IOUtils;
import cn.royhsu.core.http.HttpResult;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;

/**
 * 登录控制器
 *
 * @author Ethan Liu
 * @since 2019/4/24 21:40
 */
@RestController
public class LoginController {

    @Resource
    private UserServiceImpl userService;
    @Resource
    private UserTokenServiceImpl userTokenService;
    @Resource
    private Producer producer;
    @Resource
    private HttpServletRequest request;

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("captcha.jpg")
    public void captcha(HttpServletResponse response) throws SecurityException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        // 生成文字验证码
        String text = producer.createText();
        // 生成图片验证码
        BufferedImage image = producer.createImage(text);

        // 保存到验证码到 session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    @PostMapping(value = "/login")
    public HttpResult loginVerify(@RequestBody LoginBean loginBean) {
        String username = loginBean.getAccount();
        String password = loginBean.getPassword();
        String captcha = loginBean.getCaptcha();
        logger.info("login");

        Object kaptcha = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        Serializable key = request.getSession().getId();
        logger.info("key:" + key);
        //session中获取之前生成的验证码，和前台传来的进行匹配
        if (kaptcha == null) {
            return HttpResult.error("验证码已失效");
        }
        if (!captcha.equals(kaptcha)) {
            return HttpResult.error("验证码错误");
        }
        //成功验证一次后即删除
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, null);

        // 用户信息
        User user = userService.getByName(username);

        // 账号不存在/密码错误
        if (user == null) {
            return HttpResult.error("账号或密码错误");
        }
        if (!match(password, user.getSalt(), user.getPassword())) {
            return HttpResult.error("账号或密码错误");
        }

        if (user.getStatus() == 0) {
            return HttpResult.error("账号已被锁定,请联系管理员");
        }
        //密码正确且未被锁定，则生成token或更新已有token
        UserToken data = userTokenService.createToken(user.getId(),key);
        return HttpResult.ok(data);
    }


    /**
     * 验证用户密码
     */
    private boolean match(String password, String salt, String encryptedPassword) {
        return encryptedPassword.equals(PasswordUtils.encrypt(password, salt));
    }

}
