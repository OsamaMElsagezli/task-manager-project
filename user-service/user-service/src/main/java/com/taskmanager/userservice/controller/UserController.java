package com.taskmanager.userservice.controller;

import com.taskmanager.userservice.dto.UserRequest;
import com.taskmanager.userservice.dto.UserResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/users")
public class UserController {

    private final AtomicLong counter = new AtomicLong(1);
    private final Map<Long, UserResponse> users = new ConcurrentHashMap<>();

    @PostMapping("/register")
    public UserResponse register(@RequestBody UserRequest request) {
        Long id = counter.getAndIncrement();
        UserResponse user = new UserResponse(id, request.getUsername());
        users.put(id, user);
        return user;
    }

    @PostMapping("/login")
    public String login(@RequestBody UserRequest request) {
        return "User logged in successfully";
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        return users.get(id);
    }
}
