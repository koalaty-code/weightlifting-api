package weightliftingapi.controllers

import io.github.benas.randombeans.api.EnhancedRandom.randomListOf
import org.amshove.kluent.When
import org.amshove.kluent.calling
import org.amshove.kluent.itReturns
import org.amshove.kluent.shouldEqual
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient
import weightliftingapi.domain.WorkoutDTO
import weightliftingapi.services.WorkoutService

@ExtendWith(SpringExtension::class)
@WebFluxTest(WorkoutController::class)
class WorkoutControllerTest {
    private val resourceUri = "/workouts"

    @Autowired
    private lateinit var webTestClient: WebTestClient

    @MockBean
    private lateinit var workoutService: WorkoutService

    @Nested
    inner class `GET workouts` {
        private lateinit var randomListOfWorkouts: List<WorkoutDTO>

        @BeforeEach
        fun beforeEach() {
            randomListOfWorkouts = randomListOf(5, WorkoutDTO::class.java)

            When calling workoutService.getWorkouts() itReturns randomListOfWorkouts
        }

        @Test
        fun `should return all workouts!`() {
            randomListOfWorkouts shouldEqual webTestClient.get()
                    .uri(resourceUri)
                    .exchange()
                    .expectBodyList(WorkoutDTO::class.java)
                    .returnResult().responseBody
        }

        @Test
        fun `should return OK status`() {
            webTestClient.get()
                .uri(resourceUri)
                .exchange()
                .expectStatus().isOk
        }
    }
}