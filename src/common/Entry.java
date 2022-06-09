package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import hotel.MainView;

public class Entry {

	private String isAvailable;
	private int days;
	private String noOfBeds;
    private String typeOfBed;
    private String isSmokingAllowed;
    private String address;
    private String mobileNo;
    private String cardNo;
    private String isCancelled;
    private int type;
    private String email;
    private String password;
    private String userName;
    private String roomNo;
    private String roomType;
    private String description;
    private String price;
    private String rating;
    private Scanner sc = new Scanner(System.in);

    public String login() {
        MainView.DisplayHomeView();
        type = Integer.parseInt(sc.nextLine());

        if (type == 1)
            return "Admin";
        else if (type == 2)
            return "Guest";
        else if (type == 3)
            return "New Admin";
        else if (type == 4)
            return "New Guest";

        return "false";
    }

    public void adminLogin() {
        System.out.println("Please enter your e-mail id : ");
        email = sc.nextLine();

        System.out.println("Password : ");
        password = sc.nextLine();
    }

    public void guestLogin() {
        System.out.println("Please enter your e-mail id : ");
        email = sc.nextLine();

        System.out.println("Password : ");
        password = sc.nextLine();
    }

    public void registration() {
        System.out.println("Please Enter your name : ");
        userName = sc.nextLine();

        System.out.println("Please enter your e-mail id : ");
        email = sc.nextLine();

        System.out.println("Password : ");
        password = sc.nextLine();

    }

    public void getUserForDelete() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter e-mail id of the user to be deleted : ");
            email = reader.readLine();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getRoomForDelete() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter a room number to delete : ");
            email = reader.readLine();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getRoomForAdd(String operation) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                if (operation == "Add")
                    System.out.println("Enter new room number: ");
                else
                    System.out.println("Enter the room number which already exists: ");

                roomNo = reader.readLine();

                System.out.println("Enter the type of room: ");
                roomType = reader.readLine();

                System.out.println("Enter room description: ");
                description = reader.readLine();

                System.out.println("Enter room price: ");
                price = reader.readLine();

                System.out.println("Enter room rating: ");
                rating = reader.readLine();

                System.out.println("Enter number of beds you want to place: ");
                noOfBeds = reader.readLine();

                System.out.println("Enter type of bed in the room: ");
                typeOfBed = reader.readLine();

                System.out.println("Is smoking allowed? (Yes/No): ");
                isSmokingAllowed = reader.readLine();

                System.out.println("Is room available? (Yes/No): ");
                isAvailable = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void getBookingDetails() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                System.out.println("Please enter the room no. you want to reserve: ");
                roomNo = reader.readLine();

                System.out.println("For how many days: ");
                days = Integer.parseInt(reader.readLine());

                System.out.println("Enter your address: ");
                address = reader.readLine();

                System.out.println("Enter phn number: ");
                mobileNo = reader.readLine();

                System.out.println("Enter bank card number: ");
                cardNo = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void getModifyBookingDetails() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                System.out.println("Enter the room number to modify: ");
                roomNo = reader.readLine();

                System.out.println("Enter latest room number: ");
                address = reader.readLine();

                System.out.println("Enter no of days: ");
                days = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void getCancelookingDetails() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                System.out.println("Enter a room number to cancel: ");
                roomNo = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getNoOfBeds() {
        return noOfBeds;
    }

    public void setNoOfBeds(String noOfBeds) {
        this.noOfBeds = noOfBeds;
    }

    public String getTypeOfBed() {
        return typeOfBed;
    }

    public void setTypeOfBed(String typeOfBed) {
        this.typeOfBed = typeOfBed;
    }

    public String isSmokingAllowed() {
        return isSmokingAllowed;
    }

    public void setSmokingAllowed(String isSmokingAllowed) {
        this.isSmokingAllowed = isSmokingAllowed;
    }

    public String isAvailable() {
        return isAvailable;
    }

    public void setAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getIsCancelled() {
        return isCancelled;
    }

    public void setIsCancelled(String isCancelled) {
        this.isCancelled = isCancelled;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
