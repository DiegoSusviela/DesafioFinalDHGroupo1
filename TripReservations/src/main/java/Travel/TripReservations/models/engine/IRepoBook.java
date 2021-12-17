package Travel.TripReservations.models.engine;

import Travel.TripReservations.models.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRepoBook extends JpaRepository<Bookings, Integer> {
    @Query("FROM Bookings")
    public List<Bookings> findAll();

}
