package com.chouket370.fitnessapp;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByName(String type);
    Optional<User> findByEmail(String email);
}
