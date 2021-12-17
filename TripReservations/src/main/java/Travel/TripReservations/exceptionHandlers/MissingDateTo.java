package Travel.TripReservations.exceptionHandlers;

public class MissingDateTo extends RuntimeException{
    /*Exception that handles missing dateTo*/
    protected int code;
    public MissingDateTo(){
        super("Missing Date to");
        this.code = 104;
    }
}
