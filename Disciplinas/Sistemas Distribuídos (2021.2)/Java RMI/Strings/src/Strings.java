import java.net.UnknownHostException;
import java.rmi.Remote;

public interface Strings extends Remote {

    public String upperCase(String str) throws java.rmi.RemoteException;

    public String lowerCase(String str) throws java.rmi.RemoteException;

    public String reverse(String str) throws java.rmi.RemoteException;

    public String serverData() throws java.rmi.RemoteException, UnknownHostException;
    
}