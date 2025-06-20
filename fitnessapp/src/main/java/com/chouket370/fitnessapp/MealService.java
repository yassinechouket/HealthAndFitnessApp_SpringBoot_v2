package com.chouket370.fitnessapp;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    private final MealRepository mealRepository;

    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }

    public Meal getMealById(Long id) {
        return mealRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(id + " not found"));
    }

    public Meal saveMeal(Meal meal) {
        return mealRepository.save(meal);
    }

    public void deleteMealById(Long id) {
        mealRepository.deleteById(id);
    }

    public Meal getAllMealsByType(String type) {
        return mealRepository.findByMealType(type);
    }
}