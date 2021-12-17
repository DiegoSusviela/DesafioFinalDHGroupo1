package Travel.TripReservations.exceptionHandlers;

public class MissingOriginDestinationDateTo extends RuntimeException{
    /*Exception that handles missing dateFrom*/
    protected int code;

    public MissingOriginDestinationDateTo() {
        super("Missing Origin, destination and date to");
        this.code = 1011;
    }
}
