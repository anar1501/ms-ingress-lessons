package com.example.mscreditmanager.dao.repository;

import com.example.mscreditmanager.dao.entity.CustomerEntity;
import com.example.mscreditmanager.dao.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OfferRepository extends JpaRepository<OfferEntity, Long> {
}