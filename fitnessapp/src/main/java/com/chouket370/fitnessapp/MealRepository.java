package com.chouket370.fitnessapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MealRepository extends JpaRepository<Meal,Long> {
    Meal findByMealType(String mealType);
}
