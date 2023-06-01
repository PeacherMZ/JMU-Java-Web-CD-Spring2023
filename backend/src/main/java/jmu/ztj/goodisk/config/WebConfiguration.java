package jmu.ztj.goodisk.config;

import jmu.ztj.goodisk.interceptor.AuthorizeInterceptor;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Resource
    AuthorizeInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry
                .addInterceptor(interceptor)
                .addPathPatterns("/**");
    }
}
