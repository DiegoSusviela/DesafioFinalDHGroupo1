package Travel.TripReservations.services;
/* Implementation of Flights services modules */

import Travel.TripReservations.DTOs.FlightResDTO;
import Travel.TripReservations.DTOs.FlightReservationDTO;
import Travel.TripReservations.DTOs.HotelDTO;
import Travel.TripReservations.DTOs.StatusDTO;
import Travel.TripReservations.exceptionHandlers.*;
import Travel.TripReservations.models.*;
import Travel.TripReservations.repo.RepoBooking;
import Travel.TripReservations.repo.RepoFlights;
import Travel.TripReservations.repo.RepoHotels;
import Travel.TripReservations.repo.RepoReservation;
import Travel.TripReservations.utils.Swapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ServiceFlights implements ServiceFlightsI{
    /*Service class for Flights, implements all services regarding Flights class*/
    @Autowired
    private RepoFlights repfli;

    @Autowired
    private RepoReservation repRes;

    public ServiceFlights(RepoFlights repo){
        repfli = repo;
    }

    /**
     *  Method used to filter by dateFrom, dateTo, destination and origin, receives
     * all 4 parameters.
     * @param dateFrom: Initial date where flight should be free
     * @param dateTo: Final date up to which the flight should be free
     * @param destination: Destination of flight to be filtered
     * @param origin: Origin where the flight departs to filter
     * @return : This method returns a set of flights filling the criteria
     */

    public Object filterFlights(Date dateFrom, Date dateTo, String destination, String origin) {
        int error = 0;

        if (origin == null)
            error += 1000;
        if (dateFrom == null)
            error += 100;
        if (dateTo == null)
            error += 10;
        if (destination == null)
            error += 1;
        if (error == 1111){
            if (repfli.getMap() == null)
                throw new EmptyList();
            return repfli.getMap();
        }
        if (error == 110) {
            throw new MissingDateFromAndTo();
        }
        if (error == 101) {
            throw new MissingDateFromAndDest();
        }
        if (error == 100) {
            throw new MissingDateFrom();
        }
        if (error == 10) {
            throw new MissingDateTo();
        }
        if (error == 11) {
            throw new MissingDateToAndDestination();
        }
        if (error == 1000) {
            throw new MissingOrigin();
        }
        if (error == 1001) {
            throw new MissingOriginAndDestination();
        }
        if (error == 1010) {
            throw new MissingOriginAndDateTo();
        }
        if (error == 1011) {
            throw new MissingOriginDestinationDateTo();
        }
        if (error == 1100) {
            throw new MissingOriginDateFrom();
        }
        if (error == 1101) {
            throw new MissingOriginDateFromDestination();
        }
        if (error == 1110) {
            throw new MissingOriginDateFromDateto();
        }
        if (error == 0) {
            if (dateFrom.after(dateTo))
                throw new WrongDates();
            Set ret = repfli.getMap().values().stream()
                    .filter(flights -> flights.getOrigin().equals(origin))
                    .filter(flights -> dateFrom.after(flights.getLeaving()) || dateFrom.equals(flights.getLeaving()))
                    .filter(flights -> dateTo.before(flights.getReturning()) || dateTo.equals(flights.getReturning()))
                    .filter(flights -> flights.getDestiny().equals(destination))
                    .collect(Collectors.toSet());
            if (ret.isEmpty())
                throw new EmptyList();
            return ret;
        }
        throw new MissingDestination();
    }

    /**
     *  This method handles reservation, and checks dates for reservation are available
     * for desired flightNumber
     * @param entry: This is a FlightResDTO, with all information needed regarding a reservation
     * @return : Returns an updated FlightResDTO with costs of reservation in case it success,
     * throws error otherwise
     */

    public FlightResDTO makeReservation(FlightResDTO entry) {
        int remianingPayments;
        if (entry.getFlightReservation().getPaymentMethod().getType() == "DEBIT") {
            if (entry.getFlightReservation().getPaymentMethod().getDues() != 1)
                throw new WrongDuesDebit();
            else
                entry.setInterest(1);
        } else {
            remianingPayments = entry.getFlightReservation().getPaymentMethod().getDues();
            while (remianingPayments >= 0){
                remianingPayments -= 3;
                entry.setInterest(entry.getInterest() + 5);
            }
        }
        FlightReservationDTO flightRes = entry.getFlightReservation();
        Set available = (Set) filterFlights(flightRes.getDateFrom(), flightRes.getDateTo(), flightRes.getDestination(), flightRes.getOrigin());
        Flights flight = repfli.findId(flightRes.getFlightNumber());
        if (!available.contains(flight))
            throw new NotAvailable();
        System.out.println(flight);
        entry.setAmount(flightRes.getSeats() * flight.getPrice());
        entry.setTotal(entry.getAmount() * entry.getInterest());
        entry.setStatusCode(new StatusDTO());

        Reservations newRes = Swapper.fliResFromDTO(flightRes);
        newRes.setTotalEarnings(entry.getTotal());
        repRes.addElement(newRes);

        return entry;
    }

    public void deleteFlightReservation(int id) {
        repRes.deleteReservation(id);
    }


    public FlightReservationDTO newFlight(FlightReservationDTO entry){
        Flights toAdd = Swapper.flightsFromDTO(entry);
        toAdd.setReservations(new ArrayList<>());
        repfli.addElement(toAdd);
        return entry;
    }

    public FlightReservationDTO updateFlight(FlightReservationDTO entry, String id){
        Flights toAdd = Swapper.flightsFromDTO(entry);
        toAdd.setReservations(new ArrayList<>());
        repfli.update(toAdd);
        return entry;
    }

    public FlightReservationDTO updateFlightRes(FlightReservationDTO entry, String id){
        Reservations toAdd = Swapper.fliResFromDTO(entry);
        repRes.update(toAdd);
        return entry;
    }

    public void deleteFlight(String flightNumber) {
        repfli.delete(flightNumber);
    }


}
