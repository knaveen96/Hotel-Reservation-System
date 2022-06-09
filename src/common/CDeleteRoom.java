package common;

public class CDeleteRoom implements Command {

    private Admin currAdmin;

    CDeleteRoom(Admin admin) {
        this.currAdmin = admin;
    }
    @Override
    public void execute() {
        currAdmin.deleteRoom();        
    }
}
