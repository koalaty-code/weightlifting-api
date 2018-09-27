package weightliftingapi.services

import io.github.benas.randombeans.api.EnhancedRandom.randomListOf
import org.amshove.kluent.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import weightliftingapi.domain.Workout
import weightliftingapi.repositories.WorkoutRepository

class WorkoutServiceImplTest {
    private lateinit var workoutService: WorkoutService
    private lateinit var workoutRepository: WorkoutRepository

    @BeforeEach
    fun beforeEach() {
        workoutRepository = mock()

        workoutService = WorkoutServiceImpl(workoutRepository)
    }

    @Nested
    inner class `Get Workouts` {
        private lateinit var randomListOfWorkouts: List<Workout>

        @BeforeEach
        fun beforeEach() {
            randomListOfWorkouts = randomListOf(5, Workout::class.java)

            When calling workoutRepository.findAll() itReturns randomListOfWorkouts
        }

        @Test
        fun `should return list of workouts converted to DTOs`() {
            val expectedListOfDTOs = randomListOfWorkouts.map { it.convertToDTO() }

            val actualList = workoutService.getWorkouts()

            actualList shouldEqual expectedListOfDTOs
        }
    }
}