package com.heyefu.template.configuration;

import com.heyefu.template.handler.LoginHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Description:
 * <p>
 * 注册拦截器
 *
 * @author heyefu
 * Create in: 2019-12-27
 * Time: 15:28
 **/
@Component
public class WebSecurityConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //注册一个拦截器，并排除一些url
        registry.addInterceptor(new LoginHandler()).addPathPatterns("/**")
                .excludePathPatterns("/css/**", "/js/**", "/img/**")
                .excludePathPatterns("/loginUser", "/", "/login.html");
    }
}
