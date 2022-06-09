package client;

import common.DispatchRequests;
import common.Entry;
import common.SessionObj;

public class FrontController {
    private DispatchRequests dispatch;
    private SessionObj currentSession = null;
    private Client clientController = new Client();
    private Entry etr = new Entry();
    public FrontController() {
        dispatch = new DispatchRequests();
    }
    
    public void dispatchRequest(String view) {
        if (isAuthenticUser(view))
            dispatch.dispatch(view, currentSession);
        else
            dispatch.dispatchError("ERROR");
    }

    private boolean isAuthenticUser(String view) {
        if (view.equalsIgnoreCase("Admin")) {
            etr.adminLogin();

            String mail = etr.getEmail();
            String password = etr.getPassword();

            if (clientController.adminLogin(mail, password)) {
                currentSession = clientController.processLogin("Admin", mail);
                return true;
            }

        } else if (view.equalsIgnoreCase("Guest")) {

            etr.guestLogin();
            String mail = etr.getEmail();
            String password = etr.getPassword();

            if (clientController.guestLogin(mail, password)) {
                currentSession = clientController.processLogin("Guest", mail);
                return true;
            }

        } else if (view.equalsIgnoreCase("New Admin")) {
            etr.registration();

            String mail, uname, password;
            mail = etr.getEmail();
            uname = etr.getUserName();
            password = etr.getPassword();

            clientController.adminRegister(false, uname, mail, password);
            return true;

        } else if (view.equalsIgnoreCase("New Guest")) {
            etr.registration();

            String mail, uname, password;
            mail = etr.getEmail();
            uname = etr.getUserName();
            password = etr.getPassword();

            clientController.guestRegister(false, uname, mail, password);
            return true;
        }

        return false;
    }
}
