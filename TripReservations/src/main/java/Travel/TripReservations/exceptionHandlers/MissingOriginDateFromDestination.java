package Travel.TripReservations.exceptionHandlers;

public class MissingOriginDateFromDestination extends RuntimeException{
    /*Exception that handles missing dateFrom*/
    protected int code;

    public MissingOriginDateFromDestination() {
        super("Missing Origin, destination and date from");
        this.code = 1101;
    }
}
