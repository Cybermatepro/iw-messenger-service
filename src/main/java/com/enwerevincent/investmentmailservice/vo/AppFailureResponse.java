package com.enwerevincent.investmentmailservice.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;


@Data
@AllArgsConstructor
public class AppFailureResponse implements Serializable {

    private static final long serialVersionUID = -3826972210952312616L;

    private final String status = "error";

    private Object data;

    private String message;
}
