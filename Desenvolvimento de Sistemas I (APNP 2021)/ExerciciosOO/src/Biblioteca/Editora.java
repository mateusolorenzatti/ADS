package Biblioteca;

import java.io.Serializable;

public class Editora implements Serializable  {
    private String nome;
    private String email;
    private String endereco;
    private String cnpj;

    public Editora(String nome, String email, String endereco, String cnpj) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.cnpj = cnpj;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
