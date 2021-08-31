package com.wellness.priorities.services;

import com.wellness.priorities.dtos.CategoryAdditionRequestDto;
import com.wellness.priorities.entities.CategoryEntity;
import com.wellness.priorities.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AdminService {

    private final CategoryRepository categoryRepo;

    @Autowired
    public AdminService(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    /**
     *
     * @param categoryAdditionRequestDtos Request Data
     * @return A response containing number of categories added.
     * @throws Exception If any exception occurs while database transaction
     */
    public String addCategories(List<CategoryAdditionRequestDto> categoryAdditionRequestDtos) throws Exception {
        CategoryEntity category;
        List<CategoryEntity> newCategories = new ArrayList<>();
        for(CategoryAdditionRequestDto dto: categoryAdditionRequestDtos) {
            category = new CategoryEntity();
            category.setCategoryId(dto.getCategoryId());
            category.setName(dto.getName());
            category.setDescription(Objects.requireNonNull(dto.getDescription()));
            category.setDefaultOrder(dto.getDefaultOrder());

            newCategories.add(category);
        }
        List<CategoryEntity> categoriesAdded;
        try {
            categoriesAdded = categoryRepo.saveAll(newCategories);
        } catch (Exception e) {
            e.fillInStackTrace();
            throw new Exception("Something went wrong. Please try again later");
        }

        return categoriesAdded.size() + (categoriesAdded.size() > 1 ? " categories": " category") + " added";
    }
}
