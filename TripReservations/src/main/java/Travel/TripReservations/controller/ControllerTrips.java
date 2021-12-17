package Travel.TripReservations.controller;
/* module containing controller class for rest api */

import Travel.TripReservations.DTOs.BookingsDTO;
import Travel.TripReservations.DTOs.FlightResDTO;
import Travel.TripReservations.DTOs.UsersDTO;
import Travel.TripReservations.services.ServiceFlights;
import Travel.TripReservations.services.ServiceHotels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;


@RestController
@RequestMapping("/api/v1")
public class ControllerTrips {
    /* ControllerTrips class definition */
    @Autowired
    private ServiceHotels servHot;

    @Autowired
    private ServiceFlights servFli;

    /**
     * Entry point for /hotels in the rest api
     * @param dateFrom: Optional parameter to list hotels filtered
     * @param dateTo: Optional parameter to list hotels filtered
     * @param destination: Optional parameter to list hotels filtered
     * @return : Returns a list of hotels filling the criteria passed, in case 1 or 2 parameters
     * passed throws specific exception
     **/
    @GetMapping("/hotels")
    public ResponseEntity<Object> listHotelsParams(@RequestParam (required = false) Date dateFrom,
                                   @RequestParam (required = false) Date dateTo,
                                   @Valid @RequestParam (required = false) String destination) {
        return new ResponseEntity<>(servHot.filterHotels(dateFrom, dateTo, destination), HttpStatus.OK);
    }

    /**
     *  Entry point for /booking, receives a usersDTO with specifications of a reservation
     * and calculates total cost
     * @param entry: UsersDTO with information needed to calculate the total amount to be charged
     * for the reservation
     * @return : returns a UserDTO with the total calculation of the costs associated
     * with the reservation made
     */

    @PostMapping("/booking")
    public ResponseEntity<UsersDTO> reservaHotel(@RequestBody UsersDTO entry) {
        return new ResponseEntity<>(servHot.makeReservation(entry), HttpStatus.OK);
    }

    /**
     * Entry point for /flights in the rest api
     * @param dateFrom: Optional parameter to list flights filtered
     * @param dateTo: Optional parameter to list flights filtered
     * @param destination: Optional parameter to list flights filtered
     * @param origin: Optional parameter to list flights filtered
     * @return : Returns a list of flights filling the criteria passed, in case 1, 2 or 3 parameters
     * passed throws specific exception
     * */

    @GetMapping("/flights")
    public ResponseEntity<Object> listFlights(@RequestParam (required = false) Date dateFrom,
                              @RequestParam (required = false) Date dateTo,
                              @RequestParam (required = false) String destination,
                              @RequestParam (required = false) String origin) {
        return new ResponseEntity<>(servFli.filterFlights(dateFrom, dateTo, destination, origin), HttpStatus.OK);
    }

    /**
     *  Entry point for /flight-reservation, receives a FlightResDTO with specifications of a reservation
     * and calculates total cost
     * @param entry: FlightResDTO with information needed to calculate the total amount to be charged
     * for the reservation
     * @return : returns a FlightResDTO with the total calculation of the costs associated
     * with the reservation made
     */

    @PostMapping("/flight-reservation")
    public ResponseEntity<FlightResDTO> reservaFlights(@RequestBody FlightResDTO entry) {
        return new ResponseEntity<>(servFli.makeReservation(entry), HttpStatus.OK);
    }
    /*
    @GetMapping("/hotel-bookings/")
    public ResponseEntity<BookingsDTO> listBookings(){
        return new ResponseEntity<>(servHot.)
    }*/
}
