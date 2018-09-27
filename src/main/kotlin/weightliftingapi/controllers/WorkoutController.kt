package weightliftingapi.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import weightliftingapi.domain.WorkoutDTO
import weightliftingapi.services.WorkoutService

@RestController
class WorkoutController(private val workoutService: WorkoutService) {
    @GetMapping("/workouts")
    fun handleGetWorkouts(): Flux<WorkoutDTO> {
        return Flux.fromIterable(workoutService.getWorkouts())
    }
}