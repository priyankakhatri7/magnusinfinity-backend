package com.magnusinfinity.magnusinfinitybackend.controller;

import com.magnusinfinity.magnusinfinitybackend.exception.ResourceNotFoundException;
import com.magnusinfinity.magnusinfinitybackend.dao.entity.User;
import com.magnusinfinity.magnusinfinitybackend.dao.repository.UserRepository;
import com.magnusinfinity.magnusinfinitybackend.security.CurrentUser;
import com.magnusinfinity.magnusinfinitybackend.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }

}
