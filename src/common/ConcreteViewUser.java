package common;

public class ConcreteViewUser implements Command {

    private Admin currAdmin;
    private String currType;

    ConcreteViewUser(Admin admin, String type) {
        this.currAdmin = admin;
        this.currType = type;
    }

    @Override
    public void execute() {
        currAdmin.viewUsers(currType);        
    }
    
}
