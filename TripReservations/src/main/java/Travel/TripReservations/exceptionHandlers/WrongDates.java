package Travel.TripReservations.exceptionHandlers;

public class WrongDates extends IllegalArgumentException {
    protected int code;
    public WrongDates(){
        super("Date from shouldnt be before Date to");
        this.code = 696;
    }
}
