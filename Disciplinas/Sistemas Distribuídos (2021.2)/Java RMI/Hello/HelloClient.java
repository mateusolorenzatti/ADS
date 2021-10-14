/**
 * HelloClient.java
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.registry.*;

public class HelloClient {
    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        String msg;

        try {
            // Obtém uma referência para o registro do RMI
            Registry registry = LocateRegistry.getRegistry(host);

            // Lê a mensagem do terminal
            BufferedReader inFromUSer = new BufferedReader(new InputStreamReader(System.in));
            msg = inFromUSer.readLine();

            // Obtém a stub do servidor
            HelloWorld stub = (HelloWorld) registry.lookup("Hello");

            // Chama o método do servidor e imprime a mensagem
            String serverMsg = stub.hello(msg);
            System.out.println("Mensagem do Servidor: " + serverMsg);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}