package com.wellness.priorities.repositories;

import com.wellness.priorities.entities.SatisfactionRatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SatisfactionRatingRepository extends JpaRepository<SatisfactionRatingEntity, Integer> {
}