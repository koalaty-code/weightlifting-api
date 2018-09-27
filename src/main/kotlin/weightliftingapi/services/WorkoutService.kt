package weightliftingapi.services

import weightliftingapi.domain.WorkoutDTO

interface WorkoutService {
    fun getWorkouts(): List<WorkoutDTO>
}