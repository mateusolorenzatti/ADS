package Biblioteca;

import IED.Data;

import java.util.ArrayList;

public class TesteArquivo {

    public static void main(String[] args) {
        ArrayList<Obra> obras;
        TesteArquivo ta = new TesteArquivo();

        obras = ArquivoObras.abrir();

        if (obras == null) {
            obras = new ArrayList<>();
        }

        char op = ta.menu();

        while (op != '0') {

            switch (op) {
                case '1':
                    ta.mostrarListas(obras);
                    break;
                case '2':
                    obras.add(ta.lerObra());
                    break;
                case '3':
                    ArquivoObras.salvar(obras);
                    break;
                default:
                    System.out.println(" Opção Inválida! ");
                    break;
            }

            op = ta.menu();
        }

        System.out.println(" Saindo... ");
    }

    public void mostrarListas(ArrayList<Obra> obras) {
        obras.forEach(o -> {
            System.out.println(" Obra: " + o.getTitulo());
            System.out.println(" Autor: " + o.getAutor().getNome());
            System.out.println(" Genero: " + o.getGenero() + "\n");
        });
    }

    public Obra lerObra() {
        Leitura letec = new Leitura();

        String titulo = letec.leString(" Insira o nome da Obra: ");
        String autor = letec.leString(" Insira o nome do Autor: ");
        String genero = letec.leString(" Insira o Gênero: ");

        return new Obra(titulo, genero, new Autor(autor));
    }

    public char menu() {
        Leitura letec = new Leitura();

        System.out.println(" Digite: ");
        System.out.println(" 1 - Ver Lista de Obras; ");
        System.out.println(" 2 - Adicionar Obras; ");
        System.out.println(" 3 - Salvar Arquivo; ");
        System.out.println(" 0 - Salvar e Sair \n");

        return letec.leChar(" Sua Opção: ");
    }
}
