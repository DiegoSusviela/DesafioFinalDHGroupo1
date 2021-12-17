package Travel.TripReservations.exceptionHandlers;

public class MissingDateFromAndTo extends RuntimeException{
    /*Exception that handles missing dateTo and dateFrom*/
    protected int code;
    public MissingDateFromAndTo(){
        super("Missing Date from and to");
        this.code = 103;
    }
}
