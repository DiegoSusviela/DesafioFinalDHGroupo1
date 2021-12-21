/*package Travel.TripReservations.services;

import Travel.TripReservations.exceptionHandlers.*;
import Travel.TripReservations.models.Flights;
import Travel.TripReservations.repo.RepoFlights;
import Travel.TripReservations.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

class ServiceFlightsTests {

    @InjectMocks
    ServiceFlights serviceFlights;

    @Autowired
    private Utils utils = new Utils();

    @Autowired
    RepoFlights repoFlights;

    @BeforeEach
    private void setUp() throws IOException {
        repoFlights = new RepoFlights();
        serviceFlights = new ServiceFlights(repoFlights);
    }

    @Test
    void filterFlightsTest() throws ParseException, IOException {
        Flights fli = utils.createAddFlight(repoFlights, "10/20/2022", "10/24/2022");

        Set<Flights> wopa = new HashSet<>();
        wopa.add(fli);

        Assertions.assertEquals(serviceFlights.filterFlights(utils.createDate("10/20/2022"), utils.createDate("10/24/2022"), "Barajas", "Madrid"), wopa);
    }

    @Test
    void filterAllFligthsTest() throws ParseException, IOException {
        Assertions.assertEquals(serviceFlights.filterFlights(null, null, null, null), repoFlights.getMap());
    }

    @Test
    void filterBadFligthsTest() throws ParseException, IOException {

        EmptyList ex = Assertions.assertThrows(EmptyList.class, () -> {serviceFlights.filterFlights(utils.createDate("10/20/2026"), utils.createDate("10/24/2026"), "Madrid", "Aconcagua");});
        Assertions.assertEquals("Empty list returned", ex.getMessage());
    }

    @Test
    void makeReservationTest() throws ParseException, IOException {
        Assertions.assertEquals(serviceFlights.makeReservation(utils.createFlightReservation("02/11/2022", "02/14/2022")).getTotal(), 32500.0);
    }

    @Test
    void makeInvalidReservationTest() throws IOException, ParseException {
        EmptyList ex = Assertions.assertThrows(EmptyList.class, () -> {serviceFlights.makeReservation(utils.createFlightReservation("11/30/2019", "02/14/2022"));});
        Assertions.assertEquals("Empty list returned", ex.getMessage());
    }

    @Test
    void noDateToReservationTest() throws IOException, ParseException {
        MissingDateTo ex = Assertions.assertThrows(MissingDateTo.class, () -> {serviceFlights.makeReservation(utils.createFlightReservation("11/30/2019", null));});

        Assertions.assertEquals("Missing Date to", ex.getMessage());
    }

    @Test
    void noDateFromReservationTest() throws IOException, ParseException {
        MissingDateFrom ex = Assertions.assertThrows(MissingDateFrom.class, () -> {serviceFlights.makeReservation(utils.createFlightReservation(null, "11/30/2019"));});

        Assertions.assertEquals("Missing Date from", ex.getMessage());
    }

    @Test
    void wrongDatesReservationTest(){
        WrongDates ex = Assertions.assertThrows(WrongDates.class, () -> {serviceFlights.makeReservation(utils.createFlightReservation("11/30/2019", "11/30/2017"));});

        Assertions.assertEquals("Date from shouldnt be before Date to", ex.getMessage());
    }

}
*/