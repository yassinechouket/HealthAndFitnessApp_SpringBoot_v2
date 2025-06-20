package com.chouket370.fitnessapp;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Meal {
    @Id
    @GeneratedValue
    private Long id;
    private String mealType; // Breakfast, Lunch, etc.
    private int calories;
    private int protein;
    private int carbs;
    private int fat;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonBackReference
    private User user;
    public Meal() {}

    public Meal( String mealType, int calories, int protein, int carbs, int fat, LocalDate date) {

        this.mealType = mealType;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
        this.date = date;

    }

    public Long getId() {
        return id;
    }

    public String getMealType() {
        return mealType;
    }

    public int getCalories() {
        return calories;
    }

    public int getProtein() {
        return protein;
    }

    public int getCarbs() {
        return carbs;
    }

    public int getFat() {
        return fat;
    }

    public LocalDate getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
