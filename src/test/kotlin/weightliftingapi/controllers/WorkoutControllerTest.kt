package weightliftingapi.controllers

import org.amshove.kluent.shouldEqual
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient

@ExtendWith(SpringExtension::class)
@WebFluxTest(WorkoutController::class)
class WorkoutControllerTest {
    private val resourceUri = "/workouts"

    @Autowired
    private lateinit var webTestClient: WebTestClient

    @Nested
    inner class `GET workouts` {
        @Test
        fun `should return Hello World!`() {
            "Hello World!" shouldEqual webTestClient.get()
                    .uri(resourceUri)
                    .exchange()
                    .expectBody(String::class.java)
                    .returnResult().responseBody
        }
    }
}