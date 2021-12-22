/*package Travel.TripReservations.services;

import Travel.TripReservations.DTOs.BookingsDTO;
import Travel.TripReservations.DTOs.PaymentDTO;
import Travel.TripReservations.DTOs.PeopleDTO;
import Travel.TripReservations.DTOs.UsersDTO;
import Travel.TripReservations.exceptionHandlers.*;
import Travel.TripReservations.models.Hotels;
import Travel.TripReservations.models.engine.IRepoHotels;
import Travel.TripReservations.repo.RepoFlights;
import Travel.TripReservations.repo.RepoHotels;
import Travel.TripReservations.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@ExtendWith(MockitoExtension.class)
public class ServiceHotelsTests {

    @InjectMocks
    ServiceHotels serviceHotels;

    @Autowired
    private Utils utils = new Utils();

    @Autowired
    RepoHotels repoHotels;

    @Autowired
    IRepoHotels iRepoHotels;

    @BeforeEach
    private void setUp() throws IOException {
        repoHotels = new RepoHotels(iRepoHotels);
        serviceHotels = new ServiceHotels(repoHotels);
    }

    @Test
    void filterHotelsTest() throws ParseException, IOException {

        Hotels hot = utils.createHotel(repoHotels, "10/20/2022", "10/24/2022");

        Set<Hotels> wopa = new HashSet<>();
        wopa.add(hot);
        System.out.println();

        Assertions.assertEquals(serviceHotels.filterHotels(utils.createDate("10/20/2022"), utils.createDate("10/24/2022"), "Madrid"), wopa);
    }

    @Test
    void filterBadHotelsTest() throws ParseException, IOException {

        EmptyList ex = Assertions.assertThrows(EmptyList.class, () -> {serviceHotels.filterHotels(utils.createDate("10/20/2026"), utils.createDate("10/24/2026"), "Madrid");});
        Assertions.assertEquals("Empty list returned", ex.getMessage());
    }

    @Test
    void filterAllHotelsTest() throws ParseException, IOException {
        Assertions.assertEquals(serviceHotels.filterHotels(null, null, null), repoHotels.getMap());
    }

    @Test
    void makeReservationTest() throws ParseException, IOException {
        UsersDTO entry = utils.createUser("11/02/2022", "19/03/2022");
        entry.getBooking().setPeopleAmount(2);

       Assertions.assertEquals(serviceHotels.makeReservation(entry).getTotal(), 1.5309E7);
    }

    @Test
    void cantMakeReservationTest() throws ParseException, IOException {
        UsersDTO entry = utils.createUser("11/02/2022", "19/03/2021");
        entry.getBooking().setPeopleAmount(2);
        entry.getBooking().setDestination("Atagualpa");
        WrongDates ex = Assertions.assertThrows(WrongDates.class, () -> {serviceHotels.makeReservation(entry);});
        Assertions.assertEquals("Date from shouldnt be before Date to", ex.getMessage());
    }

    @Test
    void invalidRoomReservationTest() throws ParseException, IOException {
        UnmatchedPeopleRoom ex = Assertions.assertThrows(UnmatchedPeopleRoom.class, () -> {serviceHotels.makeReservation(utils.createUser("11/02/2022", "19/03/2022"));});
        Assertions.assertEquals("El tipo de habitación seleccionada no coincide con la cantidad de personas que se alojarán en ella.", ex.getMessage());
    }
}
*/