package com.chouket370.fitnessapp;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workout")
public class WorkoutController {

    private final WorkoutService workoutService;
    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping
    public List<WorkoutResponseDTO> getAllWorkouts() {
        return workoutService.getAllWorkouts().stream()
                .map(this::toWorkoutResponseDTO)
                .toList();
    }
    @GetMapping("/type/{type}")
    public WorkoutResponseDTO getAllWorkoutsByType(@PathVariable String type) {
        return toWorkoutResponseDTO(workoutService.getAllWorkoutsByType(type));
    }
    @GetMapping("/{id}")
    public WorkoutResponseDTO getWorkoutById(@PathVariable Long id) {
        return toWorkoutResponseDTO(workoutService.getWorkoutById(id));
    }
    @DeleteMapping("/{id}")
    public void deleteWorkoutById(@PathVariable Long id) {
        workoutService.deleteWorkoutById(id);
    }
    @PostMapping("/save")
    public WorkoutResponseDTO saveWorkout(@RequestBody WorkoutDTO workout) {
        return toWorkoutResponseDTO(workoutService.saveWorkout(toWorkout(workout)));
    }

    private Workout toWorkout(WorkoutDTO workoutDTO) {
        var workout = new Workout();
        workout.setType(workoutDTO.type());
        workout.setDate(workoutDTO.date());
        workout.setDuration(workoutDTO.duration());
        workout.setCaloriesBurned(workoutDTO.caloriesBurned());
        var user=new User();
        user.setId(workoutDTO.user_id());
        workout.setUser(user);
        return workout;

    }
    private WorkoutResponseDTO toWorkoutResponseDTO(Workout workout) {
        return new WorkoutResponseDTO(
                workout.getType(),workout.getDuration(),workout.getCaloriesBurned()
        );

    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Workout>> getWorkouts(@PathVariable Long userId) {
        return ResponseEntity.ok(workoutService.getAllWorkoutsByUser(userId));
    }


}
