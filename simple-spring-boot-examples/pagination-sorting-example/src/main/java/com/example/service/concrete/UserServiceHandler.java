package com.example.service.concrete;

import com.example.dao.repository.UserRepository;
import com.example.model.criteria.PageCriteria;
import com.example.model.criteria.UserCriteria;
import com.example.model.response.PageableUserResponse;
import com.example.service.abstracts.UserService;
import com.example.service.specification.UserSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceHandler implements UserService {

    private final UserRepository userRepository;
    @Override
    public PageableUserResponse getUsers(PageCriteria pageCriteria, UserCriteria userCriteria) {
        var usersPage=userRepository.findAll(new UserSpecification(userCriteria), PageRequest.of(pageCriteria.getPage(),pageCriteria.getCount(), Sort.by("id").descending()));
        return map(usersPage);
    }
}
