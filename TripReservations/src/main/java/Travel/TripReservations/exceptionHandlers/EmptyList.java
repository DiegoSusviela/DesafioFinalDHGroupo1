package Travel.TripReservations.exceptionHandlers;

public class EmptyList extends RuntimeException{
    /*Exception that handles missing dateFrom*/
    protected int code;
    public EmptyList(){
        super("Empty list returned");
        this.code = 101;
    }
}
