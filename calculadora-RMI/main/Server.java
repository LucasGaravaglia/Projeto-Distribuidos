// package main;

// import java.rmi.*;
// import java.rmi.registry.*;

// public class Server {
//     public static void main(String[] args) throws Exception {

//         // System.setProperty("java.rmi.server.hostname", "localhost");
//         Registry registry = LocateRegistry.createRegistry(2000);
//         registry.rebind("rmi://localhost:2000/Calculator", new Calculator());

//         System.out.println("Server Started");
//     }
// }
package main;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Server implements ICalculator {
    public Server() throws Exception {
        super();
    }

    public String eval(String s) {
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            String ret = engine.eval(s).toString();
            System.out.println(ret);
            return engine.eval(s).toString();
        } catch (Exception e) {
            System.out.println("Erro na operação");
            return "Erro na operação";
        }

    }

    public static void main(String[] args) throws Exception {
        try {
            Server obj = new Server();
            ICalculator stub = (ICalculator) UnicastRemoteObject.exportObject(obj, 2000);

            System.setProperty("java.rmi.server.hostname", "localhost");
            Registry registry = LocateRegistry.createRegistry(2000);
            registry.rebind("rmi://localhost:2000/Calculator", stub);

            System.out.println("Server Started");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
