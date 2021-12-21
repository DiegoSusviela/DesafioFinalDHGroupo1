package Travel.TripReservations.models.engine;

import Travel.TripReservations.models.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IRepoBook extends JpaRepository<Bookings, Integer> {
    @Query("FROM Bookings")
    public List<Bookings> findAll();

    @Query("FROM Bookings b WHERE b.dateFrom = :date")
    public List<Bookings> dailyBookingQuery(@Param("date") Date date);

    @Query("FROM Bookings")
    public List<Bookings> monthBookingQuery(@Param("month") int month, @Param("year") int year);
}
