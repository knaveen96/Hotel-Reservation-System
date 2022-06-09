package common;

public class AuthException extends RuntimeException {
    public AuthException(String methodName) {
        super("Invalid Authorization - Access Denined to " + methodName + "() function!");
    }
}
