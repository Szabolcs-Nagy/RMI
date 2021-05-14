package supermarket_rmi;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject; 

// The UnicastRemoteObject implementation of Product
public class ProductImpl extends UnicastRemoteObject implements Product {
 
    public ProductImpl() throws RemoteException { super();  };
// The list of today's offers
        @Override
        public String productList() throws RemoteException{
            return ("3-for-2 apples\nhalf-price bananas\nbuy-1-get-1-free shampoo\nearn 100 extra loyalty points with soap");
        }
  
}
