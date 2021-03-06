package Travel.TripReservations.models;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT-3")
    protected Date creation_date;
    protected int client_id;
    @OneToMany(mappedBy = "pack")
    protected List<BookRes> bookingsOrReservations;

    protected double totalEarnings;
}
