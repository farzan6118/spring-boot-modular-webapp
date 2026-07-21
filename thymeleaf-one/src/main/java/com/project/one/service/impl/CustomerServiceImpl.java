package com.project.one.service.impl;

import com.project.one.controller.dto.request.CustomerRequestDto;
import com.project.one.controller.dto.response.CustomerResponseDto;
import com.project.one.domain.Customer;
import com.project.one.repository.CustomerRepository;
import com.project.one.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Override
    @Cacheable("customer")
    public CustomerResponseDto findByUuid(UUID uuid) {
        Customer response = repository.findByUuid(uuid)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with id: " + uuid));
        return mapToDto(response);
    }

    private CustomerResponseDto mapToDto(Customer customer) {
        CustomerResponseDto dto = new CustomerResponseDto();
        dto.setUuid(customer.getUuid());
        dto.setFirstname(customer.getFirstname());
        dto.setLastname(customer.getLastname());
        dto.setEmail(customer.getEmail());
        dto.setGender(customer.getGender());
        dto.setBirthDate(customer.getBirthDate());
        dto.setNationalCode(customer.getNationalCode());
        return dto;
    }

    private Customer mapToEntity(CustomerRequestDto requestDto) {
        Customer customer = new Customer();
        customer.setUuid(requestDto.getUuid());
        customer.setFirstname(requestDto.getFirstname());
        customer.setLastname(requestDto.getLastname());
        customer.setEmail(requestDto.getEmail());
        customer.setGender(requestDto.getGender());
        customer.setBirthDate(requestDto.getBirthDate());
        customer.setNationalCode(requestDto.getNationalCode());
        return customer;
    }

    @Override
    public List<CustomerResponseDto> findAll() {
        List<Customer> customers = repository.findAll();
        return customers.stream().map(this::mapToDto).toList();
    }

    @Transactional
    @Override
    public void save(CustomerRequestDto requestDto) {
        Customer customer = this.mapToEntity(requestDto);
        repository.save(customer);
    }

    @Transactional
    @Override
    public void update(UUID uuid, CustomerRequestDto requestDto) {
        Customer customer = repository.findByUuid(uuid)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with uuid: " + uuid));

        customer.setFirstname(requestDto.getFirstname());
        customer.setLastname(requestDto.getLastname());
        customer.setGender(requestDto.getGender());
        customer.setBirthDate(requestDto.getBirthDate());
        customer.setNationalCode(requestDto.getNationalCode());

        repository.save(customer);
    }

    @Transactional
    @Override
    public void delete(UUID uuid) {
        Customer customer = repository.findByUuid(uuid)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with uuid: " + uuid));
        repository.delete(customer);
    }

    @Override
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }
}
