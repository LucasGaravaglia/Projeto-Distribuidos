package main;

import java.rmi.registry.*;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import guicalculator.*;

public class Client {
  public static void main(String[] args) throws Exception {
    Registry registry = LocateRegistry.getRegistry("localhost", 2000);
    ICalculator stub = (ICalculator) registry.lookup("rmi://localhost:2000/Calculator");
    GUICalculator view = new GUICalculator();
    view.run(stub);
    // System.out.println("Addition= " + stub.sum(1, 2));

  }
}