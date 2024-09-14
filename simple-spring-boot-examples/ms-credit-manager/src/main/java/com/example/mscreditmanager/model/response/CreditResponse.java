package com.example.mscreditmanager.model.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreditResponse {
    Set<StatusHistoryResponse> statusHistoryResponseList;
}
