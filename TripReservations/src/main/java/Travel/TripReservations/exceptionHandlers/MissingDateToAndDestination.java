package Travel.TripReservations.exceptionHandlers;

public class MissingDateToAndDestination extends RuntimeException{
    /*Exception that handles missing destination and dateTo*/
    protected int code;
    public MissingDateToAndDestination(){
        super("Missing Date to and destination");
        this.code = 105;
    }
}
