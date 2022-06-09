package common;

public interface Admin {
	void deleteRoom();
    void addRoom(String operation);
    void addUser(String type);
    void browseRooms();
    void viewUsers(String type);
    int display(SessionObj session);
    void deleteUser(String type);
}