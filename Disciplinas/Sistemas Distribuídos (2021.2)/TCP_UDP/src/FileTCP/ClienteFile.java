package FileTCP;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClienteFile {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("10.0.0.119", 5000);
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
