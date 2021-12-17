package Travel.TripReservations.exceptionHandlers;

public class WrongDuesDebit extends IllegalArgumentException {
    protected int code;
    public WrongDuesDebit(){
        super("Cantidad de cuotas diferente a 1 con debito");
        this.code = 696;
    }
}
