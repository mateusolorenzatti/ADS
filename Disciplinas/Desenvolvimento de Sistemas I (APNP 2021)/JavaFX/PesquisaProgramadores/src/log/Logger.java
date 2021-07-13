package log;

import sample.Pesquisa;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//@author mateusolorenzatti

public class Logger {
    private static final String LOG_PATH = "/home/mateusolorenzatti/desenv/IFRS/ADS/Desenvolvimento de Sistemas I (APNP 2021)/JavaFX/PesquisaProgramadores/res/pesquisa.txt";

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

    public static void registrarPesquisa(Pesquisa pes) {
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

            printWriter.println(" Data/Hora: " + dtf.format(now));
            printWriter.println(" Dados da Pesquisa:");
            printWriter.println("   Nome: " + pes.getNome());
            printWriter.println("   SO: " + pes.getSO());
            printWriter.println("   Linguagem Preferida: " + pes.getLinguagem());
            printWriter.println("   Programa todo Dia? " + pes.getProgramaTodoDia());
            printWriter.println("   Gosta de Programação? " + pes.getGostaProgramacao());
            printWriter.println(" ------------------------------------------------------------------------------------ ");

            printWriter.close();

        } catch (IOException ei) {
            ei.printStackTrace();
        }
    }
}
