package Biblioteca;

import java.io.*;
import java.util.ArrayList;

public class ArquivoObras {

    public static void escreverObras(ArrayList<Obra> obras) {
        try {
            File f = new File("obras.bin");
            if (!f.exists()) {
                f.createNewFile();
            }
            try (FileOutputStream fos = new FileOutputStream(f);
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {

                oos.writeObject(obras);
            }
            System.out.println(" Salvo com sucesso!");

        } catch (IOException e) {
            System.err.println("Erro ao criar o arquivo obras.bin.");
            e.printStackTrace();
        }
    }

    public static ArrayList<Obra> lerObras() {
        ArrayList<Obra> res = null;

        try {
            File f = new File("obras.bin");
            if (f.exists()) {

                try (FileInputStream fis = new FileInputStream(f);
                     ObjectInputStream ois = new ObjectInputStream(fis)) {

                    res = (ArrayList<Obra>) ois.readObject();

                    System.out.println(" Leitura com sucesso!");
                } catch (ClassNotFoundException ex) {
                    System.err.println("Erro ao ler objeto de obras.bin.");
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao abrir o arquivo obras.bin.");
        } finally {
            return res;
        }
    }
}
