package top.atstudy.component.base.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import top.atstudy.component.interceptor.AuthInterceptor;
import top.atstudy.component.interceptor.LogInterceptor;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: hdxin
 * Date: 2018-07-09
 * Time: 15:18
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //日志处理
        registry.addInterceptor(new LogInterceptor()).addPathPatterns();
        //登录授权
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/api/payment/**");

        super.addInterceptors(registry);
    }

}
