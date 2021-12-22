package Travel.TripReservations.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book_res")
public class BookRes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected int bookResId1;
    protected int bookResId2;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "package_id", nullable = false)
    protected Package pack;
}
