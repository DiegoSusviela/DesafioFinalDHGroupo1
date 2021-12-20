package Travel.TripReservations.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PackageDTO {
    protected int packageNumber;
    protected String name;
    protected Date creation_date;
    protected int client_id;
    protected List<BookResDTO> bookingsOrReservations;
    protected double totalAmount;
}
