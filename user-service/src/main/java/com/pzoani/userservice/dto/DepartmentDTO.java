package com.pzoani.userservice.dto;

import lombok.Data;

@Data
public class DepartmentDTO {
    private final Long id;
    private final String name;
    private final String address;
    private final String code;
}
