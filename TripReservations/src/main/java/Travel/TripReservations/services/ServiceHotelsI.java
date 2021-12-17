package Travel.TripReservations.services;
/* Implementation of hotel service interface*/


import Travel.TripReservations.DTOs.UsersDTO;
import Travel.TripReservations.exceptionHandlers.MissingDateFrom;

import java.util.Date;
import java.util.Map;
import java.util.Set;

public interface ServiceHotelsI {
    /* Service hotels interface */
    Object filterHotels(Date dateFrom, Date dateTo, String destination) throws MissingDateFrom;
    UsersDTO makeReservation(UsersDTO entry);
}
