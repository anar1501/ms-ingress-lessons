package com.ingress.managingtraveltourapi.dao.repository;

import com.ingress.managingtraveltourapi.dao.entity.DestinationEntity;
import com.ingress.managingtraveltourapi.dao.entity.TourEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DestinationRepository extends JpaRepository<DestinationEntity,Long>{
    List<DestinationEntity> findByTourEntity(TourEntity tourEntity);
}
