package com.chouket370.fitnessapp;

import java.time.LocalDate;

public record MealResponseDTO(String type, int calories, LocalDate date) {}
