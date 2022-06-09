package common;

public class CDeleteUser implements Command {

    private Admin currAdmin;
    private String currType;

    CDeleteUser(Admin admin, String type) {
        this.currAdmin = admin;
        this.currType = type;
    }
    @Override
    public void execute() {
        currAdmin.deleteUser(currType);        
    }
}