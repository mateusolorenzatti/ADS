/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 * @author coelho
 * <p>
 * create table Livro (
 * id SERIAL PRIMARY KEY,
 * titulo VARCHAR(40) NULL,
 * midia VARCHAR(40) NULL,
 * genero VARCHAR(40) NULL,
 * idioma VARCHAR(40) NULL,
 * ano DATE NULL,
 * autor VARCHAR(80) NULL,
 * editora VARCHAR(80) NULL
 * )
 */


public class SQL_Constantes {

    public static final String INSERT = "insert into "
            + "aluno (matricula, nome, nota1, nota2, nota3, media) "
            + "values (?,?,?,?,?,?)";

    public static final String UPDATE = "update aluno set "
            + "nota1=?, nota2=?, nota3=?, media=? where matricula=?";

    public static final String REMOVE = "delete from aluno where matricula=?";

    public static final String SEARCH = "select * from aluno";

    // =========================================================================

    public static final String INSERT_LIVRO = "INSERT INTO public.livro\n" +
            "(midia, genero, idioma, ano, autor, editora, titulo, isbn)\n" +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?);\n";

    public static final String UPDATE_LIVRO = "UPDATE public.livro" +
            "SET midia='', genero='', idioma='', ano='', autor='', editora='', titulo=''" +
            "WHERE isbn=?";

    public static final String REMOVE_LIVRO = "delete from public.livro where isbn=?";

    public static final String SEARCH_LIVRO = "SELECT midia, genero, idioma, ano, autor, editora, titulo, isbn\n" +
            "FROM public.livro;\n";

}