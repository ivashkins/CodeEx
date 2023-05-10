package com.example.codeexample.service;

import com.example.codeexample.entity.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum XSource {


    MAIL(getMailList());
//    MOBILE,
//    BANK,
//    GOSUSLUGI;

    private static List<String> getMailList() {
        return  Arrays.asList("id", "mail", "passport");
    }

    List<String> validationFields;

    XSource(List<String> emptyList) {
        validationFields = emptyList;
    }

    public List<String> getValidationFields() {
        return validationFields;
    }

    public void setValidationFields(List<String> validationFields) {
        this.validationFields = validationFields;
    }
}
