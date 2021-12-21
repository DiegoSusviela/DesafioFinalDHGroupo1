package Travel.TripReservations.models;

import Travel.TripReservations.DTOs.PaymentDTO;
import Travel.TripReservations.DTOs.PeopleDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "bookings")
public class Bookings {
    /*Bookings class definition*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT-3")
    Date dateFrom;
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT-3")
    Date dateTo;
    @NotBlank(message = "El destino elegido no existe")
    private String destination;
    private String hotelCode;
    @Positive(message = "La cantidad de personas debe ser un valor numérico.")
    private int peopleAmount;
    private String roomType;
    @ManyToMany (mappedBy = "bookings")
    private List<People> people;
    @OneToOne
    @JoinColumn(name="payment_id", referencedColumnName = "id")
    @JsonIgnore
    private Payment paymentMethod;
    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    @JsonIgnore
    private Hotels hotel;

    private double totalEarning;

}
