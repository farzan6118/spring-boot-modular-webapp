package com.project.one.service;

import com.project.one.controller.dto.request.CustomerRequestDto;
import com.project.one.controller.dto.response.CustomerResponseDto;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    CustomerResponseDto findByUuid(UUID uuid);

    List<CustomerResponseDto> findAll();

    void save(CustomerRequestDto requestDto);

    void update(UUID uuid, CustomerRequestDto requestDto);

    void delete(UUID uuid);

    boolean existsByEmail(String email);
}
