package Travel.TripReservations.exceptionHandlers;

public class MissingDateFromAndDest extends RuntimeException{
    /*Exception that handles missing destination and dateFrom*/
    protected int code;
    public MissingDateFromAndDest(){
        super("Missing Date from and destination");
        this.code = 102;
    }
}
