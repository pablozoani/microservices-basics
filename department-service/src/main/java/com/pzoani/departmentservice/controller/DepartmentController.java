package com.pzoani.departmentservice.controller;

import com.pzoani.departmentservice.model.Department;
import com.pzoani.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public Department save(@RequestBody Department department) {
        log.info("save()");
        return departmentService.save(department);
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable String id) {
        log.info("getById()");
        return departmentService.findById(Long.valueOf(id));
    }
}
