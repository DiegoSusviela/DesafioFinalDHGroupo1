package Travel.TripReservations.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingsDTO {
    /*Bookings class definition*/
    private @JsonFormat(pattern = "MM/dd/yyyy", timezone = "GMT-3")
    Date dateFrom;
    private @JsonFormat(pattern = "MM/dd/yyyy", timezone = "GMT-3")
    Date dateTo;
    @NotBlank(message = "El destino elegido no existe")
    private String destination;
    private String hotelCode;
    @Positive(message = "La cantidad de personas debe ser un valor numérico.")
    private int peopleAmount;
    private String roomType;
    private ArrayList<PeopleDTO> people;
    private PaymentDTO paymentMethod;

    private double totalEarning;
}
