package com.project.one.controller.dto.request;

import com.project.one.domain.constant.Gender;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class CustomerRequestDto {

    @NotNull(message = "uuid is required")
    private UUID uuid;

    @NotNull(message = "Firstname is required")
    @Size(max = 50, message = "Firstname must be at most 50 characters")
    private String firstname;

    @NotNull(message = "Lastname is required")
    @Size(max = 50, message = "Lastname must be at most 50 characters")
    private String lastname;

    @NotNull(message = "Gender is required")
    private Gender gender;

    @NotNull(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "National code is required")
    @Size(min = 10, max = 10, message = "National code must be exactly 10 characters")
    private String nationalCode;

    @NotNull(message = "Birth date is required")
    @Past(message = "Birth date must be in the past")
    private LocalDate birthDate;
}