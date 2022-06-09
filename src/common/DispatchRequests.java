package common;

import hotel.Error;

public class DispatchRequests {
    private AbsFactory adminF;
    private AbsFactory guestF;
    public DispatchRequests() {
        adminF = FctryProducer.getFactory("Admin");
        guestF = FctryProducer.getFactory("Guest");
    }

    public void dispatch(String view, SessionObj session) {
        int option = 0;
        if (view.equalsIgnoreCase("Admin")) {
            Admin admin = adminF.getAdmin("Admin");
            Invoke invoker = new Invoke();

            while (true) {
                option = admin.display(session);
                switch (option) {
                    case 2: {
                        Command cmd = new CBrowseRooms(admin);
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 1: {
                        Command cmd = new CAddRoom(admin, "Add");
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 4: {
                        Command cmd = new CAddRoom(admin, "Update");
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 3: {
                        Command cmd = new CDeleteRoom(admin);
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    
                    case 5: {
                        Command cmd = new CAddUser(admin, "Guest");
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 6: {
                        Command cmd = new CDeleteUser(admin, "Guest");
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 7: {
                        System.out.print("\033[H\033[2J");  
                        System.out.flush(); 
                        System.out.println("Thank you for your time");            
                        System.exit(0);
                    }
                    default:
                        System.out.println("Invalid selection. Please choose again");
                        break;
                }
            }

        } else if (view.equalsIgnoreCase("Guest")) {

            Guest guest = guestF.getUser("Guest");
            Invoke invoker = new Invoke();

            while (true) {
                option = guest.display(session);
                switch (option) {
                    case 2: {
                        Command cmd = new CGuestBrowseRooms(guest);
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 1: {
                        Command cmd = new CReserveRoom(guest, session);
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 4: {
                        Command cmd = new CModifyBooking(guest, session);
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 3: {
                        Command cmd = new CCancelBooking(guest, session);
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 5: {
                        System.out.print("\033[H\033[2J");  
                        System.out.flush(); 
                        System.out.println("Thank you for your time");            
                        System.exit(0);
                    }
                    default:
                        System.out.println("Invalid selection. Please choose again");
                        break;
                }
            }
        }
    }

    public void dispatchError(String view) {
        if (view.equalsIgnoreCase("ERROR")) {
            Error obj = new Error();
            obj.print();

        }
    }
}