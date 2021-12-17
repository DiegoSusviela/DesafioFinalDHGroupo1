package Travel.TripReservations.repo;

import Travel.TripReservations.models.Bookings;
import Travel.TripReservations.models.Reservations;
import Travel.TripReservations.models.engine.IRepoBook;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RepoBooking implements IRepoBooking{
    private Map<Integer, Bookings> map = new HashMap<>();

    private IRepoBook repo;

    public RepoBooking(IRepoBook repos) throws IOException {
        /*todo: change to db*/
        this.repo = repos;
        List<Bookings> bookings = new ArrayList<>();

        for (Bookings adding : bookings)
            addElement(adding);
    }

    public Bookings addElement(Bookings toAdd){
        /*todo: set id's to reservations*/
        int id = toAdd.getId();
        map.put(id, toAdd);
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

}
