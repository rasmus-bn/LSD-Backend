package rmiclient;

import rmiserver.ITest;

import java.rmi.Naming;
import java.util.Scanner;

public class client {
    private static double amount;
    private static int accountId;

    public static void getService() throws Exception {
        // name =  rmi:// + ServerIP +  /EngineName;
        String remoteEngine = "rmi://localhost/Compute";

        // Create local stub, lookup in the registry searching for the remote engine - the interface with the methods we want to use remotely
        ITest obj = (ITest) Naming.lookup(remoteEngine);

        // Send requests to the remote services the usual way, as if they are local
        String addmoney = obj.addMoney(12.5, 1);
    }

    public static void printout(String addMoney)//, String withdraw)
    {
        // Print the results on the Client console
        System.out.println(addMoney);
        //System.out.println(withdraw);
    }

    public static void main(String[] args) {
        try {
            getService();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
