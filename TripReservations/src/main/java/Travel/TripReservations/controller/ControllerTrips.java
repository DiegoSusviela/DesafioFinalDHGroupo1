package Travel.TripReservations.controller;
/* module containing controller class for rest api */

import Travel.TripReservations.DTOs.*;
import Travel.TripReservations.services.ServiceEarnings;
import Travel.TripReservations.services.ServiceFlights;
import Travel.TripReservations.services.ServiceHotels;
import Travel.TripReservations.services.ServicePackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class ControllerTrips {
    /* ControllerTrips class definition */
    @Autowired
    private ServiceHotels servHot;

    @Autowired
    private ServiceFlights servFli;

    @Autowired
    private ServicePackage servPack;

    @Autowired
    private ServiceEarnings servEarn;

    /**
     * Entry point for /hotels in the rest api
     * @param dateFrom: Optional parameter to list hotels filtered
     * @param dateTo: Optional parameter to list hotels filtered
     * @param destination: Optional parameter to list hotels filtered
     * @return : Returns a list of hotels filling the criteria passed, in case 1 or 2 parameters
     * passed throws specific exception
     **/
    @GetMapping("/hotels")
    public ResponseEntity<Object> listHotelsParams(@Valid @RequestParam (required = false) Date dateFrom,
                                   @Valid @RequestParam (required = false) Date dateTo,
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

    @PostMapping("/hotel-booking/new")
    public ResponseEntity<UsersDTO> reservaHotel(@Valid @RequestBody UsersDTO entry) {
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
    public ResponseEntity<Object> listFlights(@Valid @RequestParam (required = false) Date dateFrom,
                              @Valid @RequestParam (required = false) Date dateTo,
                              @Valid @RequestParam (required = false) String destination,
                              @Valid @RequestParam (required = false) String origin) {
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

    @PostMapping("/flight-reservation/new")
    public ResponseEntity<FlightResDTO> reservaFlights(@RequestBody FlightResDTO entry) {
        return new ResponseEntity<>(servFli.makeReservation(entry), HttpStatus.OK);
    }

    /*
    @GetMapping("/hotel-bookings/")
    public ResponseEntity<BookingsDTO> listBookings(){
        return new ResponseEntity<>(servHot.)
    }*/

    @PostMapping("/hotels/new")
    public ResponseEntity<HotelDTO> newHotel(@RequestBody HotelDTO entry){
        return new ResponseEntity<HotelDTO>(servHot.newHotel(entry), HttpStatus.OK);
    }
    @PostMapping("/flights/new")
    public ResponseEntity<FlightReservationDTO> newHotel(@RequestBody FlightReservationDTO entry){
        return new ResponseEntity<FlightReservationDTO>(servFli.newFlight(entry), HttpStatus.OK);
    }

    @GetMapping("/flight-reservations")
    public ResponseEntity<List<FlightReservationDTO>> getFlightReservations () {
        return new ResponseEntity<List<FlightReservationDTO>>(servFli.getFlightReservations(), HttpStatus.OK);
    }

    @GetMapping("/hotel-booking")
    public ResponseEntity<List<BookingsDTO>> getHotelReservations() {
        return new ResponseEntity<List<BookingsDTO>>(servHot.getHotelReservations(), HttpStatus.OK);
    }

    @PutMapping("/flights/edit")
    public ResponseEntity<FlightReservationDTO> updateFlight(@RequestBody FlightReservationDTO entry, @RequestParam String flightNumber){
        return new ResponseEntity<FlightReservationDTO>(servFli.updateFlight(entry, flightNumber), HttpStatus.OK);
    }

    @PutMapping("/flight-reservation/edit")
    public ResponseEntity<FlightReservationDTO> updateHotel(@RequestBody FlightReservationDTO entry, @RequestParam String id){
        return new ResponseEntity<FlightReservationDTO>(servFli.updateFlightRes(entry, id), HttpStatus.OK);
    }

    @PutMapping("/hotels/edit")
    public ResponseEntity<HotelDTO> updateHotel(@RequestBody HotelDTO entry, @RequestParam int hotelCode){
        return new ResponseEntity<HotelDTO>(servHot.updateHotel(entry, hotelCode), HttpStatus.OK);
    }

    @PutMapping("/hotel-booking/edit")
    public ResponseEntity<BookingsDTO> updateHotel(@RequestBody BookingsDTO entry, @RequestParam int id){
        return new ResponseEntity<BookingsDTO>(servHot.updateBook(entry, id), HttpStatus.OK);
    }

    @DeleteMapping("/flights/delete")
    public void deleteFlight(@RequestParam String flightNumber) {
         servFli.deleteFlight(flightNumber);
    }

    @DeleteMapping("/hotels/delete")
    public void deleteHotel(@RequestParam String hotelCode){
        servHot.deleteHotel(hotelCode);
    }


    @DeleteMapping("/flight-reservation/delete")
    public void deleteReservaFlights(@RequestParam int idReserva) {
        servFli.deleteFlightReservation(idReserva);
    }

    @DeleteMapping("/hotel-booking/delete")
    public void deleteHotelBooking(@RequestParam int bookingId){
        servHot.deleteHotelBooking(bookingId);
    }

    @PostMapping("/touristicpackage/new")
    public ResponseEntity<PackageDTO> newPackage(@RequestBody PackageDTO entry){
        return new ResponseEntity<PackageDTO>(servPack.newPackage(entry), HttpStatus.OK);
    }

    @PutMapping("/touristicpackage/edit")
    public ResponseEntity<PackageDTO> updatePackage(@RequestBody PackageDTO entry, @RequestParam int packageNumber) {
        return new ResponseEntity<PackageDTO>(servPack.updatePackage(entry, packageNumber), HttpStatus.OK);
    }

    @DeleteMapping("/touristicpackage/delete")
    public void deletePackage(@RequestParam int packageNumber){
        servPack.deletePackage(packageNumber);
    }

    @GetMapping("/touristicpackage")
    public ResponseEntity<Object> findPackages(@RequestParam(required = false) int packageNumber){
        return new ResponseEntity<>(servPack.findPackage(packageNumber), HttpStatus.OK);
    }

    @GetMapping("/income")
    public ResponseEntity<Object> totalEarningsDay(@RequestParam(required = false) Date date,@RequestParam(required = false) int month, @RequestParam(required = false) int year ){
        return new ResponseEntity<>(servEarn.calculateEarnings(date, month, year), HttpStatus.OK);
    }



}
