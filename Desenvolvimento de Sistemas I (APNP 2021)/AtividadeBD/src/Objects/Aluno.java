package Objects;

import java.util.Objects;

public class Aluno {

    private int matricula;
    private String nome;
    private float nota1, nota2, nota3, media;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String novo) {
        this.nome = novo;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int metricula) {
        this.matricula = metricula;
    }

    public float getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    public float getNota3() {
        return nota3;
    }

    public void setNota3(float nota3) {
        this.nota3 = nota3;
    }

    public float getMedia() {
        if (media == 0) {
            calculaMedia();
        }
        return media;
    }

    private void calculaMedia() {
        this.media = (this.nota1 + this.nota2+ this.nota3) / 3;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public Aluno(int id, String nome, float nota1, float nota2, float nota3) {
        this.matricula = id;
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        calculaMedia();
    }

    public Aluno(String nome, float nota1, float nota2, float nota3) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        calculaMedia();
    }

    public Aluno() {
    }

    @Override
    public String toString() {
        return "Aluno{" + "matricula=" + matricula + ", nome=" + nome + ", nota1=" + nota1 + ", nota2=" + nota2 + ", nota3=" + nota3 + ", media=" + media + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return matricula == aluno.matricula;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }
}
