package Travel.TripReservations.exceptionHandlers;

public class MissingOriginAndDestination extends RuntimeException{
    /*Exception that handles missing dateFrom*/
    protected int code;

    public MissingOriginAndDestination() {
        super("Missing Origin and destination");
        this.code = 1001;
    }
}
