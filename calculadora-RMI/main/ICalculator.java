package main;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICalculator extends Remote {
  String eval(String s) throws RemoteException;
}
