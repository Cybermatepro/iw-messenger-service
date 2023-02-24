package com.enwerevincent.investmentmailservice.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MailRequest {

    private String template;

    private Map<String, String> templateParams;

    @Builder.Default
    private String from = "noreply@systemspecs.com.ng";

    private String to;

    private String subject;

    private String text;
}
