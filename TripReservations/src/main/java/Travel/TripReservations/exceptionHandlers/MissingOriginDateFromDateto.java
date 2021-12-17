package Travel.TripReservations.exceptionHandlers;

public class MissingOriginDateFromDateto extends RuntimeException{
    /*Exception that handles missing dateFrom*/
    protected int code;

    public MissingOriginDateFromDateto() {
        super("Missing Origin, date to and date from");
        this.code = 1110;
    }
}
