package com.ingress.managingtraveltourapi.dao.repository;

import com.ingress.managingtraveltourapi.dao.entity.GuideEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuideRepository extends JpaRepository<GuideEntity, Long> {
    @Override
    @EntityGraph(attributePaths = {"tourEntities", "passportEntity"},type = EntityGraph.EntityGraphType.FETCH)
    Optional<GuideEntity> findById(Long id);
}
