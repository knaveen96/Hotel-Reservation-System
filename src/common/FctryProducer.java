package common;

public class FctryProducer {
    public static AbsFactory getFactory(String option) {
        
        if (option.equalsIgnoreCase("Admin")) {
            return new AdminFactory();
        } else if (option.equalsIgnoreCase("Guest")) {
            return new GuestFact();
        }
        return null;
    }
}
