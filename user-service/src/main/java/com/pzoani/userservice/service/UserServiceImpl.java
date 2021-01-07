package com.pzoani.userservice.service;

import com.pzoani.userservice.dto.DepartmentDTO;
import com.pzoani.userservice.dto.UserWithDepartmentDTO;
import com.pzoani.userservice.model.User;
import com.pzoani.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public User saveUser(@RequestBody User user) {
        log.info("save()");
        return userRepository.save(user);
    }

    @Override
    public UserWithDepartmentDTO getUserWithDepartment(Long id) {
        log.info("getUserWithDepartment");
        User user = userRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        DepartmentDTO departmentDTO = restTemplate
            .getForObject("http://localhost:9001/" + user.getDepartmentId(), DepartmentDTO.class);
        return new UserWithDepartmentDTO(user, departmentDTO);
    }
}
