package common;

public class CBrowseRooms implements Command {

    private Admin currAdmin;

    CBrowseRooms(Admin admin) {
        this.currAdmin = admin;
    }
    @Override
    public void execute() {
        currAdmin.browseRooms();        
    }
}