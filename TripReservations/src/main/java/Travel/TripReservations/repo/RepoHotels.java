package Travel.TripReservations.repo;
/* implements for hotel repo */


import Travel.TripReservations.models.Flights;
import Travel.TripReservations.models.Hotels;
import Travel.TripReservations.models.engine.FileStorage;
import Travel.TripReservations.models.engine.IRepoHotels;
import Travel.TripReservations.models.engine.IRepoRes;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.*;

@Repository
public class RepoHotels implements RepoHotelsI{

    private IRepoHotels repo;

    private Map<String, Hotels> map = new HashMap<>();

    /**
     * Class constructor
     * loads data from filestorage
     */
    public RepoHotels(IRepoHotels repos) throws IOException {
        //List<Hotels> hotels = FileStorage.hotelQuery();
        this.repo = repos;
        List<Hotels> hotels = repo.hotelQuery();
        for (Hotels adding : hotels)
            map.put(adding.getHotelCode(), adding);
    }

    /**
     * Adds element to the repository
     * @param toAdd: Hotel entity to add to repo
     * @return : returns the hotel that was added to the repo
     */

    public Hotels addElement(Hotels toAdd){
        String hotelCode = toAdd.getHotelCode();
        map.put(hotelCode, toAdd);
        repo.save(toAdd);
        return toAdd;
    }

    /**
     * Method to find hotels in repo by id
     * hotelCode: Code of the hotel to search in the hashmap
     * @return : returns the hotel matched by the id, if any is found, null if failed
     */

    public Hotels findId(String hotelCode){
        return map.get(hotelCode);
    }

    /**
     * Method used to return the hash map
     * no parameters needed
     * @return : The map of the repo containing all hotels
     */

    public Map<String, Hotels> getMap(){
        List<Hotels> hotels = repo.hotelQuery();
        for (Hotels adding : hotels)
            addElement(adding);
        return map;
    }

    public Set getWithParams(Date leav, Date ret, String dest){

        Set wopa = repo.findHotelsByParams(leav, ret, dest);
        

        return wopa;
    }
    public void update(Hotels toUpdate){
        repo.save(toUpdate);
    }

    public void delete(Hotels hotelCode) {
        repo.delete(hotelCode);
    }

}

