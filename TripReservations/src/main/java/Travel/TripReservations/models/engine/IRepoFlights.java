package Travel.TripReservations.models.engine;

import Travel.TripReservations.models.Flights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IRepoFlights extends JpaRepository<Flights, String> {

    @Query("FROM Flights")
    public List<Flights> flightQuery();

    @Query("FROM Flights f where f.leaving <= ?1 AND f.returning >= ?2 AND f.destiny = ?3")
    public Flights flightByParams(@Param("leav") Date leav, @Param("ret") Date ret, @Param("dest") Date dest);

    @Query ("FROM Flights f where f.id = :id")
    public void delete(@Param("id") int id);

}
