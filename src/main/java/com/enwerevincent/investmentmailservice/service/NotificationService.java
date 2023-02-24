package com.enwerevincent.investmentmailservice.service;

import com.enwerevincent.investmentmailservice.config.AppConfig;
import com.enwerevincent.investmentmailservice.vo.AppMessage;
import com.enwerevincent.investmentmailservice.vo.MailRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class NotificationService {

    private final AppConfig config;

    private final EmailService emailService;


    public boolean sendEmail(MailRequest mail) {
        return emailService.sendMail(createEmailMessage(mail));
    }


    private AppMessage createEmailMessage(MailRequest mail) {
        AppMessage message = new AppMessage();
        message.getDetails().setTo(mail.getTo());
        message.getDetails().setSubject(mail.getSubject());
        message.setTemplate(mail.getTemplate());
        message.setTemplateParams(buildTemplateParams(mail));
        message.setText(mail.getText());
        return message;
    }


    private Map<String, String> buildTemplateParams(MailRequest mail) {
        Map<String, String> params = new HashMap<>();
        params.putAll(config.getSettings());
        if (mail.getTemplateParams() != null) {
            params.putAll(mail.getTemplateParams());
        }
        return params;
    }

}
