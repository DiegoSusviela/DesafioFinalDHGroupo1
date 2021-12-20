package Travel.TripReservations.models;

import Travel.TripReservations.DTOs.PaymentDTO;
import Travel.TripReservations.DTOs.PeopleDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "reservations")
public class Reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
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
    private String seatType;
    @ManyToMany (mappedBy = "reservations")
    private List<People> people;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "payment_id", referencedColumnName = "id")
    private Payment paymentMethod;
    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flights flights;

    protected double totalEarnings;

    public Reservations(Date dateFrom, Date dateTo, String origin, String destination, String flightNumber, int seats, String seatType, ArrayList<People> people, Payment paymentMethod) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.origin = origin;
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.seats = seats;
        this.seatType = seatType;
        this.people = people;
        this.paymentMethod = paymentMethod;
    }
}
