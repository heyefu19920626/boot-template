package com.heyefu.template.handler;

import com.heyefu.template.constant.GlobalConstant;
import com.heyefu.template.pojo.login.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description:
 * <p>
 * 登录拦截器.
 *
 * @author heyefu
 * Create in: 2019-12-27
 * Time: 11:36
 **/
public class LoginHandler implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginHandler.class);

    /**
     * 在业务处理器处理请求之前被调用。预处理，可以进行编码、安全控制、权限校验等处理
     * <p>
     * 返回拦截状态
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute(GlobalConstant.USER_SESSION_KEY);

        if (user == null || user.getUserId() == null || "".equals(user.getUserId())) {
            String context = "".equals(request.getContextPath()) ? "/" :request.getContextPath();
            response.sendRedirect(context);
            LOGGER.info("未登录");
            return false;
        }

        return true;
    }

    /**
     * 在业务处理器处理请求执行完成后，生成视图之前执行。
     * <p>
     * 后处理（调用了Service并返回ModelAndView，但未进行页面渲染），有机会修改ModelAndView
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在DispatcherServlet完全处理完请求后被调用，可用于清理资源等。返回处理（已经渲染了页面）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
