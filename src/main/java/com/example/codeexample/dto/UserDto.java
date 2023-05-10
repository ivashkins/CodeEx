package com.example.codeexample.dto;

import com.example.codeexample.validated.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.codehaus.plexus.util.StringUtils;

import java.util.Date;
@Data
public class UserDto {

    @NotNull(groups = {BankValidated.class, GosuslugiValidated.class})
    private String bankId;
    @NotNull(groups = {MailValidated.class, BankValidated.class, GosuslugiValidated.class})
    private String fio;
    @NotNull(groups = {BankValidated.class, GosuslugiValidated.class})
    private Date birthday;
    @NotNull(groups = {BankValidated.class, GosuslugiValidated.class})
    private String passportNumber;
    @NotNull(groups = {MobileValidated.class, GosuslugiValidated.class})
    private String telephone;
    @NotNull(groups = {MailValidated.class, GosuslugiValidated.class})
    @Email
    private String email;
    private String actualAddress;
    @NotNull(groups = {GosuslugiValidated.class})
    private String registrationAddress;

    @AssertTrue(groups = {FindByParameters.class})
    private boolean isNotNullFields(){
        return StringUtils.isNotEmpty(email)
                || StringUtils.isNotEmpty(fio)
                || StringUtils.isNotEmpty(telephone);
    }


}

