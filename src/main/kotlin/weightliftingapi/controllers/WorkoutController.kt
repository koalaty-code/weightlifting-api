package weightliftingapi.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class WorkoutController {
    @GetMapping("/workouts")
    fun handleGetWorkouts(): Mono<String> {
        return Mono.just("Hello World!")
    }
}