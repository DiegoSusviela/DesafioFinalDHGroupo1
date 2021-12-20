package Travel.TripReservations.repo;
/* implements for flight repo */

import Travel.TripReservations.models.Flights;
import Travel.TripReservations.models.engine.FileStorage;
import Travel.TripReservations.models.engine.IRepoFlights;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RepoFlights implements RepoFlightsI{
    private Map<String, Flights> map = new HashMap<>();
    private IRepoFlights repo;
    /**
     * Class constructor
     * loads data from filestorage
     */

    public RepoFlights(IRepoFlights repos) throws IOException {
        //List<Flights> flights = FileStorage.flightQuery();
        this.repo = repos;
        List<Flights> flights = repo.flightQuery();

        for (Flights adding : flights)
            addElement(adding);
    }

    /**
     * Adds element to the repository
     * @param toAdd: flights entity to add to repo
     * @return : returns the flight that was added to the repo
     */

    public Flights addElement(Flights toAdd){
        String id = toAdd.getId();
        map.put(id, toAdd);
        repo.save(toAdd);
        return toAdd;
    }

    /**
     *  Method to find flight in repo by id
     * @param id: Code of the flight to search in the hashmap
     * @return : returns the flight matched by the id, if any is found, null if failed
     */
    public Flights findId(String id){
        return map.get(id);
    }

    /**
     * Method used to return the hash map
     * no parameters needed
     * @return : The map of the repo containing all flights
     */

    public Map<String, Flights> getMap(){
        List<Flights> flights = repo.flightQuery();
        for (Flights adding : flights)
            addElement(adding);
        return map;
    }
    public void update(Flights toUpdate){
        repo.deleteById(toUpdate.getId());
        repo.save(toUpdate);
    }

    public void delete(String flightNumber) {
        repo.deleteById(flightNumber);
    }

    public List<Flights> findAll(){
        return repo.findAll();
    }
}
