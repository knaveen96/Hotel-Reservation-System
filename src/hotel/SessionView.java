package hotel;

import common.SessionObj;

public class SessionView {
    public static void DisplayCurrentSessionView(SessionObj session) {
        System.out.println("---------------------------------------------");
        System.out.println("You are a/an : " + session.getUser().getRoleType());
        System.out.println("---------------------------------------------");
        System.out.println();
    }
    
}
