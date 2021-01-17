package Biblioteca;

import IED.Data;

public class Teste {

    public static void main(String[] args) {

        Usuario aluno = new Usuario("Mateus", "15265346346", "Rua X", "mateus@gmail.com", "Aluno");

        Autor autor = new Autor("George Orwell", "george@gmail.com", "Britânico", new Data(25, 6, 1903));
        Editora editora = new Editora("Novo Mundo", "editoranovomundo@yahoo.com", "Rua B, Porto Alegre", "3526256360000123");

        Obra livro = new Obra("1984", "Livro Impresso / Entretenimento", "Ficção Política", "Portugês", "1949", autor, editora);

    }
}
