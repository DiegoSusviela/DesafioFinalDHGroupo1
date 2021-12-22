package Travel.TripReservations.models.engine;

import Travel.TripReservations.models.Bookings;
import Travel.TripReservations.models.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IRepoRes extends JpaRepository<Reservations, Integer> {
    @Query("FROM Reservations")
    public List<Reservations> findAll();

    @Query("FROM Reservations r WHERE r.id = :id")
    public void deleteReservation(@Param("id") int id);

    @Query("FROM Reservations r WHERE r.dateFrom = :date")
    public List<Reservations> dailyResQuery(@Param("date") Date date);

    @Query("FROM Reservations")
    public List<Reservations> monthBookQuery(@Param("month") int month,@Param("year") int year);

}

