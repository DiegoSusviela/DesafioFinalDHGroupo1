package Travel.TripReservations.repo;

import Travel.TripReservations.models.Flights;
import Travel.TripReservations.models.Reservations;
import Travel.TripReservations.models.engine.IRepoFlights;
import Travel.TripReservations.models.engine.IRepoRes;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RepoReservation implements IRepoReservation{

    private Map<Integer, Reservations> map = new HashMap<>();
    private IRepoRes repo;

    public RepoReservation(IRepoRes repos) throws IOException{
        /*todo: change to db*/
        this.repo = repos;
        List<Reservations> reservations = new ArrayList<>();

        for (Reservations adding : reservations)
            addElement(adding);
    }

    public Reservations addElement(Reservations toAdd){
        /*todo: set id's to reservations*/
        int id = toAdd.getId();
        map.put(id, toAdd);
        return toAdd;
    }
    public Reservations findId(int id){
        /*todo: set id's to reservations*/
        return map.get(id);
    }

    public Map<Integer, Reservations> getMap(){
        /*todo: set id's to reservations*/
        return map;
    }

}
