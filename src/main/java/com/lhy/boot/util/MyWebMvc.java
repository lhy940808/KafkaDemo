package com.lhy.boot.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author liuhaiyan
 * @date 2019-11-08 16:55
 */
@Configuration
public class MyWebMvc extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload_file/**").addResourceLocations("file:/Users/liuhaiyan05/uploadLocation/");
        super.addResourceHandlers(registry);
    }

}
