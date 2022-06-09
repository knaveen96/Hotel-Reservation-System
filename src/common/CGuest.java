package common;

import java.util.List;
import java.util.Scanner;

import client.Client;
import hotel.SessionView;
import hotel.GuestView;

public class CGuest implements Guest {

    private Client clientCntrl;
    public CGuest() {
        clientCntrl = new Client();
    }
    @Override
    public int display(SessionObj session) {
        int i = 0;
        SessionView.DisplayCurrentSessionView(session);
        GuestView.DisplayGuestMenu();
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
            List<String> rooms = clientCntrl.browseRooms();
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
    public void reserveRoom(SessionObj session) {
        try {
            System.out.println("All rooms in the hotel");
            List<String> rooms = clientCntrl.browseRooms();
            int count = 1;
            for (String room : rooms) {
                System.out.println(count + ". " + room);
                count++;
            }

            Entry entry = new Entry();
            entry.getBookingDetails();
            String roomNo = entry.getRoomNo();
            int days = entry.getDays();
            String address = entry.getAddress();
            String mobileNo = entry.getMobileNo();
            String cardNo = entry.getCardNo();
            String email = session.getUser().getUserName();
            
            clientCntrl.reserveRoom(roomNo, email, days, address, mobileNo, cardNo);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void modifyReservation(SessionObj session) {
        try {
            String role = session.getUser().getRoleType();
            String email = session.getUser().getUserName();

            List<String> rooms = clientCntrl.viewBookings(role, email);
            if (rooms.size() > 0) {
                System.out.println("Bookings : ");
                int count = 1;
                for (String room : rooms) {
                    System.out.println(count + ". " + room);
                    count++;
                }
                Entry entry = new Entry();
                entry.getModifyBookingDetails();
                String roomNo = entry.getRoomNo();
                int days = entry.getDays();
                String newRoomNo = entry.getAddress();
                clientCntrl.modifyReservation(roomNo, newRoomNo, email, days);
            } else {
                System.out.println("Unable to fetch bookings");
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void cancelReservation(SessionObj session) {
        try {
            String role = session.getUser().getRoleType();
            String email = session.getUser().getUserName();

            List<String> rooms = clientCntrl.viewBookings(role, email);
            if (rooms.size() > 0) {
                System.out.println("Bookings : ");
                int count = 1;
                for (String room : rooms) {
                    System.out.println(count + ". " + room);
                    count++;
                }
                Entry entry = new Entry();
                entry.getCancelookingDetails();
                String roomNo = entry.getRoomNo();
                
                clientCntrl.cancelReservation(roomNo, email);
            } else {
                System.out.println("Unable to fetch bookings");
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}