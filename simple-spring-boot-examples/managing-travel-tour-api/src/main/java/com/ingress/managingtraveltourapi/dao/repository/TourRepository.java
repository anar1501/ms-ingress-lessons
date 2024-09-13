package com.ingress.managingtraveltourapi.dao.repository;

import com.ingress.managingtraveltourapi.dao.entity.TourEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TourRepository extends JpaRepository<TourEntity, Long> {
    @Override
    @EntityGraph(attributePaths = {"destinationEntities", "guideEntities", "travelerEntities"})
    Optional<TourEntity> findById(Long id);

    @Query("SELECT t FROM TourEntity t " +
            "LEFT JOIN FETCH t.guideEntities g " +
            "LEFT JOIN FETCH g.passportEntity " +
            "LEFT JOIN FETCH t.destinationEntities " +
            "LEFT JOIN FETCH t.travelerEntities " +
            "LEFT JOIN FETCH g.tourEntities " +
            "WHERE t.id = :tourId")
    Optional<TourEntity> findByIdWithGuidesAndPassport(@Param("tourId") Long tourId);

}
