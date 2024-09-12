package com.example.service.specification;

import com.example.util.PredicateUtil;
import com.example.dao.entity.UserEntity;
import com.example.model.criteria.UserCriteria;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;


import static com.example.model.constants.CriteriaConstants.AGE;
import static com.example.model.constants.CriteriaConstants.BIRTH_PLACE;
import static com.example.util.PredicateUtil.applyLikePattern;

@AllArgsConstructor
public class UserSpecification implements Specification<UserEntity> {
    private UserCriteria userCriteria;

    @Override
    public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate[] build = PredicateUtil.builder()
                .addNullSafety(userCriteria.getBirthPlace(),
                        birthPlace -> criteriaBuilder.like(root.get(BIRTH_PLACE), applyLikePattern(birthPlace))
                )
                .addNullSafety(userCriteria.getAgeFrom(),
                        ageFrom -> criteriaBuilder.greaterThanOrEqualTo(root.get(AGE), ageFrom))
                .addNullSafety(userCriteria.getAgeTo(),
                        ageTo -> criteriaBuilder.lessThanOrEqualTo(root.get(AGE), ageTo))
                .build();
        return criteriaBuilder.and(build);
    }
}
