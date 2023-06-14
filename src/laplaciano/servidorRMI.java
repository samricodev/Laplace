package laplaciano;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorRMI {
    public static void main(String[] args) {
        try{
            System.setProperty("java.rmi.server.hostname","192.168.1.174");
            Registry rmi = LocateRegistry.createRegistry(1006);
            rmi.rebind("Laplacian", (Remote) new LaplacianosImpl()); 
            System.out.println("Server up");
        }catch(RemoteException e){
            System.out.println(e);
        }
    }
}