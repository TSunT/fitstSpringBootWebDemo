package cn.edu.nuaa.firstspringbootwebproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;
//扩展SpringMVC，想要自定义一些功能要先定义一个类实现WebConfigurer接口 将它交给springboot springboot会自动装配
/*
* if you want to keep those Spring Boot MVC customizations and make more MVC customizations
* (interceptors, formatters, view controllers, and other features), you can add your own @Configuration class
* of type WebMvcConfigurer but without @EnableWebMvc.
* */
@Controller //在SpringBoot中会有非常多的扩展配置，只要看见了这个，我们就应该多留心注意
public class MyWebConfig implements WebMvcConfigurer {
    //用于将自定义的视图解析器交给springboot
    @Bean
    public ViewResolver myViewResolver(){
        return new MyViewResolver();
    }

    @Bean
    public LocaleResolver myLocaleResolver(){return new MyLocaleResolver();}

    //自定义了一个视图解析器，实现ViewResolver接口
    private class MyViewResolver implements ViewResolver{
        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/suntao").setViewName("test");
        registry.addViewController("/login").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main").setViewName("dashboard");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/index.html","/dist/**","/login/loginUser");
    }
}
