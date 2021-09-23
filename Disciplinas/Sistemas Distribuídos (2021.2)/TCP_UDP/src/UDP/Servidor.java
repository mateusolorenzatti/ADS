package UDP;/*
 * Servidor.java
 *
 * Sistemas Distribu�dos/UTFPR  Prof. Cesar Augusto Tacla
 *
 * Servidor ECHO: fica em aguardo de solicita��o de algum cliente. Quando recebe
 * simplesmente devolve a mensagem. Funcionamento: tiro unico
 */

import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

/*
 * 1- Baseando-se no código exemplo (UDPServer e UDPCliente), fazer um servidor que atenda aos
 * clientes invertendo a string recebida ou fazendo uma modificação qualquer na mensagem recebida.
 */

public class Servidor {
    public static void main(String args[]) {
        try {
            DatagramSocket s = new DatagramSocket(6789); // cria um socket UDP
            byte[] buffer = new byte[1000];
            System.out.println("\n\n*** Servidor aguardando request");
            int requests = 0;

            while (requests < 3) {
                DatagramPacket req = new DatagramPacket(buffer, buffer.length);

                Runnable runnable = () -> {
                    System.out.println(" Thread tratando da requisicao. ");

                    // Inverte a resposta
                    String dataInvertido = new StringBuilder().append(new String(req.getData(), 0, req.getLength())).reverse().toString();

                    System.out.println(dataInvertido);

                    req.setData(dataInvertido.getBytes(StandardCharsets.UTF_8));

                    // Monta e Envia resposta
                    DatagramPacket resp = new DatagramPacket(req.getData(), req.getLength(),
                            req.getAddress(), req.getPort());

                    try {
                        s.send(resp);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                };

                s.receive(req);
                System.out.println("*** Request recebido de: " + req.getAddress() + ":" + req.getPort());
                Thread thread = new Thread(runnable);
                thread.start();

                requests++;
            }

            s.close();
        } catch (SocketException e) {
            System.out.println("Erro de socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro envio/recepcao pacote: " + e.getMessage());
        }
    }
}
