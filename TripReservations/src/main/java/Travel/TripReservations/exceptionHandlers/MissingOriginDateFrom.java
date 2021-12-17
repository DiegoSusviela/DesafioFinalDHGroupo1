package Travel.TripReservations.exceptionHandlers;

public class MissingOriginDateFrom extends RuntimeException{
    /*Exception that handles missing dateFrom*/
    protected int code;

    public MissingOriginDateFrom() {
        super("Missing Origin and date from");
        this.code = 1101;
    }
}
