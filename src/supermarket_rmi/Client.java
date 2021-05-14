package supermarket_rmi;
import java.util.Scanner;
import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry; 

public class Client {
    
    public static void main(String args[]) {
// Initializing the String for the RMI registry host machine as localhost
String registryHost = "localhost";
// Initializing the integer for the RMI running port
int registryPort;
// Initializing the String for the reference to the remote object as SupermarketService
String remoteObjRef = "SupermarketService";
// Prompting the user to enter the port number on which to connect to the server
System.out.println("Input port number on which RMIregistry was started.");
// Creating an instance of the scanner
Scanner input = new Scanner(System.in);
// Saving the user's input into the registryPort integer
registryPort = input.nextInt();
// Creating the registry name based on the port number entered by the user
String registryName="rmi://" + registryHost +":" + registryPort + "/" + remoteObjRef; 
// Informing the user that the Client is looking for the server
System.out.println("Client: Looking up " + registryName + " ...");
// Creating an empty instance of the Customer class
Customer cust = null;
// Using the built in JAVA getRegistry() method of the LocateRegistry class to obtin a reference
// to the local host on the registryPort port number
try{ Registry registry=LocateRegistry.getRegistry(registryPort);
// Look up the remote object bound to the from registryName
cust = (Customer)registry.lookup(registryName); 
// Informing the user that connection has been established to the server with the specific registryName
System.out.println("Connected to RMIregistry " + registryName);
// Catching the exception and informing the user in case an exception has been caught
} catch (Exception e) { System.out.println("Client: Exception thrown looking up " + registryName); 
System.exit(1); }
// Send input message from client to the remote object
// Prompt the user to choose an option
// Exit when input = "3" 
System.out.println("Please choose one of the following options:\nPress 1 - To list special offers"
        + " \nPress 2 - To checkout \nPress 3 - To end session");
for (;;) {
// Saving the user's input into the strMsg String
String choice= input.next();
// If the user choses option "1"
if ("1".equals(choice)){
try { 
// Then invoke the remote method - One to many relationship
// The user will get back a message displaying today's offers
// This will happen by calling the offers() methid of the Customer RemoteObject
// Then the Customer RemoteObject calling the productList() method of the Product RemoteObject
String todaysOffers = cust.offers();
// Returning the list of today's offers to the customer
System.out.println("Todays offers:\n"+ todaysOffers);
} 
// Informing the user that an exception has been caught and displaying the exception
catch (Exception e) { System.out.println("Client: Exception thrown calling offers(): " + e); 
        System.exit(1); }}

// If the user chooses option "2"
if ("2".equals(choice)){
// Then the user get's prompted to enter the total price of shopping at this occasion
System.out.println("Enter total price");
// The user's input is saved in the integer total
int total = input.nextInt();

try { 
// Invoking the remote method by passing total to the pay() method of the Customer RemoteObject
int amount = cust.pay(total);
// The remote method will calculate the amount of points earned and this is used to inform the user
System.out.println("You have earned "+ amount+" points with today's shopping");
} 
// Informing the user that an exception has been caught and displaying the exception
catch (Exception e) { System.out.println("Client: Exception thrown calling pay(): " + e); 
        System.exit(1); }}

// If the user chooses "3" then exits
if ("3".equals(choice)) break;
}
    }
}