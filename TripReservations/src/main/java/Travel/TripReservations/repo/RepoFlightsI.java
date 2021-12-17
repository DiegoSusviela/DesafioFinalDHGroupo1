package Travel.TripReservations.repo;
/* Interface that implements repository for Flights */

import Travel.TripReservations.models.Flights;

import java.util.Map;

public interface RepoFlightsI {
    Flights addElement(Flights toAdd);
    Flights findId(String id);
    Map<String, Flights> getMap();
}
