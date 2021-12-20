package Travel.TripReservations.models.engine;

import Travel.TripReservations.models.Hotels;
import Travel.TripReservations.models.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IRepoPackage extends JpaRepository<Package, Integer> {

    @Query("FROM Package")
    public List<Package> packageQuery();

    @Query("FROM Package")
    public List<Package> getDailyQuery(@Param("date") Date date);

    @Query("FROM Package")
    public List<Package> monthQuery(@Param("month") int month, @Param("year") int year);
}
