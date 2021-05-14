package supermarket_rmi;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject; 

// The UnicastRemoteObject implementation of Customer
public class CustomerImpl extends UnicastRemoteObject implements Customer {
    
    public CustomerImpl() throws RemoteException { super(); };
// The offers() method is used to display today's offers to the customer
          @Override
          public String offers () throws RemoteException {
// The server side user is infomrmed that the customer has asked to view today's offers
            System.out.println("Server: Customer requested to view today's offers"); 
            System.out.println("Server: Sending today's offers to Customer ");
// Instanciating the Product RemoteObject 
            Product p = new ProductImpl();
// Calling the productList() method of the of the Product RemoteObject 
// Returning the list of today's offers to the customer
            return p.productList(); 
        }
// The pay() methos is called when the customer chooses to pay for the shopping
        @Override
        public int pay (int num) throws RemoteException {
// The server side user is informed that the customer requested to pay
            System.out.println("Server: The Customer has requested to pay ");
// Calculating the points earned at this shopping
           int points = num/10;
// The server side user is infomed of the amount of pioints the customer has earned
            System.out.println("Server: The Customer has earned " + points +" points during this shopping");
// returning the number of points earned to the client
            return points; 
        }
  
}
