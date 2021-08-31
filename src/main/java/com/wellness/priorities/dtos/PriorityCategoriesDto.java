package com.wellness.priorities.dtos;

import com.wellness.priorities.entities.CategoryEntity;
import com.wellness.priorities.entities.UserSatisfactionEntity;
import lombok.Data;

@Data
public class PriorityCategoriesDto {

    private int id;
    private String name;
    private int order;

    public PriorityCategoriesDto getCategoriesDto(CategoryEntity entity) {
        this.id = entity.getCategoryId();
        this.name = entity.getName();
        this.order = entity.getDefaultOrder();
        return this;
    }

    public PriorityCategoriesDto getCategoriesDto(UserSatisfactionEntity entity) {
        this.id = entity.getCategoryId();
        this.name = entity.getCategory().getName();
        this.order = entity.getOrderId();
        return this;
    }
}
