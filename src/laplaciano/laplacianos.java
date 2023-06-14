package laplaciano;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Laplacianos extends Remote{
    void sendImage(String url) throws RemoteException;
    void seeImage() throws RemoteException;
    void upLoadImage() throws RemoteException;
    void funcSequential() throws RemoteException;
    void funcFork() throws RemoteException;
    void funcExec() throws RemoteException, InterruptedException, IOException;
    void clear() throws RemoteException;
}
