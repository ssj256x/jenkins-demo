package com.jenkins.jenkinsdemo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ErrorResponse {
    private String errorCode;
    private String errorMessage;
}
