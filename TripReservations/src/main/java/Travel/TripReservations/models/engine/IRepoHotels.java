package Travel.TripReservations.models.engine;

import Travel.TripReservations.models.Flights;
import Travel.TripReservations.models.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface IRepoHotels extends JpaRepository<Hotels, Integer> {
    @Query("FROM Hotels")
    public List<Hotels> hotelQuery();
    @Query("SELECT hotel FROM Hotels hotel WHERE hotel.freeFrom >= :dateFrom AND hotel.freeTo <= :dateTo AND :destination = hotel.location")
    //@Query("from Hotels")
    public ArrayList<Hotels> findHotelsByParams(@Param("dateFrom") Date dateFrom,
    @Param("dateTo") Date dateTo,
    @Param("destination") String destination);
}
