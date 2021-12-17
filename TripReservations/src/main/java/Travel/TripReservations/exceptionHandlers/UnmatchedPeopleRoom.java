package Travel.TripReservations.exceptionHandlers;

public class UnmatchedPeopleRoom extends IllegalArgumentException {
    protected int code;

    public UnmatchedPeopleRoom() {
        super("El tipo de habitación seleccionada no coincide con la cantidad de personas que se alojarán en ella.");

    }
}
