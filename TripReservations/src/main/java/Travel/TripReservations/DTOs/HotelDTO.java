package Travel.TripReservations.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private @JsonFormat(pattern = "MM/dd/yyyy", timezone = "GMT-3")
    Date disponibilityDateFrom;
    private @JsonFormat(pattern = "MM/dd/yyyy", timezone = "GMT-3")
    Date disponibilityDateTo;
    protected boolean isBooking;
}
