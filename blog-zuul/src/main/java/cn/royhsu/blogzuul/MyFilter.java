package cn.royhsu.blogzuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Ethan Liu
 * @since 2019/5/9 19:59
 */
@Component
public class MyFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public String filterType() {
        return "pre";   // 定义filter的类型，有pre、route、post、error四种
    }

    @Override
    public int filterOrder() {
        return 0;   // 定义filter的顺序，数字越小表示顺序越高，越先执行
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // filter需要执行的具体操作
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String sessionId = request.getSession().getId();
        String token = request.getParameter("token");
        System.out.println(token);
//        if(token==null){
//            log.warn("there is no request token");
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(401);
//            try {
//                ctx.getResponse().getWriter().write("there is no request token");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
        log.info("--------------------------------------------------");
        log.info("sessionId: " + sessionId);
        log.info("--------------------------------------------------");
        log.info("ok");
        ctx.addZuulRequestHeader("Cloud-Cookie", "SESSION=" + sessionId);
        ctx.setSendZuulResponse(true);  // 对该请求进行路由
        ctx.setResponseStatusCode(200); // 返回200正确响应

        return null;
    }
}
