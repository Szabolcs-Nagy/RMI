package supermarket_rmi;
import java.util.Scanner;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Server_RMI {

    public static void main(String[] args) {
// Initializing the String for the RMI registry host machine as localhost
String registryHost = "localhost";
// Initializing the integer for the RMI running port
int registryPort;
// Initializing the String for the reference to the remote object as SupermarketService
String remoteObjRef = "SupermarketService";
// Initializing a scanner
Scanner input = new Scanner(System.in);
// Prompting the user to enter a port number to start the RMI regisrty
System.out.println("Input port number on which to start rmiregistry." + 
        "Port number must be between 1024 - 65,535."); 
// Read in from the user the desired RMI registry port number
registryPort= input.nextInt(); 

try {System.out.println("Server: Supermarket Service");
// Create a rmi registry programmatically rather than using command line
LocateRegistry.createRegistry(registryPort);
Registry registry = LocateRegistry.getRegistry(registryPort);
// Creating an instance of the CustomerImpl class as remoteCustomer
CustomerImpl remoteCustomer = new CustomerImpl();

// Creating the remote object registration with rmi registry
registry.rebind("rmi://" + registryHost +":" + registryPort + "/" + remoteObjRef, remoteCustomer);

// Inform user of successful connection
System.out.println("Server: Ready..."); } catch (Exception e) {
// Inform user that the connection has failed and print the reason
System.out.println("Server: Failed to register Supermarket Service: " + e);
    }}}