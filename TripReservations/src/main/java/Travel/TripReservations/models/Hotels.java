package Travel.TripReservations.models;
/* This is models module containing class that will model hotels class*/


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;

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
@Table(name = "hotels")
public class Hotels {
    /*hotels class definition*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String hotelCode;
    private String name;
    @NotNull(message = "El destino elegido no existe")
    private String location;
    private String room;
    private double price;
    @Pattern(regexp = "^(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\\d\\d$", message = "Formato de fecha debe ser mm/dd/aaaa")
    private @JsonFormat(pattern = "MM/dd/yyyy", timezone = "GMT-3")
    Date freeFrom;
    @AssertTrue
    public boolean isValidRange() {
        return freeFrom.compareTo(freeTo) >= 0;
    }
    @Pattern(regexp = "^(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\\d\\d$", message = "Formato de fecha debe ser mm/dd/aaaa")
    private @JsonFormat(pattern = "MM/dd/yyyy", timezone = "GMT-3")
    Date freeTo;
    private boolean reserved;
    @OneToMany(mappedBy = "hotel")
    @JsonIgnore
    private List<Bookings> bookings;
}
