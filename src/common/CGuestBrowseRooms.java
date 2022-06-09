package common;

public class CGuestBrowseRooms implements Command {

    private Guest currGuest;

    CGuestBrowseRooms(Guest guest) {
        this.currGuest = guest;
    }
    @Override
    public void execute() {
        currGuest.browseRooms();        
    }
}