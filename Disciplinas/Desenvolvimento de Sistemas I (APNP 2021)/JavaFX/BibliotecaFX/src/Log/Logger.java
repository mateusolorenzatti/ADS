package Log;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//@author mateusolorenzatti

public class Logger {
    private static final String LOG_PATH = "/home/mateusolorenzatti/desenv/IFRS/ADS/Desenvolvimento de Sistemas I (APNP 2021)/JavaFX/BibliotecaFX/res/db_log.txt";

    public static void logar(String descricao, Exception e) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        String stacktrace = sw.toString();

        File f = new File(LOG_PATH);

        if(!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }

        if(!f.exists()) {
            try {
                f.createNewFile();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

        FileWriter fileWriter = null; //Set true for append mode
        try {
            fileWriter = new FileWriter(LOG_PATH, true);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(" ------------------------------------------------------------------------------------ ");
            printWriter.println(" Data/Hora: " + dtf.format(now));
            printWriter.println(" Descricao: " + descricao);
            printWriter.println(" Stack Trace: " + stacktrace);
            printWriter.println(" ------------------------------------------------------------------------------------ ");

            printWriter.close();

        } catch (IOException ei) {
            ei.printStackTrace();
        }
    }

    public static void logar(String descricao) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        File f = new File(LOG_PATH);

        if(!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }

        if(!f.exists()) {
            try {
                f.createNewFile();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

        FileWriter fileWriter = null; //Set true for append mode
        try {
            fileWriter = new FileWriter(LOG_PATH, true);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(" ------------------------------------------------------------------------------------ ");
            printWriter.println(" Data/Hora: " + dtf.format(now));
            printWriter.println(" Descricao: " + descricao);
            printWriter.println(" ------------------------------------------------------------------------------------ ");

            printWriter.close();

        } catch (IOException ei) {
            ei.printStackTrace();
        }
    }
}
