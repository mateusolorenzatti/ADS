package Objects;

public class Livro {
    private String titulo;
    private String midia;
    private String genero;
    private String idioma;
    private String ano;
    private String ISBN;

    private String autor;
    private String editora;

    public Livro() {
    }

    public Livro(String ISBN, String titulo, String midia, String genero, String idioma, String ano, String autor, String editora) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.midia = midia;
        this.genero = genero;
        this.idioma = idioma;
        this.ano = ano;
        this.autor = autor;
        this.editora = editora;
    }

    public Livro(String titulo, String genero, String autor, String ISBN) {
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;
        this.ISBN = ISBN;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "ISBN='" + ISBN + '\'' +
                ", titulo='" + titulo + '\'' +
                ", midia='" + midia + '\'' +
                ", genero='" + genero + '\'' +
                ", idioma='" + idioma + '\'' +
                ", ano='" + ano + '\'' +
                ", autor='" + autor + '\'' +
                ", editora='" + editora + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return this.ISBN == livro.ISBN;
    }
}
