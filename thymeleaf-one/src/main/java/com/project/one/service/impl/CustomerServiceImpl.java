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

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Cacheable("customer")
    @Override
    public CustomerResponseDto findById(Integer id) {
        Customer response = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with id: " + id));
        return mapToDto(response);
    }

    private CustomerResponseDto mapToDto(Customer customer) {
        CustomerResponseDto dto = new CustomerResponseDto();
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
    public void update(Integer id, CustomerRequestDto requestDto) {
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with id: " + id));

        customer.setFirstname(requestDto.getFirstname());
        customer.setLastname(requestDto.getLastname());
        customer.setGender(requestDto.getGender());
        customer.setBirthDate(requestDto.getBirthDate());
        customer.setNationalCode(requestDto.getNationalCode());

        repository.save(customer);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Customer not found with id: " + id);
        }
    }

    @Override
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }
}
