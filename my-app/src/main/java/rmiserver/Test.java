package rmiserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Test extends UnicastRemoteObject implements ITest {
    public Test() throws RemoteException {
    }

    @Override
    public String addMoney(double amount, int acoountId) {
        return "wow";
    }
}
