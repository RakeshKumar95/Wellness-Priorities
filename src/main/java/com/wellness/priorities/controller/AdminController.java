package com.wellness.priorities.controller;

import com.wellness.priorities.dtos.CategoryAdditionRequestDto;
import com.wellness.priorities.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/categories/add")
    public ResponseEntity<String> addCategories(@RequestBody List<CategoryAdditionRequestDto> categoryAdditionRequestDtos) throws Exception {
        String response;
        try {
            response = adminService.addCategories(categoryAdditionRequestDtos);
        } catch (Exception e) {
            throw new Exception("Something went wrong");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
