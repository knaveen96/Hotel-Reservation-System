package common;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class DummyDatabase extends UnicastRemoteObject {
    
    public static List<User> users = new ArrayList<User>();
    public static List<Room> rooms = new ArrayList<Room>();
    public static List<Booking> bookings = new ArrayList<Booking>();

    public DummyDatabase() throws RemoteException {
        super();
    }

    public static void createData() throws RemoteException {
        try {
            
            Booking booking1 = new Booking();
            booking1.setEmail("naveen@gmail.com");
            booking1.setRoomNo("2");
            booking1.setDays(5);
            booking1.setAddress("Near Indianapolis Downtown");
            booking1.setMobileNo("3171118987");
            booking1.setCardNo("893872423748");
            booking1.setCancelled("No");
            booking1.setAmount(200);
            bookings.add(booking1);
            
            User admin = new User();
            admin.setName("Admin1");
            admin.setEmail("admin1@indianahotel.com");
            admin.setPassword("@ADMin1");
            admin.setRole("Admin");
            users.add(admin);
            
            User admin2 = new User();
            admin2.setName("Admin2");
            admin2.setEmail("admin2@indianahotel.com");
            admin2.setPassword("@ADMin2");
            admin2.setRole("Admin");
            users.add(admin2);
            
            User guest1 = new User();
            guest1.setName("Naveen");
            guest1.setEmail("naveen@gmail.com");
            guest1.setPassword("@NAVeen1");
            guest1.setRole("Guest");
            users.add(guest1);
            
            User guest2 = new User();
            guest2.setName("Rahul");
            guest2.setEmail("rahul@gmail.com");
            guest2.setPassword("@RAHul2");
            guest2.setRole("Guest");
            users.add(guest2);

            Room room1 = new Room();
            room1.setRoomNo("1");
            room1.setType("Delux");
            room1.setDescription("No Beach View");
            room1.setPrice("500");
            room1.setRating("3");
            room1.setNoOfBeds("2");
            room1.setTypeOfBed("Single Bed");
            room1.setSmokingAllowed("No");
            room1.setAvailable("Yes");
            rooms.add(room1);

            Room room2 = new Room();
            room2.setRoomNo("2");
            room2.setType("Super Delux");
            room2.setDescription("Beach View with a private pool");
            room2.setPrice("1000");
            room2.setRating("5");
            room2.setNoOfBeds("4");
            room2.setTypeOfBed("Double Bed");
            room2.setSmokingAllowed("Yes");
            room2.setAvailable("Yes");
            rooms.add(room2);

            Room room3 = new Room();
            room3.setRoomNo("3");
            room3.setType("Double");
            room3.setDescription("Complimentary Breakfast");
            room3.setPrice("750");
            room3.setRating("4");
            room3.setNoOfBeds("1");
            room3.setTypeOfBed("Single Bed");
            room3.setSmokingAllowed("No");
            room3.setAvailable("Yes");
            rooms.add(room3);           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}