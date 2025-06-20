package com.chouket370.fitnessapp;

import java.time.LocalDate;

public record MealDTO(String type, int calories, LocalDate date, Long user_id) {}
