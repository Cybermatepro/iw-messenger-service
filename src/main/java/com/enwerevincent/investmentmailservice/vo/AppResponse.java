package com.enwerevincent.investmentmailservice.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppResponse<T> implements Serializable {

    private static final long serialVersionUID = -3826972210952312616L;

    String status;

    T data;
}
