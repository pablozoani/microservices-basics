package com.pzoani.userservice.controller;

import com.pzoani.userservice.dto.UserWithDepartmentDTO;
import com.pzoani.userservice.model.User;
import com.pzoani.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User save(@RequestBody User user) {
        log.info("save()");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public UserWithDepartmentDTO getUserWithDepartment(@PathVariable Long id) {
        log.info("getUserWithDepartment");
        return userService.getUserWithDepartment(id);
    }
}
