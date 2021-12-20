package Travel.TripReservations.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {
    protected String hotelcode;
    protected String name;
    protected String place;
    protected String roomType;
    protected Double roomPrice;
    protected Date disponibilityDateFrom;
    protected Date disponibilityDateTo;
    protected boolean isBooking;
}
