package Travel.TripReservations.repo;

import Travel.TripReservations.models.Bookings;
import Travel.TripReservations.models.Flights;
import Travel.TripReservations.models.Reservations;
import Travel.TripReservations.models.engine.IRepoBook;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.*;

@Repository
public class RepoBooking implements IRepoBooking{
    private Map<Integer, Bookings> map = new HashMap<>();

    private IRepoBook repo;

    public RepoBooking(IRepoBook repos) throws IOException {
        this.repo = repos;
        List<Bookings> bookings = repo.findAll();

        for (Bookings adding : bookings)
            addElement(adding);
    }

    public Bookings addElement(Bookings toAdd){
        int id = toAdd.getId();
        map.put(id, toAdd);
        repo.save(toAdd);
        return toAdd;
    }
    public Bookings findId(int id){
        /*todo: set id's to reservations*/
        return map.get(id);
    }

    public Map<Integer, Bookings> getMap(){
        /*todo: set id's to reservations*/
        return map;
    }

    public void update(Bookings toUpdate){
        repo.save(toUpdate);
    }

    public void deleteBooking(int id) {
        repo.deleteById(id);
    }

    public List<Bookings> getDailyBooking(Date date, int month, int year){
        if (date == null)
            return repo.monthBookingQuery(month, year);
        return repo.dailyBookingQuery(date);
    }

    public List<Bookings> findAll() {
        return repo.findAll();
    }

}
