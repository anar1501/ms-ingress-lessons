package com.example.service.abstracts;

import com.example.model.criteria.PageCriteria;
import com.example.model.criteria.UserCriteria;
import com.example.model.response.PageableUserResponse;

public interface UserService {
    PageableUserResponse getUsers(PageCriteria pageCriteria, UserCriteria userCriteria);
}
