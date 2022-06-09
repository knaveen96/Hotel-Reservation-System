package common;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

    public class User extends UnicastRemoteObject {

        private String name;
        private String email;
        private String password;
        private String role;

    public User() throws RemoteException {
        super();
    }

    public User(String name, String email, String password, String role) throws RemoteException {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return this.email +" "+this.password;
    }

}