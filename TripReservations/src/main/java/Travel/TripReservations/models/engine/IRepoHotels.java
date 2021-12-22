package Travel.TripReservations.models.engine;

import Travel.TripReservations.models.Flights;
import Travel.TripReservations.models.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface IRepoHotels extends JpaRepository<Hotels, Integer> {

    @Query("FROM Hotels")
    public List<Hotels> hotelQuery();

    @Query("SELECT hotel FROM Hotels hotel WHERE hotel.freeFrom <= :dateFrom AND hotel.freeTo >= :dateTo AND :destination = hotel.location")
    //@Query("from Hotels")
    public Set<Hotels> findHotelsByParams(@Param("dateFrom") Date dateFrom,
                                  @Param("dateTo") Date dateTo,
                                  @Param("destination") String destination);

    @Query ("FROM Hotels h where h.hotelCode = :hotelCode")
    public void deleteHotelByCode(@Param("hotelCode") String hotelCode);

}
