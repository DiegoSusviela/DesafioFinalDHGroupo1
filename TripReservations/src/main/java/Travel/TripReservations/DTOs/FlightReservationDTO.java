package Travel.TripReservations.DTOs;


import Travel.TripReservations.models.People;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightReservationDTO {
    /*FlightReservation class definition*/
    private @JsonFormat(pattern = "MM/dd/yyyy", timezone = "GMT-3")
    Date dateFrom;
    @AssertTrue
    private @JsonFormat(pattern = "MM/dd/yyyy", timezone = "GMT-3")
    Date dateTo;
    @NotNull(message = "El origen elegido no existe")
    private String origin;
    @NotNull(message = "El destino elegido no existe")
    private String destination;
    private String flightNumber;
    @Positive(message = "La cantidad de personas debe ser un valor numérico.")
    private int seats;
    private double flightPrice;
    private String seatType;
    private ArrayList<PeopleDTO> people;
    private PaymentDTO paymentMethod;
}
