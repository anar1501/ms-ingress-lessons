package com.example.mscreditmanager.controller;

import com.example.mscreditmanager.model.request.CreateCustomerRequest;
import com.example.mscreditmanager.model.response.CustomerResponse;
import com.example.mscreditmanager.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping(path = "v1/customers")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class CustomerController {

    CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody CreateCustomerRequest request) {
        customerService.createCustomer(request);
    }

    @GetMapping
    public CustomerResponse getByPin(@RequestBody String pin) {
        return customerService.getByPin(pin);
    }


}
