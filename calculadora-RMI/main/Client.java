package main;

import java.rmi.registry.*;

import guicalculator.*;

public class Client {
  public static void main(String[] args) throws Exception {
    Registry registry = LocateRegistry.getRegistry("179.106.201.88", 2000);
    ICalculator stub = (ICalculator) registry.lookup("rmi://179.106.201.88:2000/Calculator");
    GUICalculator view = new GUICalculator(stub);
    view.run(stub);

  }
}