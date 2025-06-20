package com.chouket370.fitnessapp;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkoutService {
    private final WorkoutRepository workoutRepository;
    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }
    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }
    public Workout getWorkoutById(Long id) {
        return workoutRepository.findById(id).orElseThrow(() -> new IllegalStateException(id + " not found"));
    }
    public Workout saveWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }
    public void deleteWorkoutById(Long id) {
        workoutRepository.deleteById(id);
    }
    public Workout getAllWorkoutsByType(String type) {
        return workoutRepository.findByType(type);
    }
    public List<Workout> getAllWorkoutsByUser(Long userId) {
        return workoutRepository.findAll().stream()
                .filter(w -> w.getUser().getId().equals(userId))
                .collect(Collectors.toList());
    }
}
