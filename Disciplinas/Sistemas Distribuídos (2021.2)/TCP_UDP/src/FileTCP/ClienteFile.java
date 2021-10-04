package FileTCP;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClienteFile {
    public static void main(String[] args) throws Exception {
        String fileName;

        try{
                Socket socket = new Socket("10.0.0.119", 5000);

            BufferedReader inFromUSer = new BufferedReader(new InputStreamReader(System.in));

            DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
            fileName = inFromUSer.readLine();
            outToServer.writeBytes(fileName + "\n");

            byte[] contents = new byte[10000];

            FileOutputStream fos = new FileOutputStream("/home/mateusolorenzatti/desenv/educacional/IFRS/ADS/Disciplinas/Sistemas Distribuídos (2021.2)/TCP_UDP/clientFiles/" + fileName);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            InputStream is = socket.getInputStream();

            int bytesRead = 0;
            while ((bytesRead = is.read(contents)) != -1)
                bos.write(contents, 0, bytesRead);

            String retorno = new String(contents, StandardCharsets.UTF_8);
            if (retorno.contains("Arquivo Inexistente!")){
                System.out.println("O Arquivo não foi encontrado... Resposta do servidor: " + retorno);
            }else{
                System.out.println("Arquivo salvo com sucesso!");
            }

            bos.flush();
            socket.close();

        }catch(ConnectException ce){
            System.out.println("Servidor Indisponivel!");
        }        
    }
}
