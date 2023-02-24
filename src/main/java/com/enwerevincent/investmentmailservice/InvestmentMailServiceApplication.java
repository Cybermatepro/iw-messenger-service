package com.enwerevincent.investmentmailservice;

import com.enwerevincent.investmentmailservice.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties({AppConfig.class})
public class InvestmentMailServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvestmentMailServiceApplication.class, args);
    }

//    @Bean
//    public JavaMailSender javaMailSender(){
//        return new JavaMailSenderImpl();
//    }
}
