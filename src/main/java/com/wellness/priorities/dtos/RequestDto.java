package com.wellness.priorities.dtos;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Validated
public class RequestDto {

    @NotNull
    private int userId;
    @NotNull
    private int categoryId;
    private int orderId;
    @Min(value = 1, message = "Rating cannot be less than 1")
    @Max(value = 5, message = "Rating cannot be greater than 5")
    private int rating;
}
