package model;

import java.io.Serializable;

public class Jogador implements Serializable, Comparable<Jogador> {
    private static final long serialVersionUID = 7727965430392518861L;
    
    private String usuario;
    private String senha;
    private String nome;
    private String fone;
    private Pontuacao pontuacao;

    public Jogador(String usuario, String senha, String nome, String fone, Pontuacao pontuacao) {
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
        this.fone = fone;
        this.pontuacao = pontuacao;
    }

    public Jogador(String usuario, String senha, String nome, String fone) {
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
        this.fone = fone;
        this.pontuacao = new Pontuacao();
    }

    public Jogador() {
        this.usuario = "";
        this.senha = "";
        this.nome = "";
        this.fone = "";
        this.pontuacao = new Pontuacao();
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public Pontuacao getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Pontuacao pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public String toString() {
        String aux_pontuacao = pontuacao.toString();
        return "Jogador [usuario=" + usuario + ", senha=" + senha + ", nome=" + nome + ", fone=" + fone + ", pontuacao="
                + aux_pontuacao + "]";
    }

    @Override
    public int compareTo(Jogador o) {
        if(this.getPontuacao().getAcumulado() != o.getPontuacao().getAcumulado()){
            return o.getPontuacao().getAcumulado() - this.getPontuacao().getAcumulado();
        }else{
            if(this.getPontuacao().getPartidas() != o.getPontuacao().getPartidas()){
                return o.getPontuacao().getPartidas() - this.getPontuacao().getPartidas();
            }else{
                return o.getPontuacao().getUltPartida() - this.getPontuacao().getUltPartida();
            }
        }
    }

}
