package com.pzoani.userservice.service;

import com.pzoani.userservice.dto.UserWithDepartmentDTO;
import com.pzoani.userservice.model.User;

public interface UserService {
    User saveUser(User user);

    UserWithDepartmentDTO getUserWithDepartment(Long id);
}
