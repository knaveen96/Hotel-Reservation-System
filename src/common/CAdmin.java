package common;

import java.util.List;
import java.util.Scanner;

import client.Client;
import hotel.AdminView;
import hotel.SessionView;

public class CAdmin implements Admin {
    private Client controller;
    public CAdmin() {
        controller = new Client();
    }

    @Override
    public int display(SessionObj session) {
        int i = 0;

        SessionView.DisplayCurrentSessionView(session);
        AdminView.DisplayAdminMenuView();
        Scanner sc = new Scanner(System.in);
        try {
            i = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println(e);
        }
        return i;
    }

    @Override
    public void browseRooms() {
        try {
            System.out.println("All rooms present in the hotel");
            List<String> rooms = controller.browseRooms();
            int count = 1;
            for (String room : rooms) {
                System.out.println(count + ". " + room);
                count++;
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void viewUsers(String type) {
        try {
            System.out.println("User List : " + type);
            
            List<String> users = controller.viewUsers(type);
            int count = 1;
            for (String user : users) {
                System.out.println(count + ". " + user);
                count++;
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void deleteUser(String type) {
        try {
            Entry entry = new Entry();
            entry.getUserForDelete();
            String email = entry.getEmail();

            controller.deleteUser(type, email);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void deleteRoom() {
        try {
            Entry entry = new Entry();
            entry.getRoomForDelete();
            String roomNo = entry.getEmail();
            
            controller.deleteRoom(roomNo);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void addRoom(String operation) {
        try {
            Entry entry = new Entry();
            entry.getRoomForAdd(operation);
            String roomNo = entry.getRoomNo();
            String type = entry.getRoomType();
            String description = entry.getDescription();
            String price = entry.getPrice();
            String rating = entry.getRating();
            String noOfBeds = entry.getNoOfBeds();
            String typeOfBed = entry.getTypeOfBed();
            String isSmokingAllowed = entry.isSmokingAllowed();
            String isAvailable = entry.isAvailable();
            controller.addRoom(operation, roomNo, type, description, price, rating, noOfBeds, typeOfBed, isSmokingAllowed, isAvailable);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void addUser(String type) {
        try {
            Entry entry = new Entry();
            entry.registration();
            String email = entry.getEmail();
            String userName = entry.getUserName();
            String password = entry.getPassword();
            
            if(type == "Admin")
                controller.adminRegister(true, userName, email, password);
            else    
                controller.guestRegister(true, userName, email, password);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
