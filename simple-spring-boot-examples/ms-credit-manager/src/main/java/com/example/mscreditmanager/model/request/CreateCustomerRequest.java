package com.example.mscreditmanager.model.request;

import lombok.Data;

@Data
public class CreateCustomerRequest {
    String pin;
    String fullName;
    String phoneNumber;
}
