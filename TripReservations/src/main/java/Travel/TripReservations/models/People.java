package Travel.TripReservations.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String dni;
    private String name;
    private String lastname;
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT-3")
    private String birthDate;
    private String mail;
    @ManyToMany
    @JoinTable (
            name="booking_people",
            joinColumns = @JoinColumn(name="booking_id"),
            inverseJoinColumns = @JoinColumn(name= "people_id")

    )
    private List<Bookings> bookings;
    @ManyToMany
    @JoinTable (
            name="reservation_people",
            joinColumns = @JoinColumn(name="reservation_id"),
            inverseJoinColumns = @JoinColumn(name= "people_id")

    )
    private List<Reservations> reservations;
}
