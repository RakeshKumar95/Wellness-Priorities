package com.wellness.priorities.services;

import com.wellness.priorities.dtos.PriorityCategoriesDto;
import com.wellness.priorities.dtos.RequestDto;
import com.wellness.priorities.entities.CategoryEntity;
import com.wellness.priorities.entities.UserSatisfactionEntity;
import com.wellness.priorities.repositories.CategoryRepository;
import com.wellness.priorities.repositories.UserSatisfactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PriorityService {

    private final CategoryRepository prioritiesCategoriesRepo;
    private final UserSatisfactionRepository satisfactionRepo;

    @Autowired
    public PriorityService(CategoryRepository prioritiesCategoriesRepo,
                           UserSatisfactionRepository satisfactionRepo) {
        this.prioritiesCategoriesRepo = prioritiesCategoriesRepo;
        this.satisfactionRepo = satisfactionRepo;
    }

    /**
     * Get all the categories either for a user or in general. To get the categories for the user send userId.
     * If the sent user id has not customized any priorities then all the categories will be sent with default order
     * @param userId Optional - Can be null in case if user need to fetch all the categories in the database
     * @return List of Category Dto which include id, name, order of that category
     */
    public List<PriorityCategoriesDto> getAllCategories(Integer userId) {
        List<PriorityCategoriesDto> dtos = new ArrayList<>();

        List<UserSatisfactionEntity> satisfactionEntities = null;
        List<CategoryEntity> entities;
        if (userId != null) {
            satisfactionEntities = satisfactionRepo.findByUserIdOrderByOrderId(userId);
            if (null != satisfactionEntities && !satisfactionEntities.isEmpty()) {
                for (UserSatisfactionEntity s: satisfactionEntities) {
                    dtos.add(new PriorityCategoriesDto().getCategoriesDto(s));
                }
            }
        }
        if (satisfactionEntities == null || satisfactionEntities.isEmpty()) {
            entities = prioritiesCategoriesRepo.findAll();
            if(!entities.isEmpty()) {
                for(CategoryEntity c: entities) {
                    dtos.add(new PriorityCategoriesDto().getCategoriesDto(c));
                }
            }
        }
        return dtos;
    }

    /**
     *  When a user is customizing priorities for the first time, it will be added to the database. Next time a user
     *  tries to update order, rating for a category, that will get updated.
     * @param requestDtos Request Dto
     * @throws Exception
     */
    public void addOrUpdatePriorityRating(List<RequestDto> requestDtos) throws Exception {
        List<UserSatisfactionEntity> satisfactionEntities = new ArrayList<>();
        UserSatisfactionEntity entity;
        for(RequestDto dto: requestDtos) {
            entity = satisfactionRepo.findByUserIdAndCategoryId(dto.getUserId(), dto.getCategoryId());
            if (entity == null) {
                entity = new UserSatisfactionEntity();
                entity.setCategoryId(dto.getCategoryId());
                entity.setUserId(dto.getUserId());
                entity.setCreatedTime(new Timestamp(new Date().getTime()));
            }
            entity.setRatingId(dto.getRating());
            entity.setOrderId(dto.getOrderId());
            entity.setLastUpdatedBy(new Timestamp(new Date().getTime()));
            satisfactionEntities.add(entity);
        }
        try {
            if (!satisfactionEntities.isEmpty()) {
                satisfactionRepo.saveAll(satisfactionEntities);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Something went wrong. Please try again later");
        }
    }
}
