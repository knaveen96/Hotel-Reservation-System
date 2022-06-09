package common;

public class GuestFact extends AbsFactory {

    @Override
    Admin getAdmin(String admin) {
        return null;
    }
    @Override
    Guest getUser(String user) {
        if(user == null)
            return null;
        if(user.equalsIgnoreCase("Guest"))
            return new CGuest();
        return null;
    }
    
}
