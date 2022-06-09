package common;

import java.io.Serializable;

public class SessionObj implements Serializable{

    private  Role currRole;
    public SessionObj(String userRole, String userName)
    {
        this.currRole = new Role(userRole, userName);
    }
    public Role getUser() {
        return currRole;
    }
}