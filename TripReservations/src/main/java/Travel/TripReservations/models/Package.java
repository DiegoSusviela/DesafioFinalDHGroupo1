package Travel.TripReservations.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "packages")
public class Package {
    @Id
    protected int packageNumber;
    protected String name;
    protected Date creation_date;
    protected int client_id;
    @OneToMany(mappedBy = "pack")
    protected List<BookRes> bookingsOrReservations;

    protected double totalEarnings;
}
