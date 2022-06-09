package common;

public class CAddRoom implements Command {

    private Admin currentAdmin;
    private String op;

    CAddRoom(Admin admin, String operation) {
        this.currentAdmin = admin;
        this.op = operation;
    }

    @Override
    public void execute() {
        currentAdmin.addRoom(op);        
    }    
}