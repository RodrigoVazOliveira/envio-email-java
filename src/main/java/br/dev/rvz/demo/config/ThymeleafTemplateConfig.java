package br.dev.rvz.demo.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;

import java.nio.charset.StandardCharsets;

@Configuration
public class ThymeleafTemplateConfig {

    /*@Bean
    public SpringTemplateEngine springTemplateEngine() {
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        springTemplateEngine.addTemplateResolver(htmlTemplateResolver());
        return springTemplateEngine;
    }

    @Bean
    public SpringResourceTemplateResolver htmlTemplateResolver() {
        SpringResourceTemplateResolver springResourceTemplateResolver = new SpringResourceTemplateResolver();
        springResourceTemplateResolver.setSuffix(".html");
        springResourceTemplateResolver.setTemplateMode(TemplateMode.HTML5);
        springResourceTemplateResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
        return springResourceTemplateResolver;
    }*/
}
