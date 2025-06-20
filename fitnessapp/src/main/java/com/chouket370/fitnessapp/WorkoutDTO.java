package com.chouket370.fitnessapp;

import java.time.LocalDate;

public record WorkoutDTO(
        String type,
        int duration,
        int caloriesBurned,
        LocalDate date,
        Long user_id
) {
}
