/**
 * HelloServer.java
 **/

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.InetAddress;
import java.util.Locale;

public class HelloServer implements HelloWorld {
    public HelloServer() {}
    // main()
    // hello()

    public static void main(String[] args) {
        try {
            // Instancia o objeto servidor e a sua stub
            HelloServer server = new HelloServer();
            HelloWorld stub = (HelloWorld) UnicastRemoteObject.exportObject(server, 0);

            // Registra a stub no RMI Registry para que ela seja obtida pelos clientes
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Hello", stub);
            String nome = InetAddress.getLocalHost().getHostName();
            String ender = InetAddress.getLocalHost().getHostAddress();
            System.out.println("Servidor " + nome + " IP: " + ender);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String hello(String msg) throws RemoteException {
        System.out.println("Executando hello(). Recebido o parâmetro: " + msg);
        return msg.toUpperCase();
    }
}