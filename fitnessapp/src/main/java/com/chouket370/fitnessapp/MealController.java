package com.chouket370.fitnessapp;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meal")
public class MealController {

    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping
    public List<MealResponseDTO> getAllMeals() {
        return mealService.getAllMeals().stream()
                .map(this::toMealResponseDTO)
                .toList();
    }

    @GetMapping("/type/{type}")
    public MealResponseDTO getAllMealsByType(@PathVariable String type) {
        return toMealResponseDTO(mealService.getAllMealsByType(type));
    }

    @GetMapping("/{id}")
    public MealResponseDTO getMealById(@PathVariable Long id) {
        return toMealResponseDTO(mealService.getMealById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteMealById(@PathVariable Long id) {
        mealService.deleteMealById(id);
    }

    @PostMapping("/save")
    public MealResponseDTO saveMeal(@RequestBody MealDTO mealDTO) {
        return toMealResponseDTO(mealService.saveMeal(toMeal(mealDTO)));
    }

    private Meal toMeal(MealDTO dto) {
        var meal = new Meal();
        meal.setMealType(dto.type());
        meal.setDate(dto.date());
        meal.setCalories(dto.calories());
        var user = new User();
        user.setId(dto.user_id());
        meal.setUser(user);
        return meal;
    }

    private MealResponseDTO toMealResponseDTO(Meal meal) {
        return new MealResponseDTO(
                meal.getMealType(),
                meal.getCalories(),
                meal.getDate()
        );
    }
}