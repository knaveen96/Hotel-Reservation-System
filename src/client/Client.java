package client;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import common.Entry;
import common.HotelBooking;
import common.HotelBookingImpl;
import common.SessionObj;

public class Client {

	SessionObj mainSession = null;
    static HotelBooking stub;
    
    public static void main(String[] args) throws RemoteException {

        FrontController controller;
        Entry etr;
        controller = new FrontController();
        etr = new Entry();
        try {
            String name = "//in-csci-rrpc05.cs.iupui.edu:2596/HotelBooking";
            stub = (HotelBooking) Naming.lookup(name);
            //stub = new HotelBookingImpl();
            controller.dispatchRequest(etr.login());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SessionObj processLogin(String userType, String userName) {
        try {
            mainSession = stub.processLogin(userType, userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mainSession;
    }
    
    public boolean adminLogin(String userName, String password) {
        boolean val = true;
        try {
            val = stub.adminLogin(userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return val;
    }

    public boolean guestLogin(String userName, String password) {
        boolean val = false;
        try {
            val = stub.guestLogin(userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return val;
    }

    public List<String> browseRooms() {
        List<String> rooms = new ArrayList<>();
        try {
            rooms = stub.browseRooms();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public List<String> viewUsers(String type) {
        List<String> users = new ArrayList<>();
        try {
            users = stub.viewUsers(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
    
    public void deleteUser(String type, String email) {
        try {
            if (stub.deleteUser(type, email)) {
                System.out.println(type + " deleted");
            } else {
                System.out.println(type + " is not present");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteRoom(String roomNo) {
        try {
            if (stub.deleteRoom(roomNo)) {
                System.out.println("Room removed");
            } else {
                System.out.println("Room is not present");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void adminRegister(Boolean isAdmin, String userName, String email, String password) {
        try {
            if (stub.adminRegister(userName, email, password)) {
                System.out.println("Successful resigtration");
                if (!isAdmin) {
                    FrontController frontController;
                    Entry entry;
                    frontController = new FrontController();
                    entry = new Entry();
                    frontController.dispatchRequest(entry.login());
                }
            } else {
                System.out.println("Email already present");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void addRoom(String operation, String roomNo, String type, String description, String price, String rating,
            String noOfBeds,
            String typeOfBed, String isSmokingAllowed, String isAvailable) {
        try {
            if (stub.addRoom(operation, roomNo, type, description, price, rating, noOfBeds, typeOfBed, isSmokingAllowed,
                    isAvailable)) {
                if (operation == "Add")
                    System.out.println("Room added to the hotel");
                else
                    System.out.println("Hotel room updated");
            } else {
                if (operation == "Add")
                    System.out.println("Same room is already present");
                else
                    System.out.println("Room is not present");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void guestRegister(Boolean isAdmin, String userName, String email, String password) {
        try {
            if (stub.guestRegister(userName, email, password)) {
                System.out.println("Successful resigtration");
                if (!isAdmin) {
                    FrontController frontController;
                    Entry entry;
                    frontController = new FrontController();
                    entry = new Entry();
                    frontController.dispatchRequest(entry.login());
                }
            } else {
                System.out.println("Email id is already present");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reserveRoom(String roomNo, String email, int days, String address, String mobileNo, String cardNo) {
        try {
            String availability = stub.checkRoomAvailability(roomNo, days, true);
            if(!availability.equals("Not available at the moment ! :( ")) {
                stub.reserveRoom(roomNo, email, days, address, mobileNo, cardNo);
            }
            System.out.println(availability);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> viewBookings(String role, String email) {
        List<String> bookings = new ArrayList<>();
        try {
            bookings = stub.viewBookings(role, email);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookings;
    }
    
    public void cancelReservation(String roomNo, String email) {
        try {
            String availability = stub.cancelReservation(roomNo, email);
            System.out.println(availability);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modifyReservation(String roomNo, String newRoonNo, String email, int days) {
        try {
            String availability = stub.checkRoomAvailability(newRoonNo, days, false);
            if(!availability.equals("Sorry this room is not available")) {
                stub.modifyReservation(roomNo, newRoonNo, email, days);
            }
            System.out.println(availability);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}