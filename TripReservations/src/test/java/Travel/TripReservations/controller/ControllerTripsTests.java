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
        requestParams.add("dateFrom", "12/31/1999");
        requestParams.add("dateTo", "12/31/2001");
        requestParams.add("destination", "BSAS");
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/hotels")
                .params(requestParams)).andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.[0].price").value(60.0));
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
                .andExpect(jsonPath("$.[0].price").value(56.0));
    }

    @Test
    void reservaHotelTest() throws Exception {

        String value = "12/31/1999";
        SimpleDateFormat org = new SimpleDateFormat("MM/dd/yyyy");
        Date dateFrom = org.parse(value.toString());

        value = "12/31/2001";
        Date dateTo = org.parse(value.toString());


        UsersDTO user = new UsersDTO();
        user.setUserName("arjonamiguel@gmail.com");
        BookingsDTO booking = new BookingsDTO();
        booking.setDateFrom(dateFrom);
        booking.setDateTo(dateTo);
        booking.setDestination("BSAS");
        booking.setHotelCode("HO89");
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

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/hotel-booking/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.total").value(877200.0));

    }

    @Test
    void reservaFlightsTest() throws Exception {

        String value = "07/12/2002";
        SimpleDateFormat org = new SimpleDateFormat("MM/dd/yyyy");
        Date dateFrom = org.parse(value.toString());

        value = "07/12/2003";
        Date dateTo = org.parse(value.toString());


        FlightResDTO flight = new FlightResDTO();
        flight.setUserName("arjonamiguel@gmail.com");
        FlightReservationDTO reservation = new FlightReservationDTO();
        reservation.setDateFrom(dateFrom);
        reservation.setDateTo(dateTo);
        reservation.setDestination("dest1");
        reservation.setOrigin("ori1");
        reservation.setFlightNumber("copaA320");
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

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/flight-reservation/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.total").value(28050.0));
    }



    @Test
    void createHotelTest() throws Exception {

        String value = "12/31/1999";
        SimpleDateFormat org = new SimpleDateFormat("MM/dd/yyyy");
        Date dateFrom = org.parse(value.toString());

        value = "12/31/2001";
        Date dateTo = org.parse(value.toString());


        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setHotelcode("TestHotelCode");
        hotelDTO.setName("Mariam");
        hotelDTO.setPlace("paramo");
        hotelDTO.setRoomType("Single");
        hotelDTO.setRoomPrice(60.0);
        hotelDTO.setDisponibilityDateFrom(dateFrom);
        hotelDTO.setDisponibilityDateTo(dateTo);


        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(hotelDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/hotels/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.hotelcode").value("TestHotelCode"));

    }
    @Test
    void createFlightTest() throws Exception {

        String value = "12/31/2022";
        SimpleDateFormat org = new SimpleDateFormat("MM/dd/yyyy");
        Date dateFrom = org.parse(value.toString());

        value = "12/31/2022";
        Date dateTo = org.parse(value.toString());


        FlightReservationDTO flight = new FlightReservationDTO();
        flight.setFlightPrice(60.0);
        flight.setDateTo(dateTo);
        flight.setDateFrom(dateFrom);
        flight.setOrigin("Origen");
        flight.setDestination("Destino");
        flight.setFlightNumber("Ib420");
        flight.setSeatType("Economy");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(flight);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/flights/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.flightNumber").value("Ib420"));

    }



}

