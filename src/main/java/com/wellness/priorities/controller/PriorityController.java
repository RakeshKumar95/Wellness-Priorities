package com.wellness.priorities.controller;

import com.wellness.priorities.dtos.PriorityCategoriesDto;
import com.wellness.priorities.dtos.RequestDto;
import com.wellness.priorities.services.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/priorities")
public class PriorityController {

    private final PriorityService priorityService;

    @Autowired
    public PriorityController(PriorityService priorityService) {
        this.priorityService = priorityService;
    }

    @GetMapping({"/categories/all-default", "/categories/{userId}"})
    public ResponseEntity<List<PriorityCategoriesDto>> getAllCategories(
            @PathVariable(value = "userId", required = false) Integer userId) {
        List<PriorityCategoriesDto> categories = priorityService.getAllCategories(userId);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/rating-order")
    public ResponseEntity addPriorityRating(@RequestBody List<RequestDto> requestDtos) throws Exception {
        priorityService.addOrUpdatePriorityRating(requestDtos);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
