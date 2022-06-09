package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface HotelBooking extends Remote {

	boolean deleteRoom(String roomNo) throws RemoteException;
    List<String> viewUsers(String type) throws RemoteException;
    boolean deleteUser(String type, String email) throws RemoteException;
    String checkRoomAvailability(String roomNo, int days, boolean isNew) throws RemoteException;
    boolean reserveRoom(String roomNo, String email, int days, String address, String mobileNo, String cardNo) throws RemoteException;
    List<String> viewBookings(String role, String email) throws RemoteException;
    boolean adminRegister(String userName, String email, String password) throws RemoteException;
    boolean guestRegister(String userName, String email, String password) throws RemoteException;
    boolean adminLogin(String userName, String password) throws RemoteException;
    boolean guestLogin(String userName, String password) throws RemoteException;
    SessionObj processLogin(String userType, String userName) throws RemoteException;
    List<String> browseRooms() throws RemoteException;
    boolean addRoom(String operation, String roomNo, String type, String description, String price, String rating, String noOfBeds,
    String typeOfBed, String isSmokingAllowed, String isAvailable) throws RemoteException;
    String modifyReservation(String roomNo, String newRoonNo, String email, int days) throws RemoteException;
    String cancelReservation(String roomNo, String email) throws RemoteException;
}
