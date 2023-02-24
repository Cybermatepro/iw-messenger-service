package com.enwerevincent.investmentmailservice.vo;

import lombok.Data;
import org.springframework.mail.SimpleMailMessage;

import java.util.HashMap;
import java.util.Map;


@Data
public class AppMessage {

    private SimpleMailMessage details = new SimpleMailMessage();

    private String template;

    private Map<String, String> templateParams = new HashMap<>();

    private String text;
}
