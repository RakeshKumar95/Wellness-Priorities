package com.wellness.priorities.dtos;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CategoryAdditionRequestDto {
    @NotNull(message = "Category Id cannot be null")
    private int categoryId;
    @NotNull(message = "Name Cannot be null")
    private String name;
    private String description;
    @NotNull(message = "A default order has to be set")
    private int defaultOrder;
}
