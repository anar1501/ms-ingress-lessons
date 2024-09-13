package com.ingress.managingtraveltourapi.dao.repository;

import com.ingress.managingtraveltourapi.dao.entity.PassportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<PassportEntity,Long> {
}
