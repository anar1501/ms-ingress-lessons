package com.example.mscreditmanager.model.response;

import lombok.Data;

@Data
public class CustomerResponse {
    String pin;
    String fullName;
    String phoneNumber;
    String createdAt;
    String updatedAt;
}
