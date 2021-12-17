package Travel.TripReservations.exceptionHandlers;

public class MissingDateFrom extends RuntimeException{
    /*Exception that handles missing dateFrom*/
    protected int code;
    public MissingDateFrom(){
        super("Missing Date from");
        this.code = 101;
    }
}
