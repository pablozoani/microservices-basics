package com.pzoani.departmentservice.service;

import com.pzoani.departmentservice.model.Department;
import com.pzoani.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department save(Department department) {
        log.info("save()");
        return departmentRepository.save(department);
    }

    @Override
    public Department findById(Long id) {
        return departmentRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Department not found"));
    }
}
