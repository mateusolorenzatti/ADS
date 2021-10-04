package FileTCP;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorFile {
    public static void main(String[] args) throws Exception {
        int PORT = 5000;

        ServerSocket ssock = new ServerSocket(PORT);
        System.out.println("\n\n*** Servidor aguardando na porta " + PORT);

        Socket socket = ssock.accept();

        File file = new File("/home/mateusolorenzatti/desenv/IFRS/ADS/Disciplinas/Sistemas Distribuídos (2021.2)/TCP_UDP/serverFiles/teste.txt");
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);

        OutputStream os = socket.getOutputStream();

        byte[] contents;
        long fileLength = file.length();
        long current = 0;

        while (current != fileLength) {
            int size = 10000;
            if (fileLength - current >= size)
                current += size;
            else {
                size = (int) (fileLength - current);
                current = fileLength;
            }
            contents = new byte[size];
            bis.read(contents, 0, size);
            os.write(contents);
            System.out.print("Sending file ... " + (current * 100) / fileLength + "% complete!");
        }
        os.flush();

        socket.close();
        ssock.close();
        System.out.println("File sent succesfully!");
    }
}