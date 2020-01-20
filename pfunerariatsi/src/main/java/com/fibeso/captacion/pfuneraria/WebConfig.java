package com.fibeso.captacion.pfuneraria;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

//@Configuration
//@EnableWebMvc
//@Component
//@PropertySource(value = "classpath:config/data.properties", encoding = "UTF-8")
public class WebConfig{ //implements WebMvcConfigurer {

	/*
	@Bean
    public ITemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setPrefix("/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("utf-8");
        templateResolver.setCacheable(false);
        return templateResolver;
    }
	
	 @Bean
     public SpringTemplateEngine templateEngine() {
         SpringTemplateEngine templateEngine = new SpringTemplateEngine();
         templateEngine.setTemplateResolver(templateResolver());
         return templateEngine;
     }
	 
	@Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
		//templateEngine = new TemplateEngine();
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        //resolver.setTemplateEngine(templateEngine);
        resolver.setCharacterEncoding("UTF-8"); // <- this was added
        resolver.setForceContentType(true); // <- this was added
        resolver.setContentType("text/html; charset=UTF-8"); // <- this was added
        registry.viewResolver(resolver);
    }
	*/
}
