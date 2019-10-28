package rmiserver;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class App 
{
    public static void main( String[] args ) {
        Registry registry;
        try {
            System.out.println("RMI Server starts");

            registry = LocateRegistry.createRegistry(1099);
            System.out.println("RMI registry created ");

            // Create engine of remote services, running on the
            // server
            Test remoteEngine = new Test();

            // Give a name to this engine
            String engineName = "Compute";

            // Register the engine by the name, which later will be given to the clients
            Naming.rebind("//localhost/" + engineName, remoteEngine);
            System.out.println("Engine " + engineName + " bound in registry");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
