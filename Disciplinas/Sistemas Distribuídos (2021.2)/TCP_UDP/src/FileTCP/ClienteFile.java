package FileTCP;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ClienteFile {
    public static void main(String[] args) throws Exception {
        String fileName;

        Socket socket = new Socket("10.0.0.119", 5000);

        BufferedReader inFromUSer = new BufferedReader(new InputStreamReader(System.in));

        DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
        fileName = inFromUSer.readLine();
        outToServer.writeBytes(fileName + "\n");

        byte[] contents = new byte[10000];

        FileOutputStream fos = new FileOutputStream("/home/mateusolorenzatti/desenv/IFRS/ADS/Disciplinas/Sistemas Distribuídos (2021.2)/TCP_UDP/clientFiles/teste.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        InputStream is = socket.getInputStream();

        int bytesRead = 0;
        while ((bytesRead = is.read(contents)) != -1)
            bos.write(contents, 0, bytesRead);
        bos.flush();
        socket.close();
        System.out.println("File saved successfully!");
    }
}
