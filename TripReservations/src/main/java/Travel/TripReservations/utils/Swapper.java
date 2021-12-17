package Travel.TripReservations.utils;

import Travel.TripReservations.DTOs.BookingsDTO;
import Travel.TripReservations.DTOs.FlightReservationDTO;
import Travel.TripReservations.DTOs.PaymentDTO;
import Travel.TripReservations.DTOs.PeopleDTO;
import Travel.TripReservations.models.Bookings;
import Travel.TripReservations.models.Payment;
import Travel.TripReservations.models.People;
import Travel.TripReservations.models.Reservations;

import java.util.ArrayList;
import java.util.List;

public class Swapper {
    public static Bookings bookFromDTO (BookingsDTO toSwapp){
        Bookings book = new Bookings();
        book.setDateFrom(toSwapp.getDateFrom());
        book.setDateTo(toSwapp.getDateTo());
        book.setDestination(toSwapp.getDestination());
        book.setHotelCode(toSwapp.getHotelCode());
        book.setPeopleAmount(toSwapp.getPeopleAmount());
        book.setRoomType(toSwapp.getRoomType());
        book.setPeople(peopleFromDTO(toSwapp.getPeople()));
        book.setPaymentMethod(paymentFromDTO(toSwapp.getPaymentMethod()));
        return book;
    }

    public static People personFromDTO(PeopleDTO toSwap){
        People person = new People();
        person.setDni(toSwap.getDni());
        person.setName(toSwap.getName());
        person.setLastname(toSwap.getLastname());
        person.setBirthDate(toSwap.getBirthDate());
        person.setMail(toSwap.getMail());
        return person;
    }
    public static ArrayList<People> peopleFromDTO(ArrayList<PeopleDTO> toSwap){
        ArrayList<People> ret = new ArrayList<>();

        for (PeopleDTO p : toSwap)
            ret.add(personFromDTO(p));
        return ret;
    }

    public static Payment paymentFromDTO(PaymentDTO toSwap){
        Payment payment = new Payment();
        payment.setType(toSwap.getType());
        payment.setNumber(toSwap.getNumber());
        payment.setDues(toSwap.getDues());
        return payment;
    }

    public static Reservations fliResFromDTO(FlightReservationDTO toSwap){
        Reservations res = new Reservations();
        res.setDateFrom(toSwap.getDateFrom());
        res.setDateTo(toSwap.getDateTo());
        res.setOrigin(toSwap.getOrigin());
        res.setDestination(toSwap.getDestination());
        res.setFlightNumber(toSwap.getFlightNumber());
        res.setSeats(toSwap.getSeats());
        res.setPeople(peopleFromDTO(toSwap.getPeople()));
        res.setPaymentMethod(paymentFromDTO(toSwap.getPaymentMethod()));
        return res;
    }
}
