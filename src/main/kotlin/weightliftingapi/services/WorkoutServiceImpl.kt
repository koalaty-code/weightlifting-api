package weightliftingapi.services

import org.springframework.stereotype.Service
import weightliftingapi.domain.WorkoutDTO
import weightliftingapi.repositories.WorkoutRepository

@Service
class WorkoutServiceImpl(private val workoutRepository: WorkoutRepository) : WorkoutService {
    override fun getWorkouts(): List<WorkoutDTO> {
        return workoutRepository.findAll().map { it.convertToDTO() }
    }
}