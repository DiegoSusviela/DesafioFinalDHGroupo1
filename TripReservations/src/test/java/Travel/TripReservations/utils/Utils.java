package Travel.TripReservations.utils;

import Travel.TripReservations.DTOs.*;
import Travel.TripReservations.models.Bookings;
import Travel.TripReservations.models.Flights;
import Travel.TripReservations.models.Hotels;
import Travel.TripReservations.repo.RepoFlights;
import Travel.TripReservations.repo.RepoHotels;
import Travel.TripReservations.services.ServiceFlights;
import Travel.TripReservations.services.ServiceHotels;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

public class Utils {
    @Autowired
    ServiceHotels hotServ;

    public Date createDate(String value) throws ParseException {
        SimpleDateFormat org = new SimpleDateFormat("MM/dd/yyyy");
        return org.parse(value);
    }

    public Flights createAddFlight(RepoFlights repo, String dateF, String dateT) throws ParseException {
        Date dateFrom = createDate(dateF);
        Date dateTo = createDate(dateT);
        Flights fli = new Flights("IB420", "Madrid", "Barajas", "ALTOCUARTO", 20.0, dateFrom, dateTo, new ArrayList<>());

        repo.addElement(fli);
        return fli;
    }

    public FlightResDTO createFlightReservation(String dateF, String dateT) throws ParseException {
        Date dateFrom, dateTo;
        if (dateF != null)
            dateFrom = createDate(dateF);
        else
            dateFrom = null;
        if (dateT != null)
            dateTo = createDate(dateT);
        else
            dateTo = null;
        ArrayList<PeopleDTO> people = new ArrayList<>();
        PaymentDTO method = new PaymentDTO();
        method.setDues(1);
        method.setType("DEBIT");
        FlightResDTO entry = new FlightResDTO();
        FlightReservationDTO res = new FlightReservationDTO(dateFrom, dateTo, "Buenos Aires", "Puerto Iguazu", "BAPI-1235", 5, 50,"Economy", people, method);
        entry.setUserName("carlos");
        entry.setFlightReservation(res);
        System.out.println(entry.toString());
        return entry;
    }

    public UsersDTO createUser(String dateF, String dateT) throws ParseException {
        Date dateFrom = createDate(dateF);
        Date dateTo = createDate(dateT);

        ArrayList<PeopleDTO> people = new ArrayList<>();
        PaymentDTO method = new PaymentDTO();
        BookingsDTO booking = new BookingsDTO(dateFrom, dateTo, "Puerto Iguaz??", "CH-0002", 3, "Doble", new ArrayList<>(people), method, 0);
        UsersDTO entry = new UsersDTO();
        entry.setUserName("carlos");
        entry.setBooking(booking);
        return entry;
    }

    public Hotels createHotel(RepoHotels repoHotels,  String dateF, String dateT) throws ParseException {
        Date dateFrom = createDate(dateF);
        Date dateTo = createDate(dateT);
        //Bookings booking = new Bookings(10, dateF, dateT, "madrid", "Athc", 5, "Single", people, payment);

        //hotServ.newHotel(new HotelDTO("avichi", "name", "Madrid", "Single", 60.0, dateFrom, dateTo, false));

        Hotels hot = new Hotels();
        hot.setId(5);
        hot.setHotelCode("IB420");
        hot.setName("copa");
        hot.setLocation("Madrid");
        hot.setRoom("Single");
        hot.setPrice(20);
        hot.setReserved(false);
        hot.setFreeTo(dateTo);
        hot.setFreeFrom(dateFrom);
        return hot;
        //repoHotels.addElement(hot);
        //return hot;
    }
}
