import java.net.UnknownHostException;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.InetAddress;

public class StringsServer implements Strings {

    public static void main(String[] args) {
        try {
            StringsServer server = new StringsServer();
            Strings stub = (Strings) UnicastRemoteObject.exportObject(server, 0);

            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Strings", stub);
            String nome = InetAddress.getLocalHost().getHostName();
            String ender = InetAddress.getLocalHost().getHostAddress();
            System.out.println("Servidor " + nome + " IP: " + ender);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String upperCase(String str) throws java.rmi.RemoteException{
        System.out.println(" Recebido do Cliente: " + str);
        return str.toUpperCase();
    }

    public String lowerCase(String str) throws java.rmi.RemoteException{
        System.out.println(" Recebido do Cliente: " + str);
        return str.toLowerCase();
    }

    public String reverse(String str) throws java.rmi.RemoteException{
        System.out.println(" Recebido do Cliente: " + str);
        return new StringBuilder(str).reverse().toString();
    }

    public String serverData() throws java.rmi.RemoteException, UnknownHostException {
        return " IP do Servidor: " + InetAddress.getLocalHost().toString().split("/")[1]
                + " \n Hostname: " + InetAddress.getLocalHost().getHostName()
                + " \n SO: " + System.getProperty("os.name");
    }
    
}