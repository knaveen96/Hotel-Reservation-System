package common;

import java.util.ArrayList;
import java.util.List;

public class Invoke {

    private List<Command> orderList = new ArrayList<Command>();

    public void placeCommand() {

        for (Command command : orderList) {
            command.execute();
        }
        orderList.clear();
    }
    
    public void takeCommand(Command command) {
        orderList.add(command);
    }
    
}
