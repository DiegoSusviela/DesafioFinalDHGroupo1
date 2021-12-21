package Travel.TripReservations.services;
/* Implementation of hotel service interface*/

import Travel.TripReservations.DTOs.FlightResDTO;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("rawtypes")
public interface ServiceFlightsI {
    /* Service flights interface */
    Object filterFlights(Date dateFrom, Date dateTo, String destination, String origin);
    FlightResDTO makeReservation(FlightResDTO entry) throws ParseException;

}
