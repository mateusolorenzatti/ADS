/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 * @author coelho

-- public.livro definition

-- Drop table

-- DROP TABLE public.livro;

CREATE TABLE public.livro (
id serial NOT NULL,
midia varchar(40) NULL,
genero varchar(40) NULL,
idioma varchar(40) NULL,
ano varchar(10) NULL,
autor varchar(80) NULL,
editora varchar(80) NULL,
titulo varchar(40) NULL,
isbn varchar(40) NULL,
CONSTRAINT livro_isbn_key UNIQUE (isbn),
CONSTRAINT livro_pkey PRIMARY KEY (id),
CONSTRAINT livro_titulo_key UNIQUE (titulo)
);

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
            "SET midia=?, genero=?, idioma=?, ano=?, autor=?, editora=?, titulo=?" +
            "WHERE isbn=?";

    public static final String REMOVE_LIVRO = "delete from public.livro where isbn=?";

    public static final String SEARCH_LIVRO = "SELECT midia, genero, idioma, ano, autor, editora, titulo, isbn\n" +
            "FROM public.livro;\n";

}
