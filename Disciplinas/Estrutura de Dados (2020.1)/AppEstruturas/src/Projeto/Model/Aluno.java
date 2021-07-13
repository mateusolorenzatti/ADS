package Projeto.Model;

import java.time.Year;
import java.util.Calendar;

/*
 * @author Rogério Xavier
 */
public class Aluno implements Comparable<Aluno>{

    String nome;
    int nascimento;

    public Aluno(String nome, int nascimento) {
        this.nome = nome;
        this.nascimento = nascimento;
    }

    public int getIdade() {
        return (Year.now().getValue()) - this.nascimento;
    }

    @Override
    public int compareTo(Aluno o) {
        if (this.getIdade() < o.getIdade()) {
            return 1;
        }else if (this.getIdade() > o.getIdade()){
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Aluno{" + "nome=" + nome + ", nascimento="+ getIdade() + "}";
    }

}
