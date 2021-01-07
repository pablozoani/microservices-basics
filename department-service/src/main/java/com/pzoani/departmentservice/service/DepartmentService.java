package com.pzoani.departmentservice.service;

import com.pzoani.departmentservice.model.Department;

public interface DepartmentService {
    Department save(Department department);

    Department findById(Long id);
}
