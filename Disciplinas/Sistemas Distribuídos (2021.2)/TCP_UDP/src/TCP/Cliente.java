package TCP;

import java.net.*;
import java.io.*;

public class Cliente {

   public static void main(String[] args) {

       String sentence;
       String modifiedSentence;

       try {
    
            // Cria um buffer que armazenará as informações de entrada do teclado
            BufferedReader inFromUSer = new BufferedReader(new InputStreamReader(System.in));
    
            // Cria um Socket cliente passando como parâmetro o ip e a porta do servidor   
            Socket client = new Socket("192.168.1.103",40001);
    
            // Cria um stream de saída 
            DataOutputStream outToServer = new DataOutputStream(client.getOutputStream());
   
            // Cria um buffer que armazenará as informações retornadas pelo servidor
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
    
            // Atribui as informações armazenadas no buffer do teclado à variável "sentence"
            sentence = inFromUSer.readLine();
    
            // Disponibiliza as informações contidas em "sentence" para a stream de saída do cliente
            outToServer.writeBytes(sentence + "\n");
    
            // Atribui as informações modificadas pelo servidor na variável "modifiedSentence"
            modifiedSentence = inFromServer.readLine();
    
            // Imprime no console do cliente a informação retornada pelo servidor
            System.out.println("Servidor Respondeu: " + modifiedSentence);
    
            // Fecha o Socket
            client.close();   

       } catch (UnknownHostException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       } catch (IOException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
   } 
}