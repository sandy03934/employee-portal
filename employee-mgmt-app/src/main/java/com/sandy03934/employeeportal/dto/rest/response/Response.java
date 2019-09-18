package com.sandy03934.employeeportal.dto.rest.response;

import com.sandy03934.employeeportal.dto.error.Errorable;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public interface Response {

    List<Errorable> errors = new ArrayList<>();
    default Long getTimeStamp() {
        return Instant.now().toEpochMilli();
    }

    default List<Errorable> getErrors() {
        return errors;
    }

    default void addError(Errorable error) {
        errors.add(error);
    }
}
