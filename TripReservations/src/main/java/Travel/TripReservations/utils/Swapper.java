package Travel.TripReservations.utils;

import Travel.TripReservations.DTOs.*;
import Travel.TripReservations.models.*;
import Travel.TripReservations.models.Package;

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
        book.setTotalEarning(toSwapp.getTotalEarning());
        return book;
    }

    public static BookingsDTO bookToDTO (Bookings toSwapp){
        BookingsDTO book = new BookingsDTO();
        book.setDateFrom(toSwapp.getDateFrom());
        book.setDateTo(toSwapp.getDateTo());
        book.setDestination(toSwapp.getDestination());
        book.setHotelCode(toSwapp.getHotelCode());
        book.setPeopleAmount(toSwapp.getPeopleAmount());
        book.setRoomType(toSwapp.getRoomType());
        book.setPeople(peopleToDTO(toSwapp.getPeople()));
        book.setPaymentMethod(paymentToDTO(toSwapp.getPaymentMethod()));
        book.setTotalEarning(toSwapp.getTotalEarning());
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

    public static PeopleDTO personToDTO(People toSwap){
        PeopleDTO person = new PeopleDTO();
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

    public static ArrayList<PeopleDTO> peopleToDTO(List<People> toSwap){
        ArrayList<PeopleDTO> ret = new ArrayList<>();

        for (People p : toSwap)
            ret.add(personToDTO(p));
        return ret;
    }

    public static Payment paymentFromDTO(PaymentDTO toSwap){
        Payment payment = new Payment();
        payment.setType(toSwap.getType());
        payment.setNumber(toSwap.getNumber());
        payment.setDues(toSwap.getDues());
        return payment;
    }

    public static PaymentDTO paymentToDTO(Payment toSwap){
        PaymentDTO payment = new PaymentDTO();
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

    public static Hotels hotelFromDTO(HotelDTO toSwap){
        Hotels ret = new Hotels();
        ret.setHotelCode(toSwap.getHotelcode());
        ret.setName(toSwap.getName());
        ret.setLocation(toSwap.getPlace());
        ret.setRoom(toSwap.getRoomType());
        ret.setPrice(toSwap.getRoomPrice());
        ret.setFreeFrom(toSwap.getDisponibilityDateFrom());
        ret.setFreeTo(toSwap.getDisponibilityDateTo());
        ret.setReserved(toSwap.isBooking());
        return ret;
    }

    public static Flights flightsFromDTO(FlightReservationDTO toSwap){
        Flights ret = new Flights();
        ret.setId(toSwap.getFlightNumber());
        ret.setOrigin(toSwap.getOrigin());
        ret.setDestiny(toSwap.getDestination());
        ret.setPrice(toSwap.getFlightPrice());
        ret.setSeat(toSwap.getSeatType());
        ret.setLeaving(toSwap.getDateFrom());
        ret.setReturning(toSwap.getDateTo());
        return ret;
    }

    public static BookRes bookResFromDTO(BookResDTO toSwap){
        BookRes ret = new BookRes();
        ret.setBookResId1(toSwap.getBookResId1());
        ret.setBookResId2(toSwap.getBookResId2());
        return ret;
    }


    public static ArrayList<BookRes> bookOrResFromDTO(List<BookResDTO> toSwap){
        ArrayList<BookRes> ret = new ArrayList<>();

        for (BookResDTO p : toSwap)
            ret.add(bookResFromDTO(p));
        return ret;

    }

    public static Package packageFromDTO(PackageDTO toSwap){
        Package ret = new Package();
        ret.setClient_id(toSwap.getClient_id());
        ret.setPackageNumber(toSwap.getPackageNumber());
        ret.setName(toSwap.getName());
        ret.setCreation_date(toSwap.getCreation_date());
        ret.setBookingsOrReservations(bookOrResFromDTO(toSwap.getBookingsOrReservations()));
        return ret;
    }

    public static BookResDTO bookResToDTO(BookRes toSwap) {
        BookResDTO ret = new BookResDTO();
        ret.setBookResId1(toSwap.getBookResId1());
        ret.setBookResId2(toSwap.getBookResId2());
        return ret;
    }

    public static ArrayList<BookResDTO> bookOrResToDTO(List<BookRes> toSwap) {
        ArrayList<BookResDTO> ret = new ArrayList<>();

        for (BookRes p : toSwap)
            ret.add(bookResToDTO(p));
        return ret;
    }

    public static PackageDTO packageToDTO(Package toSwap){
        PackageDTO ret = new PackageDTO();
        ret.setClient_id(toSwap.getClient_id());
        ret.setPackageNumber(toSwap.getPackageNumber());
        ret.setName(toSwap.getName());
        ret.setCreation_date(toSwap.getCreation_date());
        ret.setBookingsOrReservations(bookOrResToDTO(toSwap.getBookingsOrReservations()));
        return ret;
    }
    public static FlightReservationDTO flightToDTO(Flights toSwap){
        FlightReservationDTO ret = new FlightReservationDTO();
        ret.setFlightNumber(toSwap.getId());
        ret.setOrigin(toSwap.getOrigin());
        ret.setDestination(toSwap.getDestiny());
        ret.setFlightPrice(toSwap.getPrice());
        ret.setSeatType(toSwap.getSeat());
        ret.setDateFrom(toSwap.getLeaving());
        ret.setDateTo(toSwap.getReturning());
        return ret;
    }
}
