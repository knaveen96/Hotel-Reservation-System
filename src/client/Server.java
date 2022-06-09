package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.DummyDatabase;
import common.HotelBooking;
import common.HotelBookingImpl;

public class Server extends UnicastRemoteObject { 

    protected Server() throws RemoteException {
        super();
    }

    public static void main(String[] args) throws RemoteException, MalformedURLException {

        try {
            DummyDatabase.createData();
            HotelBooking stub = new HotelBookingImpl();
            Naming.rebind("//in-csci-rrpc05.cs.iupui.edu:2596/HotelBooking", stub);
            System.out.println("Server is active");
        }
        catch(Exception ex) {
            System.out.println("Server error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
