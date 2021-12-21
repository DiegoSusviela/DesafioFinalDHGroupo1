package Travel.TripReservations.services;

import Travel.TripReservations.DTOs.HotelDTO;
import Travel.TripReservations.DTOs.PackageDTO;
import Travel.TripReservations.models.Hotels;
import Travel.TripReservations.models.Package;
import Travel.TripReservations.repo.RepoHotels;
import Travel.TripReservations.repo.RepoPackage;
import Travel.TripReservations.utils.Swapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicePackage {
    @Autowired
    private RepoPackage repPack;

    public ServicePackage(RepoPackage repo){
        repPack = repo;
    }

    public PackageDTO newPackage(PackageDTO entry){
        Package toAdd = Swapper.packageFromDTO(entry);
        repPack.addElement(toAdd);
        return entry;
    }

    public PackageDTO updatePackage(PackageDTO entry, int packageNumber){
        Package toAdd = Swapper.packageFromDTO(entry);
        repPack.update(toAdd);
        return entry;
    }

    public void deletePackage(int packageNumber){
        System.out.println(packageNumber);
        repPack.delete(packageNumber);
    }

    public Object findPackage(int packageNumber){
        if (packageNumber == 0)
            return Swapper.packageToDTO(repPack.findId(packageNumber));
        return repPack.getMap();
    }
}
