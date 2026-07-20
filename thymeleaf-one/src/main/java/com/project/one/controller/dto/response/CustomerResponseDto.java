package com.project.one.controller.dto.response;

import com.project.one.domain.constant.Gender;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CustomerResponseDto {
    private String firstname;
    private String lastname;
    private Gender gender;
    private String email;
    private String nationalCode;
    private LocalDate birthDate;
}
