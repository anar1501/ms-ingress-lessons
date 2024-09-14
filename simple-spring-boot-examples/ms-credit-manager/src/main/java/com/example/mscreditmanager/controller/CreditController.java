package com.example.mscreditmanager.controller;

import com.example.mscreditmanager.model.response.CreditResponse;
import com.example.mscreditmanager.service.CreditService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping(path = "v1/credits")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class CreditController {

    CreditService creditService;

    @GetMapping("/{creditId}")
    public CreditResponse getCreditWithStatusHistoriesById(@PathVariable Long creditId) {
        return creditService.getCreditByStatusHistoryId(creditId);
    }


}
