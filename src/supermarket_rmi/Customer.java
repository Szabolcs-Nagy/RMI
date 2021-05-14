package supermarket_rmi;
import java.rmi.*;
// The Customer interface extending Remote
public interface Customer extends Remote {

    String offers () throws RemoteException;
    public int pay (int num) throws RemoteException;

}
