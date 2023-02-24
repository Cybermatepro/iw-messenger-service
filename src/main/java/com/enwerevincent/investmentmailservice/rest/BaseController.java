package com.enwerevincent.investmentmailservice.rest;


import com.enwerevincent.investmentmailservice.vo.AppFailureResponse;
import com.enwerevincent.investmentmailservice.vo.AppResponse;

public class BaseController {

    public <T> AppResponse<T> getResponse(T data) {
        if (data == null) {
            return getFailResponse(data);
        }
        return new AppResponse<>("success", data);
    }


    public <T> AppResponse<T> getSuccessResponse(T data) {
        return new AppResponse<>("success", data);
    }


    public <T> AppResponse<T> getFailResponse(T data) {
        return new AppResponse<>("fail", data);
    }


    public AppFailureResponse getErrorResponse(Object data, String message) {
        return new AppFailureResponse(data, message);
    }
}
