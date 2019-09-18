package com.sandy03934.employeeportal.dto.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Error implements Errorable {

    String errorMessage;

    String errorCode;

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }
}
