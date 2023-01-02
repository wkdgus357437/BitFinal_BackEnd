package com.main.bitfinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.main.bitfinal.memberService.memberEntity","user.bean"})
@EnableJpaRepositories(basePackages ={"com.main.bitfinal.memberService.repository","user.dao"})
@ComponentScan(basePackages = {"user.*","com.main.bitfinal"})
@SpringBootApplication
public class BitFinalApplication {

    public static void main(String[] args) {
        SpringApplication.run(BitFinalApplication.class, args);

    }

}
