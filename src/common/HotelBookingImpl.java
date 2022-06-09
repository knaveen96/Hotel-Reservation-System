package common;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class HotelBookingImpl extends UnicastRemoteObject implements HotelBooking {

    public HotelBookingImpl() throws RemoteException {
        super();
    }
    
    @Override
    public boolean adminLogin(String userName, String password) throws RemoteException {
        try {
            for (User user : DummyDatabase.users) {
                if (user.getEmail().equals(userName) && user.getPassword().equals(password)
                        && user.getRole().equals("Admin")) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean guestLogin(String userName, String password) throws RemoteException {
        try {
            for (User user : DummyDatabase.users) {
                if (user.getEmail().equals(userName) && user.getPassword().equals(password)
                        && user.getRole().equals("Guest")) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public boolean adminRegister(String userName, String email, String password) throws RemoteException {
        try {
            User userExists = null;
            for (User user : DummyDatabase.users) {
                if (user.getEmail().equals(email)) {
                    userExists = user;
                }
            }

            if (userExists != null)
                return false;

            User user = new User();
            user.setName(userName);
            user.setEmail(email);
            user.setPassword(password);
            user.setRole("Admin");
            DummyDatabase.users.add(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean guestRegister(String userName, String email, String password) throws RemoteException {
        try {
            User userExists = null;
            for (User user : DummyDatabase.users) {
                if (user.getEmail().equals(email)) {
                    userExists = user;
                }
            }
            if (userExists != null)
                return false;

            User user = new User();
            user.setName(userName);
            user.setEmail(email);
            user.setPassword(password);
            user.setRole("Guest");
            DummyDatabase.users.add(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    

    @Override
    public SessionObj processLogin(String userType, String userName) throws RemoteException {
        try {
            SessionObj session = new SessionObj(userType, userName);
            return session;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<String> browseRooms() throws RemoteException {
        List<String> rooms = new ArrayList<>();
        try {
            for (Room room : DummyDatabase.rooms) {
                rooms.add("Room No: " + room.getRoomNo() + " | " + "Type: " + room.getType() + " | " + "Description: "
                        + room.getDescription() + " | " +
                        "Price: " + room.getPrice() + " | " + "Rating:" + room.getRating() + " | " + "No of beds: "
                        + room.getNoOfBeds() + " | " +
                        "Type of bed: " + room.getTypeOfBed() + " | " + "Smoking allowed: " + room.isSmokingAllowed()
                        + " | " + "Available: " + room.isAvailable());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;
    }

    @Override
    public boolean addRoom(String operation, String roomNo, String type, String description, String price,
            String rating, String noOfBeds,
            String typeOfBed, String isSmokingAllowed, String isAvailable) throws RemoteException {
        try {
            Room oldRoom = null;
            for (Room item : DummyDatabase.rooms) {
                if (item.getRoomNo().equals(roomNo))
                    oldRoom = item;
            }
            if (operation.equals("Add")) {
                if (oldRoom != null)
                    return false;
            } else {
                if (oldRoom == null)
                    return false;
                else {
                    DummyDatabase.rooms.remove(oldRoom);
                    if (isAvailable.equals("No")) {
                        Booking existingBooking = null;
                        for (Booking booking : DummyDatabase.bookings)
                            if (roomNo.equals(booking.getRoomNo()))
                                existingBooking = booking;

                        if (existingBooking != null)
                            DummyDatabase.bookings.remove(existingBooking);
                    }
                }
            }
            Room room = new Room(roomNo, type, description, price, rating, noOfBeds, typeOfBed, isSmokingAllowed, isAvailable);
            DummyDatabase.rooms.add(room);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public List<String> viewBookings(String role, String email) throws RemoteException {
        List<String> bookings = new ArrayList<>();
        try {
            for (Booking booking : DummyDatabase.bookings) {
                if ((role.equals("Admin") || email.equals(booking.getEmail())) && booking.isCancelled().equals("No"))
                    bookings.add("Guest Email: " + booking.getEmail() + " | " + "Room No: " + booking.getRoomNo()
                            + " | " + "Days: " + booking.getDays() + " | " +
                            "Address: " + booking.getAddress() + " | " + "Mobile No:" + booking.getMobileNo() + " | "
                            + "Credit Card No: "
                            + booking.getCardNo() + " | " + " | " + "Price: " + booking.getAmount());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookings;
    }

    @Override
    public String modifyReservation(String roomNo, String newRoonNo, String email, int days) throws RemoteException {
        String result = "Sorry this room is not available";
        try {
            Booking existingBooking = null;
            for (Booking booking : DummyDatabase.bookings)
                if (roomNo.equals(booking.getRoomNo()) && email.equals(booking.getEmail()) && booking.isCancelled().equals("No"))
                    existingBooking = booking;

            if (existingBooking != null) {
                result = checkRoomAvailability(newRoonNo, days, false);
                if (!result.equals("Sorry this room is not available")) {
                    existingBooking.setRoomNo(newRoonNo);
                    existingBooking.setDays(days);
                    Room oldRoom = null;
                    for (Room item : DummyDatabase.rooms) {
                        if (item.getRoomNo().equals(roomNo)) {
                            oldRoom = item;
                        }
                    }
                    oldRoom.setAvailable("Yes");
                }
            } else
                result = "Booking not found";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteRoom(String roomNo) throws RemoteException {
        try {
            Room room = null;
            for (Room item : DummyDatabase.rooms) {
                if (item.getRoomNo().equals(roomNo))
                    room = item;
            }
            if (room != null) {
                DummyDatabase.rooms.remove(room);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<String> viewUsers(String type) throws RemoteException {
        List<String> users = new ArrayList<>();
        try {
            for (User user : DummyDatabase.users) {
                if (user.getRole().equals(type))
                    users.add("User Name: " + user.getName() + " | " + "Email: " + user.getEmail());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean deleteUser(String type, String email) throws RemoteException {
        try {
            User user = null;
            for (User item : DummyDatabase.users) {
                if (item.getEmail().equals(email) && item.getRole().equals(type))
                    user = item;
            }
            if (user != null) {
                DummyDatabase.users.remove(user);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String checkRoomAvailability(String roomNo, int days, boolean isNew) throws RemoteException {
        String result = "Sorry this room is not available";
        try {
            int price = 0;
            boolean isAvailable = false;

            for (Room item : DummyDatabase.rooms) {
                if (item.getRoomNo().equals(roomNo) && item.isAvailable().equals("Yes")) {
                    isAvailable = true;
                    price = Integer.parseInt(item.getPrice()) * days;
                }
            }

            if (isAvailable) {
                if (isNew)
                    result = "Confirmed !! Price of the booking : $" + price + ". Payment success";
                else
                    result = "Updated !! Price after updating : $" + price + ". Payment success";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean reserveRoom(String roomNo, String email, int days, String address, String mobileNo, String cardNo)
            throws RemoteException {
        try {
            int price = 0;
            Room oldRoom = null;
            for (Room item : DummyDatabase.rooms) {
                if (item.getRoomNo().equals(roomNo)) {
                    oldRoom = item;
                    price = Integer.parseInt(item.getPrice()) * days;
                }
            }
            oldRoom.setAvailable("No");
            Booking booking = new Booking();
            booking.setEmail(email);
            booking.setRoomNo(roomNo);
            booking.setDays(days);
            booking.setAddress(address);
            booking.setMobileNo(mobileNo);
            booking.setCardNo(cardNo);
            booking.setAmount(price);
            booking.setCancelled("No");

            DummyDatabase.bookings.add(booking);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    

    @Override
    public String cancelReservation(String roomNo, String email) throws RemoteException {
        String result = "Booking not found";
        try {
            Booking existingBooking = null;
            for (Booking booking : DummyDatabase.bookings)
                if (roomNo.equals(booking.getRoomNo()) && email.equals(booking.getEmail()) && booking.isCancelled().equals("No"))
                    existingBooking = booking;

            Room room = null;
            for (Room item : DummyDatabase.rooms) {
                if (item.getRoomNo().equals(roomNo))
                    room = item;
            }

            if (existingBooking != null) {
                existingBooking.setCancelled("Yes");
                if (room != null)
                    room.setAvailable("Yes");

                int price = existingBooking.getAmount();
                price = (price * 10) / 100;
                result = "Booking cancelled successfully. Cancellation charges(10%) $" + price + ". Balance amount will be credit to your account";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
