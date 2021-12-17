package Travel.TripReservations.DTOs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeopleDTO {
    /*People class definition*/
    private String dni;
    private String name;
    private String lastname;
    private String birthDate;
    @Email(message = "Por favor ingrese un e-mail válido")
    private String mail;
}
