/**
 * HelloWorld.java
 **/

import java.rmi.*;
import java.net.InetAddress;

public interface HelloWorld extends Remote {
    public String hello(String msg) throws RemoteException;
}