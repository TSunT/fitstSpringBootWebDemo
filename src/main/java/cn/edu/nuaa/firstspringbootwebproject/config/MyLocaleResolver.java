package cn.edu.nuaa.firstspringbootwebproject.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String language = request.getParameter("language");
        System.out.println(language);
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(language)){
            String[] languageparam = StringUtils.split(language, "_");
            locale = new Locale(languageparam[0],languageparam[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
