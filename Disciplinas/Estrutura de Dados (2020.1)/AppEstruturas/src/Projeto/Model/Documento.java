
package Projeto.Model;

/*
 * @author Rogério Xavier
 */
public class Documento implements Comparable<Documento>{  // implementa a interface Comparable de define um método compareTo
    String nome;
    double tamanho;

    public Documento(String nome, double tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
    }
  
    public Documento() {
        this.nome = "";
        this.tamanho = 0.0;
    }
    
    public String getNome() {
        return nome;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }


    public String toString() {
        return "Documento[" + "nome=" + this.nome + ", tamanho=" + this.tamanho + "]";
    }
    
    
    /*
    O método compareTo é implementado da interface Comparable e trabalha com um desses valores
    A > B return 1
    A < B return -1
    A = B return 0
    Este método é utilizado para definir uma comparação entre documentos
    */
    public int compareTo(Documento doc){
        if (this.tamanho > doc.getTamanho()){
            return 1;
        }else if (this.tamanho < doc.getTamanho()){
            return -1;
        }
        return 0;
    }
    
}
