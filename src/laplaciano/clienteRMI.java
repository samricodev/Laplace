package laplaciano;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClienteRMI {

    public static void main(String[] args) {
        try {
            Registry rmii = LocateRegistry.getRegistry("192.168.137.174", 1006);
//            Registry rmii = LocateRegistry.getRegistry("localhost", 1006);
            Laplacianos servidor = (Laplacianos) rmii.lookup("Laplacian");
            WindowMain frame = new WindowMain(servidor);
            frame.setVisible(true);
        } catch (NotBoundException | RemoteException e) {
            System.out.println(e.getMessage());
        }
    }
}
