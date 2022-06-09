package common;

public class CAddUser implements Command {

    private Admin currentAdmin;
    private String obj;

    CAddUser(Admin admin, String type) {
        this.currentAdmin = admin;
        this.obj = type;
    }

    @Override
    public void execute() {
        currentAdmin.addUser(obj);        
    }
}