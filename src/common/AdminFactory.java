package common;

public class AdminFactory extends AbsFactory {

	@Override
    Guest getUser(String user) {
        return null;
    }
	
    @Override
    Admin getAdmin(String admin) {
        if(admin == null)
            return null;

        if(admin.equalsIgnoreCase("Admin"))
            return new CAdmin();
            
        return null;
    }
}