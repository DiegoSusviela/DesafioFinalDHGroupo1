package Travel.TripReservations.models.engine;

import Travel.TripReservations.models.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRepoRes extends JpaRepository<Reservations, Integer> {
    @Query("FROM Reservations")
    public List<Reservations> findAll();
}

