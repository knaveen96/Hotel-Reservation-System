package common;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AuthInvocationHandler extends UnicastRemoteObject implements InvocationHandler {
    private Object objectImpl;

    public AuthInvocationHandler(Object impl) throws RemoteException{
        this.objectImpl = impl;
    }

    @Override
    public Object invoke(Object obj, Method func, Object[] args) throws Throwable {
        if (func.isAnnotationPresent(Roles.class)) {
            Roles test = func.getAnnotation(Roles.class);
            SessionObj session = (SessionObj) args[0];
            if (session.getUser().getRoleType().equals(test.value())) {
                return func.invoke(objectImpl, args);
            } else {
                throw new AuthException(func.getName());
            }
        } else {
            return func.invoke(objectImpl, args);
        }
    }
}
