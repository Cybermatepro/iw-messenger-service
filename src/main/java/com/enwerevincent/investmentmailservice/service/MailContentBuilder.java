package com.enwerevincent.investmentmailservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;


@RequiredArgsConstructor
@Service
public class MailContentBuilder {

    private final TemplateEngine templateEngine;


    public String build(Map<String, String> messageMap, String templateName) {
        Context context = new Context();
        messageMap.keySet().forEach(key -> context.setVariable(key, messageMap.get(key)));
        return templateEngine.process(templateName, context);
    }
}
