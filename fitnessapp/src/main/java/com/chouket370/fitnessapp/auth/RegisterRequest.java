package com.chouket370.fitnessapp.auth;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.chouket370.fitnessapp.Role;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String name;
    private int age;
    private double weight;
    private double height;
    private String gender;
    private Role role;
    private String email;
    private String password;
}
