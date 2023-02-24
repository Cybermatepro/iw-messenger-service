package com.enwerevincent.investmentmailservice.service;

import com.enwerevincent.investmentmailservice.vo.AppMessage;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Objects;


@Service
public class EmailService {

    private final JavaMailSender mailSender;

    private final MailContentBuilder contentBuilder;

    private final String from;


    public EmailService(JavaMailSender mailSender, MailContentBuilder contentBuilder,
            @Value("${app.mail.from:noreply@systemspecs.com.ng}") String from) {
        this.mailSender = mailSender;
        this.contentBuilder = contentBuilder;
        this.from = from;
    }


    public boolean sendMail(AppMessage appMessage) {
        try {
            MimeMessage message = generatedMimeMessage(appMessage);
            mailSender.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
    }


    private MimeMessage generatedMimeMessage(AppMessage appMessage) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(Objects.requireNonNull(appMessage.getDetails().getTo(), "No recipient specified"));
        if (StringUtils.hasText(appMessage.getText())) {
            helper.setText(appMessage.getText(), true);
        } else {
            helper.setText(contentBuilder.build(appMessage.getTemplateParams(), appMessage.getTemplate()), true);
        }
        helper.setSubject(Objects.requireNonNull(appMessage.getDetails().getSubject(), "No subject provided"));
        helper.setFrom(getSenderMail(appMessage));
        return message;
    }

    private String getSenderMail(AppMessage appMessage) {
        return StringUtils.hasText(appMessage.getDetails().getFrom()) ? appMessage.getDetails().getFrom() : from;
    }
}
