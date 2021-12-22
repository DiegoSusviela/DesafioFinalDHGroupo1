package Travel.TripReservations.services;
/* Implementation of hotel services modules */

import Travel.TripReservations.DTOs.*;
import Travel.TripReservations.exceptionHandlers.*;
import Travel.TripReservations.models.*;
import Travel.TripReservations.repo.RepoBooking;
import Travel.TripReservations.repo.RepoHotels;
import Travel.TripReservations.utils.Swapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class ServiceHotels implements ServiceHotelsI {
    /*Service class for hotels, implements all services regarding hotel class*/

    @Autowired
    private RepoHotels rephot;

    @Autowired
    private RepoBooking repBoo;

    public ServiceHotels(RepoHotels repo){
        rephot = repo;
    }

    /**
     * Method used to filter by dateFrom, dateTo and destination, receives
     * all 3 parameters.
     * @param dateFrom: Initial date where hotel should be free
     * @param dateTo: Final date up to which the hotel should be free
     * @param destination: Destination of hotels to be filtered
     * @return : This method returns a set of hotels filling the criteria
     */

    public Object filterHotels(Date dateFrom, Date dateTo, String destination) throws RuntimeException {
        int error = 0;
        if (dateFrom == null)
            error += 100;
        if (dateTo == null)
            error += 10;
        if (destination == null)
            error += 1;
        if (error == 111){
            if (rephot.getMap() == null)
                throw new EmptyList();
            return rephot.getMap();
        }
        if (error == 110)
            throw new MissingDateFromAndTo();
        if (error == 101)
            throw new MissingDateFromAndDest();
        if (error == 100)
            throw new MissingDateFrom();
        if (error == 11)
            throw new MissingDateToAndDestination();
        if (error == 10)
            throw new MissingDateTo();
        if (error == 0) {
            if (dateFrom.after(dateTo))
                throw new WrongDates();
            Set<Hotels> ret = rephot.getWithParams(dateFrom, dateTo, destination);
            for (Hotels h : ret)
                rephot.addElement(h);
            if (ret.isEmpty()) {
                throw new EmptyList();
            }
            return ret;
        }
        throw new MissingDestination();
    }

    /**
     *  This method handles reservation, and checks dates for reservation are available
     * for desired hotelcode
     * @param entry: This is a userDTO, with all information needed regarding a reservation
     * @return : Returns an updated UserDTO with costs of reservation in case it success,
     * throws error otherwise
     */
    public UsersDTO makeReservation(UsersDTO entry){
        int remianingPayments;
        if (entry.getBooking().getPeopleAmount() != 1 && entry.getBooking().getRoomType() == "Single" ||
            entry.getBooking().getPeopleAmount() != 2 && entry.getBooking().getRoomType() == "Doble" ||
            entry.getBooking().getPeopleAmount() != 3 && entry.getBooking().getRoomType() == "Triple")
            throw new UnmatchedPeopleRoom();
        if (entry.getBooking().getPaymentMethod().getType() == "DEBIT") {
            if (entry.getBooking().getPaymentMethod().getDues() != 1)
                throw new WrongDuesDebit();
        } else {
            remianingPayments = entry.getBooking().getPaymentMethod().getDues();
            while (remianingPayments >= 0){
                remianingPayments -= 3;
                entry.setInterest(entry.getInterest() + 5);
            }
        }
        BookingsDTO booking = entry.getBooking();
        Set available = (Set) filterHotels(booking.getDateFrom(), booking.getDateTo(), booking.getDestination());

        Hotels hotel = rephot.findId(booking.getHotelCode());

        if (!available.contains(hotel))
            throw new NotAvailable();
        hotel.setReserved(true);


        double tripDuration = TimeUnit.MILLISECONDS.toDays(Math.abs(booking.getDateTo().getTime() - booking.getDateFrom().getTime()));
        entry.setAmount(booking.getPeopleAmount() * hotel.getPrice() * tripDuration);
        entry.setTotal(entry.getAmount() * entry.getInterest());
        entry.setStatusCode(new StatusDTO());
        Bookings newBooking = Swapper.bookFromDTO(booking);
        booking.setTotalEarning(entry.getTotal());

        newBooking.setHotel(rephot.findId(newBooking.getHotelCode()));
        repBoo.addElement(newBooking);

        return entry;
    }

    public HotelDTO newHotel(HotelDTO entry){
        Hotels toAdd = Swapper.hotelFromDTO(entry);
        toAdd.setBookings(new ArrayList<>());
        rephot.addElement(toAdd);
        return entry;
    }

    public HotelDTO updateHotel(HotelDTO entry, int id){
        Hotels toAdd = Swapper.hotelFromDTO(entry);
        toAdd.setBookings(new ArrayList<>());
        toAdd.setId(id);
        rephot.update(toAdd);
        return entry;
    }

    public BookingsDTO updateBook(BookingsDTO entry, int hotelCode){
        Bookings toAdd = Swapper.bookFromDTO(entry);
        toAdd.setId(hotelCode);
        System.out.println(toAdd);
        repBoo.update(toAdd);
        return entry;
    }

    public void deleteHotel(String hotelCode) {
        rephot.delete(rephot.findId(hotelCode));
    }

    public void deleteHotelBooking(int id){
        repBoo.deleteBooking(id);
    }

    public List<BookingsDTO> getHotelReservations () {
       List<BookingsDTO> bookingsDTO = new ArrayList<>();
       List<Bookings> bookings = repBoo.findAll();
        System.out.println(bookingsDTO);
        for (Bookings b : bookings) {
           bookingsDTO.add(Swapper.bookToDTO(b));
       }
       return bookingsDTO;
    }






}
