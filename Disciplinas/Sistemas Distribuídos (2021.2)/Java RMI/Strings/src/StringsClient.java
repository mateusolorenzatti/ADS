import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;

public class StringsClient {

    public static void main(String[] args) {

        String host = (args.length < 1) ? null : args[0];
        String msg, serverMsg;
        int opc = 0;

        try {
            Registry registry = LocateRegistry.getRegistry(host);
            Strings stub = (Strings) registry.lookup("Strings");

            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Escolha uma das Opções: ");
            System.out.println(" 1 - Minimizar Texto ");
            System.out.println(" 2 - Maximizar Texto ");
            System.out.println(" 3 - Reverter Texto ");
            System.out.println(" 4 - Dados do Servidor ");
            System.out.println(" -------------------------- ");
            System.out.println(" 0 - Sair ");
            System.out.println("");
            System.out.println(" Sua escolha: ");

            try {
                opc = Integer.parseInt(inFromUser.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (opc) {
                case 1:
                    System.out.println(" Digite o texto: ");
                    msg = inFromUser.readLine();

                    serverMsg = stub.lowerCase(msg);
                    System.out.println("Resposta do Servidor: " + serverMsg);
                    break;

                case 2:
                    System.out.println(" Digite o texto: ");
                    msg = inFromUser.readLine();

                    serverMsg = stub.upperCase(msg);
                    System.out.println("Resposta do Servidor: " + serverMsg);
                    break;

                case 3:
                    System.out.println(" Digite o texto: ");
                    msg = inFromUser.readLine();

                    serverMsg = stub.reverse(msg);
                    System.out.println("Resposta do Servidor: " + serverMsg);
                    break;

                case 4:
                    serverMsg = stub.serverData();
                    System.out.println("Resposta do Servidor: " + serverMsg);
                    break;
            }
        } catch (AccessException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}