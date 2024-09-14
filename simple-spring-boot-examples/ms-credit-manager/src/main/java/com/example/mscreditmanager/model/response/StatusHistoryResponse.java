package com.example.mscreditmanager.model.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StatusHistoryResponse {
    String status;
    String createdAt;
    String updatedAt;
}
