package Travel.TripReservations.exceptionHandlers;

public class MissingDestination extends RuntimeException{
    /*Exception that handles missing destination*/
    protected int code;
    public MissingDestination(){
        super("Missing Destination");
        this.code = 100;
    }
}
