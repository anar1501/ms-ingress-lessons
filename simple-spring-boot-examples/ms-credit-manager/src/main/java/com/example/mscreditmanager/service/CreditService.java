package com.example.mscreditmanager.service;

import com.example.mscreditmanager.dao.entity.StatusHistoryEntity;
import com.example.mscreditmanager.dao.repository.CreditRepository;
import com.example.mscreditmanager.exception.NotFoundException;
import com.example.mscreditmanager.model.response.CreditResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.example.mscreditmanager.exception.ErrorMessage.CREDIT_NOT_FOUND;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreditService {
    CreditRepository creditRepository;

    public CreditResponse getCreditByStatusHistoryId(Long creditId) {
        CreditResponse response=new CreditResponse();
        var creditEntity = creditRepository.findById(creditId).orElseThrow(() -> new NotFoundException(CREDIT_NOT_FOUND.getCode(), CREDIT_NOT_FOUND.getMessage()));
        Set<StatusHistoryEntity> statusHistoryList = creditEntity.getStatusHistoryEntities();
        response.setStatusHistoryResponseList(statusHistoryList);
        return response;
    }
}
