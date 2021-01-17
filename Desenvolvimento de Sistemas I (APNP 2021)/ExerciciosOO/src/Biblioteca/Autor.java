package Biblioteca;

import IED.Data;

public class Autor {
    private String nome;
    private String email;
    private String nacionalidade;
    private Data dataNacimento;

    public Autor(String nome, String email, String nacionalidade, Data dataNacimento) {
        this.nome = nome;
        this.email = email;
        this.nacionalidade = nacionalidade;
        this.dataNacimento = dataNacimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Data getDataNacimento() {
        return dataNacimento;
    }

    public void setDataNacimento(Data dataNacimento) {
        this.dataNacimento = dataNacimento;
    }
}
