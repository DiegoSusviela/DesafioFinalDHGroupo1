package Travel.TripReservations.models;
/* This is models module containing class that will model flights class*/


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "flights")
public class Flights {
    /*flights class definition*/
    @Id
    private String id;
    @NotNull(message = "El origen elegido no existe")
    private String origin;
    @NotNull(message = "El destino elegido no existe")
    private String destiny;
    private String seat;
    private double price;
    @Pattern(regexp = "^(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\\d\\d$", message = "Formato de fecha debe ser mm/dd/aaaa")
    private @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT-3")
    Date leaving;
    @AssertTrue
    public boolean isValidRange() {
        return leaving.compareTo(returning) >= 0;
    }
    @Pattern(regexp = "^(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\\d\\d$", message = "Formato de fecha debe ser mm/dd/aaaa")
    private @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT-3")
    Date returning;
    @OneToMany(mappedBy = "flights")
    private List<Reservations> reservations;

}
