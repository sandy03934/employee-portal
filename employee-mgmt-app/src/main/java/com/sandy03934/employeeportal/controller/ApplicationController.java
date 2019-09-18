package com.sandy03934.employeeportal.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationController implements ErrorController {

    private static final String LANDING_PAGE = "index.html";

    private static final String ERROR_PATH = "/error";

    @RequestMapping("/")
    public String home() {
        return LANDING_PAGE;
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    public String error(){
        return "forward:".concat(LANDING_PAGE);
    }
}
