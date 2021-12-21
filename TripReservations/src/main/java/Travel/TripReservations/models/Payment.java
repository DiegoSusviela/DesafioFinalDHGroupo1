package Travel.TripReservations.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    /*Payment class definition*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String type;
    private String number;
    private int dues;
    @OneToOne(mappedBy = "paymentMethod")
    @JsonIgnore
    private Bookings bookings;
    @OneToOne(mappedBy = "paymentMethod")
    @JsonIgnore
    private Reservations reservations;
}
