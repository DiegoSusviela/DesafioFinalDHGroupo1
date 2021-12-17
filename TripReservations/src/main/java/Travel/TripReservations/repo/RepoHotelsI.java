package Travel.TripReservations.repo;
/* Interface for hotel repository */
import Travel.TripReservations.models.Hotels;

import java.util.Map;

public interface RepoHotelsI {
    Hotels addElement(Hotels toAdd);
    Hotels findId(String hotelCode);
    Map<String, Hotels> getMap();
}
