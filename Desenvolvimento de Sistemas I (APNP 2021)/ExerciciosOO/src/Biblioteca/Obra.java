package Biblioteca;

import java.io.Serializable;

public class Obra implements Serializable {
    private String titulo;
    private String midia;
    private String genero;
    private String idioma;
    private String ano;

    private Autor autor;
    private Editora editora;

    public Obra(String titulo, String midia, String genero, String idioma, String ano, Autor autor, Editora editora) {
        this.titulo = titulo;
        this.midia = midia;
        this.genero = genero;
        this.idioma = idioma;
        this.ano = ano;
        this.autor = autor;
        this.editora = editora;
    }

    public Obra(String titulo, String genero, Autor autor) {
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMidia() {
        return midia;
    }

    public void setMidia(String midia) {
        this.midia = midia;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }
}
