package Exercicio2;

import Geral.Int.PilhaInt;

public class OrdenadorPilhas {
    private PilhaInt temp;
    private PilhaInt res;

    public OrdenadorPilhas() {
        this.temp = new PilhaInt();
        this.res = new PilhaInt();
    }

    public static void main(String[] args) {
        OrdenadorPilhas tst = new OrdenadorPilhas();
        PilhaInt p1 = new PilhaInt();
        PilhaInt p2 = new PilhaInt();

        p1.push(2);
        p1.push(1);
        p1.push(5);
        p1.push(7);

        p2.push(1);
        p2.push(3);
        p2.push(8);

        tst.ordenaTerceiraPilha(p1, p2);
        System.out.println(" Resultado: " + tst.resultadoStr());
    }

    private void ordenarPilha(PilhaInt input) {
        while (input.tamanho() != 0) {
            int tmp = input.peek().getDado();
            input.pop();

            while (this.temp.tamanho() != 0 && this.temp.peek().getDado() > tmp) {

                input.push(this.temp.peek().getDado());
                this.temp.pop();
            }

            this.temp.push(tmp);
        }
    }

    public void ordenaTerceiraPilha(PilhaInt p1, PilhaInt p2) {
        while (p1.tamanho() != 0) {
            res.push(p1.peek().getDado());
            p1.pop();
        }

        while (p2.tamanho() != 0) {
            res.push(p2.peek().getDado());
            p2.pop();
        }

        this.ordenarPilha(res);
    }

    public String resultadoStr(){
        String res = "";

        while (temp.tamanho() != 0) {
            res += temp.peek().getDado() + " ";
            temp.pop();
        }

        return res;
    }
}
