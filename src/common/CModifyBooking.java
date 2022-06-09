package common;

public class CModifyBooking implements Command {

    private Guest currentGuest;
    private SessionObj currentSession;

    CModifyBooking(Guest guest, SessionObj session) {
        this.currentGuest = guest;
        this.currentSession = session;
    }

    @Override
    public void execute() { 
        currentGuest.modifyReservation(currentSession);        
    }    
}