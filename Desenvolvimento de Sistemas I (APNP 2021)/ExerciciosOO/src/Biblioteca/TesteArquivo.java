package Biblioteca;

import IED.Data;

import java.util.ArrayList;

public class TesteArquivo {

    public static void main(String[] args) {
        ArrayList<Obra> obras;

        obras = ArquivoObras.lerObras();

        if (obras == null) { obras = new ArrayList<>(); }

        obras.add(lerObra());

        ArquivoObras.escreverObras(obras);

        TesteArquivo.mostrartLista(obras);
    }

    public static void mostrartLista(ArrayList<Obra> obras){
        obras.forEach( o -> {
            System.out.println(" Obra: " + o.getTitulo());
            System.out.println(" Autor: " + o.getAutor().getNome());
            System.out.println(" Genero: " + o.getGenero() + "\n");
        } );
    }

    public static Obra lerObra(){
        Leitura letec = new Leitura();

        String titulo = letec.leString(" Insira o nome da Obra: ");
        String autor = letec.leString(" Insira o nome do Autor: ");
        String genero = letec.leString(" Insira o Gênero: ");

        return new Obra(titulo, genero, new Autor(autor));
    }
}
