package Travel.TripReservations.DTOs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightResDTO {
    /*FlightResDTO class definition*/
    private String userName;
    private double amount;
    private double interest = 0;
    private double total;
    private FlightReservationDTO flightReservation;
    private StatusDTO statusCode;

}
