package com.project.one.controller;

import com.project.one.controller.dto.request.CustomerRequestDto;
import com.project.one.controller.dto.response.CustomerResponseDto;
import com.project.one.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/v1/customer")
public class CustomerRestController {

    private final CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerResponseDto> getAllCustomers() {
        return customerService.findAll();
    }

    @GetMapping(value = "{uuid}")
    public ResponseEntity<CustomerResponseDto> getCustomerByUuid(@PathVariable UUID uuid) {
        return ResponseEntity.ok(customerService.findByUuid(uuid));
    }

    @PostMapping
    public ResponseEntity<Void> saveCustomer(@RequestBody CustomerRequestDto requestDto) {
        customerService.save(requestDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{uuid}")
    public ResponseEntity<Void> update(@PathVariable UUID uuid, @RequestBody CustomerRequestDto requestDto) {
        customerService.update(uuid, requestDto);
        return ResponseEntity.ok().build();
    }
}
