package com.wellness.priorities.repositories;

import com.wellness.priorities.entities.UserSatisfactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSatisfactionRepository extends JpaRepository<UserSatisfactionEntity, Integer> {
    List<UserSatisfactionEntity> findByUserIdOrderByOrderId(int userId);

    UserSatisfactionEntity findByUserIdAndCategoryId(int userId, int categoryId);
}