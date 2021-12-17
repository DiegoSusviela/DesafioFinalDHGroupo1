package Travel.TripReservations.exceptionHandlers;

public class MissingOrigin extends RuntimeException {
    /*Exception that handles missing dateFrom*/
    protected int code;

    public MissingOrigin() {
        super("Missing Origin");
        this.code = 1000;
    }
}
