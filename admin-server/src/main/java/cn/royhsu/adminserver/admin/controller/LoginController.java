package cn.royhsu.adminserver.admin.controller;

import cn.royhsu.adminserver.admin.entity.User;
import cn.royhsu.adminserver.admin.entity.UserToken;
import cn.royhsu.adminserver.admin.service.impl.UserServiceImpl;
import cn.royhsu.adminserver.admin.service.impl.UserTokenServiceImpl;
import cn.royhsu.adminserver.admin.utils.PasswordUtils;
import cn.royhsu.adminserver.admin.vo.LoginBean;
import cn.royhsu.core.http.HttpResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
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


    @PostMapping(value = "/sys/login")
    public HttpResult loginVerify(@RequestBody LoginBean loginBean){
        String username = loginBean.getAccount();
        String password = loginBean.getPassword();
        System.out.println("进入controller");



        User user = userService.getByName(username);
        if(user == null){
            return HttpResult.error("账号不存在");
        }
        if(!match(password,user.getSalt(),user.getPassword())){
            return HttpResult.error("密码错误");
        }
        if(user.getStatus()==0){
            return HttpResult.error("账号已被锁定,请联系管理员");
        }
        //密码正确且未被锁定，则生成token或更新已有token
        UserToken data = userTokenService.createToken(user.getId());
        return HttpResult.ok(data);
    }

    /**
     * 验证用户密码
     */
    private boolean match(String password, String salt, String encryptedPassword){
        return encryptedPassword.equals(PasswordUtils.encrypt(password,salt));
    }

}
