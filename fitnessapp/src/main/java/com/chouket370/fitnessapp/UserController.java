package com.chouket370.fitnessapp;


import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers().stream()
                .map(this::toUserDTO)
                .toList();
    }
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return  toUserDTO(userService.getUserById(id));
    }
    @GetMapping("/name/{name}")
    public UserDTO getUserByName(@PathVariable String name) {
        return toUserDTO(userService.getUserByName(name));
    }
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
    @PostMapping("/save")
    public User saveUser(@RequestBody @Valid User user)
    {
        return userService.save(user);
    }
    private UserDTO toUserDTO(User user) {
        return new UserDTO(user.getName(), user.getWeight(), user.getHeight(), user.getGender());
    }

}
