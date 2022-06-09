
package common;

public interface Guest {

    int display(SessionObj session);
    void browseRooms();
    void reserveRoom(SessionObj session);
    void modifyReservation(SessionObj session);
    void cancelReservation(SessionObj session);
    
}