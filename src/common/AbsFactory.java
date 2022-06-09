package common;

public abstract class AbsFactory {
    abstract Admin getAdmin(String admin);
    abstract Guest getUser(String user);
}
