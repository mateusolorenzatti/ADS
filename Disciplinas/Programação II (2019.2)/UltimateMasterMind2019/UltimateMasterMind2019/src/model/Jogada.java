package model;

import javafx.beans.property.SimpleStringProperty;

public class Jogada {
    private String  senha;
    private int  posicoes;
    private int  caracteres;

    public Jogada() {
    }

    public Jogada(String senha, int posicoes, int caracteres) {
        this.senha = senha;
        this.posicoes = posicoes;
        this.caracteres = caracteres;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getPosicoes() {
        return posicoes;
    }

    public void setPosicoes(int posicoes) {
        this.posicoes = posicoes;
    }

    public int getCaracteres() {
        return caracteres;
    }

    public void setCaracteres(int caracteres) {
        this.caracteres = caracteres;
    }

    
}