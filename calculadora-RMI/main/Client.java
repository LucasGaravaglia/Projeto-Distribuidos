package main;

// Program for client application
import java.rmi.registry.*;

public class Client {
  public static void main(String[] args) throws Exception {
    Registry registry = LocateRegistry.getRegistry("localhost", 2000);
    ICalculator stub = (ICalculator) registry.lookup("rmi://localhost:2000/Calculator");

    System.out.println("Addition= " + stub.sum(1, 2));
  }
}