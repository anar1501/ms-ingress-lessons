package com.ingress.managingtraveltourapi.dao.repository;

import com.ingress.managingtraveltourapi.dao.entity.TravelerEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TravelerRepository extends JpaRepository<TravelerEntity,Long> {
    @Override
    @EntityGraph(attributePaths = {"tourEntities"})
    List<TravelerEntity> findAllById(Iterable<Long> ids);
}
