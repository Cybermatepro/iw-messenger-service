package com.enwerevincent.investmentmailservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;


@Data
@ConfigurationProperties("app")
public class AppConfig {

    private Map<String, String> settings = new HashMap<>();

}
