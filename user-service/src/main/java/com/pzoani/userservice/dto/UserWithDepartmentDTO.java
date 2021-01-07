package com.pzoani.userservice.dto;

import com.pzoani.userservice.model.User;
import lombok.Data;

@Data
public class UserWithDepartmentDTO {
    private final User user;
    private final DepartmentDTO department;
}
