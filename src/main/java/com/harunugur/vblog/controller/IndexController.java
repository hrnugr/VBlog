package com.harunugur.vblog.controller;

import com.harunugur.vblog.exceptions.ApiError;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public ApiError error() {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage("Bad Request");
        return apiError;
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
