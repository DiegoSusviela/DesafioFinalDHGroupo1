package Travel.TripReservations.utils;

import Travel.TripReservations.DTOs.*;
import Travel.TripReservations.models.Flights;
import Travel.TripReservations.models.Hotels;
import Travel.TripReservations.models.Reservations;
import Travel.TripReservations.repo.RepoFlights;
import Travel.TripReservations.repo.RepoHotels;
import Travel.TripReservations.services.ServiceFlights;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.mockito.InjectMocks;

import javax.persistence.OneToMany;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

public class Utils {

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
        FlightReservationDTO res = new FlightReservationDTO(dateFrom, dateTo, "Buenos Aires", "Puerto Iguazu", "BAPI-1235", 5, 50.0,"Economy", people, method);
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
        BookingsDTO booking = new BookingsDTO(dateFrom, dateTo, "Puerto Iguazú", "CH-0002", 3, "Doble", new ArrayList<>(people), method, 0);
        UsersDTO entry = new UsersDTO();
        entry.setUserName("carlos");
        entry.setBooking(booking);
        return entry;
    }

    public Hotels createHotel(RepoHotels repoHotels,  String dateF, String dateT) throws ParseException {
        Date dateFrom = createDate(dateF);
        Date dateTo = createDate(dateT);

        Hotels hot = new Hotels(44,"IB420", "Copa", "Madrid", "ALTOCUARTO", 20.0, dateFrom, dateTo, false, new ArrayList<>());
        repoHotels.addElement(hot);
        return hot;
    }
}
