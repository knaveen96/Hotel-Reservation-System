package common;

public class CReserveRoom implements Command {

    private Guest currGuest;
    private SessionObj currSession;
    CReserveRoom(Guest guest, SessionObj session) {
        this.currGuest = guest;
        this.currSession = session;
    }
    @Override
    public void execute() {
        currGuest.reserveRoom(currSession);        
    }
}