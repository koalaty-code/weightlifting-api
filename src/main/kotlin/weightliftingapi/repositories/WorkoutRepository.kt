package weightliftingapi.repositories

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import weightliftingapi.domain.Workout

@Repository
interface WorkoutRepository : CrudRepository<Workout, Int>
