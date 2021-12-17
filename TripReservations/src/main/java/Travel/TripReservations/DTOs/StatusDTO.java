package Travel.TripReservations.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusDTO {
    /*Status class definition*/
    private int code = 200;
    private String message = "Operation finished Successfully";
}
