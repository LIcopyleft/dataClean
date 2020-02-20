package com.drcnet.mc.bigdata.bmap.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 * 
 * @author qi.sun
 * @time 2018年11月7日 下午4:16:49
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    /**
     * 拦截器拦截地址
     */
    @Value("${bmap.interceptor.include}")
    private String includevalue;
    /**
     * 拦截器跳过地址
     */
    @Value("${bmap.interceptor.exclude}")
    private String excludevalue;
    /**
     * 拦截器
     */
   /* @Autowired
    private TokenInterceptor sysInterceptor;
*/
    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
      /*  // 添加拦截器
       *//* InterceptorRegistration addInterceptor = registry
                .addInterceptor(sysInterceptor);*//*
        // 添加拦截列表
        String[] includes = includevalue.split(",");
        for (String include : includes) {
            if (!include.isEmpty()) {
                addInterceptor.addPathPatterns(include);
            }
        }
        // 添加通过列表
        String[] excludes = excludevalue.split(",");
        for (String exclude : excludes) {
            if (!exclude.isEmpty()) {
                addInterceptor.excludePathPatterns(exclude);
            }
        }*/
    }
    
    /**
     * URL忽略大小写
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        AntPathMatcher matcher = new AntPathMatcher();
        matcher.setCaseSensitive(false);
        configurer.setPathMatcher(matcher);
    }

}
