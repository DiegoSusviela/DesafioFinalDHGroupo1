package Travel.TripReservations.repo;

import Travel.TripReservations.DTOs.HotelDTO;
import Travel.TripReservations.DTOs.PackageDTO;
import Travel.TripReservations.models.Bookings;
import Travel.TripReservations.models.Flights;
import Travel.TripReservations.models.Hotels;
import Travel.TripReservations.models.Package;
import Travel.TripReservations.models.engine.IRepoBook;
import Travel.TripReservations.models.engine.IRepoPackage;
import Travel.TripReservations.utils.Swapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.*;

@Repository
public class RepoPackage {

    private Map<Integer, Package> map = new HashMap<>();

    private IRepoPackage repo;

    public RepoPackage(IRepoPackage repos) throws IOException {
        /*todo: change to db*/
        this.repo = repos;
        List<Package> pack = new ArrayList<>();

        for (Package adding : pack)
            addElement(adding);
    }

    public Package addElement(Package toAdd){
        int packageNumber = toAdd.getPackageNumber();
        map.put(packageNumber, toAdd);
        /*todo: add to data base*/
        return toAdd;
    }

    public Map<Integer, Package> getMap(){
        List<Package> packages = repo.packageQuery();
        for (Package adding : packages)
            addElement(adding);
        return map;
    }

    public Package findId(int packageNumber){
        return map.get(packageNumber);
    }

    public void update(Package toUpdate){

    }

    public void delete(int toDelete) {
        repo.deleteById(toDelete);
    }

    public List<Package> getDailyPack(Date date, int month, int year){
        if (date == null)
            return repo.monthQuery(month, year);
        return repo.getDailyQuery(date);
    }

}
