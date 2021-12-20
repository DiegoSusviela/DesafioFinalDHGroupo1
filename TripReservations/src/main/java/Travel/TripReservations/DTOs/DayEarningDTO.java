package Travel.TripReservations.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DayEarningDTO {
    protected Date date;
    protected double total_income;
}
