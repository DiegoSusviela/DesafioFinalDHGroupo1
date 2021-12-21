package Travel.TripReservations.controller;

import Travel.TripReservations.DTOs.*;
import Travel.TripReservations.models.Hotels;
import Travel.TripReservations.repo.RepoHotels;
import Travel.TripReservations.services.ServiceHotels;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTripsTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void listHotelsParamsTest() throws Exception{
        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("dateFrom", "1/3/2022");
        requestParams.add("dateTo", "05/04/2023");
        requestParams.add("destination", "Medellín");
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/hotels")
                .params(requestParams)).andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.[0].price").value(8600.0));
    }

    @Test
    void listFlightsParamsTest() throws Exception{
        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("dateFrom", "02/11/2022");
        requestParams.add("dateTo", "02/14/2022");
        requestParams.add("destination", "Puerto Iguazu");
        requestParams.add("origin", "Buenos Aires");
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/flights")
                .params(requestParams)).andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.[0].price").value(6500.0));
    }

    @Test
    void reservaHotelTest() throws Exception {

        String value = "11/02/2022";
        SimpleDateFormat org = new SimpleDateFormat("MM/dd/yyyy");
        Date dateFrom = org.parse(value.toString());

        value = "19/03/2022";
        Date dateTo = org.parse(value.toString());


        UsersDTO user = new UsersDTO();
        user.setUserName("arjonamiguel@gmail.com");
        BookingsDTO booking = new BookingsDTO();
        booking.setDateFrom(dateFrom);
        booking.setDateTo(dateTo);
        booking.setDestination("Puerto Iguazú");
        booking.setHotelCode("CH-0002");
        booking.setPeopleAmount(2);
        booking.setRoomType("Double");
        booking.setPeople(new ArrayList<PeopleDTO>());
        PaymentDTO payment = new PaymentDTO("CREDIT", "1-256-589-3", 5);
        booking.setPaymentMethod(payment);

        user.setBooking(booking);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(user);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/booking")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.total").value(3.0618E7));

    }

    @Test
    void reservaFlightsTest() throws Exception {

        String value = "02/11/2022";
        SimpleDateFormat org = new SimpleDateFormat("MM/dd/yyyy");
        Date dateFrom = org.parse(value.toString());

        value = "02/14/2022";
        Date dateTo = org.parse(value.toString());


        FlightResDTO flight = new FlightResDTO();
        flight.setUserName("arjonamiguel@gmail.com");
        FlightReservationDTO reservation = new FlightReservationDTO();
        reservation.setDateFrom(dateFrom);
        reservation.setDateTo(dateTo);
        reservation.setDestination("Puerto Iguazu");
        reservation.setOrigin("Buenos Aires");
        reservation.setFlightNumber("BAPI-1235");
        reservation.setSeats(5);
        reservation.setSeatType("Economy");
        PeopleDTO person = new PeopleDTO("dni", "name", "lastname", "brithdate", "mail@mail.com");
        ArrayList<PeopleDTO> people = new ArrayList<>();
        people.add(person);
        reservation.setPeople(people);
        PaymentDTO payment = new PaymentDTO("CREDIT", "1-256-589-3", 5);
        reservation.setPaymentMethod(payment);


        flight.setFlightReservation(reservation);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(flight);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/flight-reservation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.total").value(325000.0));
    }

}

