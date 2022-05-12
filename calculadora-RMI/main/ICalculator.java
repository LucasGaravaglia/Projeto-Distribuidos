package main;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICalculator extends Remote {
  int multiplication(int x, int y) throws RemoteException;

  int sum(int x, int y) throws RemoteException;

  int subtract(int x, int y) throws RemoteException;

  int division(int x, int y) throws RemoteException;
}
