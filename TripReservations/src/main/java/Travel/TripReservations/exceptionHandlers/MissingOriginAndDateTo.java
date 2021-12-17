package Travel.TripReservations.exceptionHandlers;

public class MissingOriginAndDateTo extends RuntimeException{
    /*Exception that handles missing dateFrom*/
    protected int code;

    public MissingOriginAndDateTo() {
        super("Missing Origin and date to");
        this.code = 1010;
    }
}
