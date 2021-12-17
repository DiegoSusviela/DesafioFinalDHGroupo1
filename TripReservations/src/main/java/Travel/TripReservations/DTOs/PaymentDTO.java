package Travel.TripReservations.DTOs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
    /*Payment class definition*/
    private String type;
    private String number;
    private int dues;
}
