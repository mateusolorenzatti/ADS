package sample;

import javafx.scene.control.RadioButton;

public class Pesquisa {
    private String nome;
    private String SO;
    private String linguagem;
    private String gostaProgramacao;
    private String programaTodoDia;

    public Pesquisa() { }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSO() {
        return SO;
    }

    public void setSO(String SO) {
        this.SO = SO;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    public String getGostaProgramacao() {
        return gostaProgramacao;
    }

    public void setGostaProgramacao(String gostaProgramacao) {
        this.gostaProgramacao = gostaProgramacao;
    }

    public String getProgramaTodoDia() {
        return programaTodoDia;
    }

    public void setProgramaTodoDia(String programaTodoDia) {
        this.programaTodoDia = programaTodoDia;
    }

    @Override
    public String toString() {
        return "Pesquisa{" +
                "nome='" + nome + '\'' +
                ", SO='" + SO + '\'' +
                ", linguagem='" + linguagem + '\'' +
                ", gostaProgramacao='" + gostaProgramacao + '\'' +
                ", programaTodoDia='" + programaTodoDia + '\'' +
                '}';
    }
}
