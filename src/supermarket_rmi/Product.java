package supermarket_rmi;
import java.rmi.*;
// The Product interface extending Remote
public interface Product extends Remote {

    public String productList() throws RemoteException;

}
