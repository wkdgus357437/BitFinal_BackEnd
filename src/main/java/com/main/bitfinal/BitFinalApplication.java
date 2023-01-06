package com.main.bitfinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EntityScan(basePackages = {"com.main.bitfinal.memberService.memberEntity","com.adminBoard.bean","user.bean"})
@EnableJpaRepositories(basePackages = { "com.main.bitfinal.memberService.repository","com.adminBoard.dao","user.dao"})
@ComponentScan(basePackages = {"com.main.bitfinal","com.adminBoard.*","user.*"})
@SpringBootApplication
public class BitFinalApplication {

    public static void main(String[] args) {
        SpringApplication.run(BitFinalApplication.class, args);

    }

}
