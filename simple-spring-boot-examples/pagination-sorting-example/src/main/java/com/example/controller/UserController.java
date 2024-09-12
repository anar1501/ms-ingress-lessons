package com.example.controller;

import com.example.model.criteria.PageCriteria;
import com.example.model.criteria.UserCriteria;
import com.example.model.response.PageableUserResponse;
import com.example.service.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
public class UserController {
    private UserService userService;
    @GetMapping
    public PageableUserResponse getUsers(PageCriteria pageCriteria, UserCriteria userCriteria){
        return userService.getUsers(pageCriteria,userCriteria);
    }
}
