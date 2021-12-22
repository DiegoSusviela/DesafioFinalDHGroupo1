package Travel.TripReservations.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthEarningDTO {
    protected int month;
    protected int year;
    protected double total_income;
}
