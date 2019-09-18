package com.sandy03934.employeeportal.dto.rest.response;

import lombok.Data;

@Data
public class RegisterEmployeeResponse implements Response, Updateable<String> {

    private String publicId;

    @Override
    public String getPublicId() {
        return publicId;
    }
}
