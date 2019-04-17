package pro.sunhao.bookstore.configuration;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import pro.sunhao.bookstore.interceptor.UserLimitInterceptor;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 设置跨域访问
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .maxAge(3600);
    }

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sysUserLoginInterceptor());
    }

    /**
     * 自己定义的拦截器类
     * @return
     */
    @Bean
    UserLimitInterceptor sysUserLoginInterceptor() {
        return new UserLimitInterceptor();
    }

}
