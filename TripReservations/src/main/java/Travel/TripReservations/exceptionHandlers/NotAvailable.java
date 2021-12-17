package Travel.TripReservations.exceptionHandlers;

public class NotAvailable extends IllegalArgumentException {
    protected int code;
    public NotAvailable(){
        super("Not available for reservation");
        this.code = 106;
    }
}
