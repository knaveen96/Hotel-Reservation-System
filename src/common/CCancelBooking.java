package common;

public class CCancelBooking implements Command {

    private Guest currGuest;
    private SessionObj currSession;

    CCancelBooking(Guest guest, SessionObj session) {
        this.currGuest = guest;
        this.currSession = session;
    }
    @Override
    public void execute() {
        currGuest.cancelReservation(currSession);        
    }
}