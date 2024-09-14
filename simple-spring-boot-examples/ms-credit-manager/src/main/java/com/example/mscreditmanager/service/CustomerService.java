package com.example.mscreditmanager.service;

import com.example.mscreditmanager.dao.repository.CustomerRepository;
import com.example.mscreditmanager.exception.ErrorMessage;
import com.example.mscreditmanager.exception.NotFoundException;
import com.example.mscreditmanager.mapper.CustomerMapper;
import com.example.mscreditmanager.model.request.CreateCustomerRequest;
import com.example.mscreditmanager.model.response.CustomerResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerService {
    CustomerRepository customerRepository;
    CustomerMapper customerMapper;

    public void createCustomer(CreateCustomerRequest createCustomerRequest) {
        customerRepository.save(customerMapper.map(createCustomerRequest));
    }

    public CustomerResponse getByPin(String pin) {
        return customerMapper.map(customerRepository.findByPin(pin).orElseThrow(() -> new NotFoundException(ErrorMessage.CUSTOMER_NOT_FOUND.getCode(), ErrorMessage.CUSTOMER_NOT_FOUND.getMessage())));
    }
}
