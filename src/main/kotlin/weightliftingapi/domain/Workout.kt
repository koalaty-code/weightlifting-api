package weightliftingapi.domain

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "workout")
data class Workout(
    @Id
    val id: Int,
    val description: String
) {
    fun convertToDTO() =
        WorkoutDTO(
            id = this.id,
            description = this.description
        )
}