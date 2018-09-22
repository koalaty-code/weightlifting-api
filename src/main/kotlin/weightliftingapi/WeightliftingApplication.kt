package weightliftingapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WeightliftingApplication

fun main(args: Array<String>) {
    runApplication<WeightliftingApplication>(*args)
}
