package common;


import java.io.Serializable;

public class Role implements Serializable{

    private String uRole, uName, fName;

    public Role(String userRole, String userName)
    {
        this.uRole = userRole;
        this.uName = userName;
    }

    public String getRoleType(){

        return uRole;
    }
    
    public String getUserName() {
        return uName;
    }

    public String getFirstName() {
        return fName;
    }
}