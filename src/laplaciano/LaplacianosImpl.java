package laplaciano;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LaplacianosImpl extends UnicastRemoteObject implements Laplacianos{
    
    String u1, u2;
    
    
    public LaplacianosImpl() throws RemoteException{
        super();
    }

    @Override
    public void sendImage(String url) throws RemoteException {
        if(this.u1 != null && this.u2 != null){
            this.u1 = url;
            this.u2 = "";
        }
        
        if(this.u1 != null){ 
            this.u2 = url;
            return;
        }
        
        this.u1 = url;
    }

    @Override
    public void upLoadImage() throws RemoteException {
        
    }

    @Override
    public void funcSequential() throws RemoteException {
        
    }

    @Override
    public void funcFork() throws RemoteException {
        
    }

    @Override
    public void funcExec() throws RemoteException, InterruptedException, IOException {
        
    }

    @Override
    public void clear() throws RemoteException {
        
    }

    @Override
    public void seeImage() throws RemoteException {
        
    }

    @Override
    public String getA() throws RemoteException {
      return this.u1; 
    }

    @Override
    public String getB() throws RemoteException {
        return this.u2;
    }

    @Override
    public void clean() throws RemoteException {
       this.u1 = "";
       this.u2 = "";
    }
}
