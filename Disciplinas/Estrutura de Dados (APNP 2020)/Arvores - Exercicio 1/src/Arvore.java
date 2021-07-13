import javax.xml.soap.Node;
import java.util.LinkedList;
import java.util.Queue;

public class Arvore {

    private NodoArv raiz;

    public Arvore() {
        raiz = null;
    }

    public void insNodo(int item) {
        if (raiz == null)
            raiz = new NodoArv(item);
        else
            insere(raiz, item);
    }

    public void insere(NodoArv raiz, int d) {
        if (d < raiz.getDado()) {
            if (raiz.getEsq() == null)
                raiz.setEsq(new NodoArv(d));
            else
                insere(raiz.getEsq(), d);
        } else {
            if (raiz.getDir() == null)
                raiz.setDir(new NodoArv(d));
            else
                insere(raiz.getDir(), d);
        }
    }


    public void preFixado() {
        preFix(raiz);
    }

    public void preFix(NodoArv raiz) {
        if (raiz == null)
            return;

        System.out.print(raiz.getDado() + " ");

        preFix(raiz.getEsq());
        preFix(raiz.getDir());
    }

    public void central() {
        inFix(raiz);
    }

    public void inFix(NodoArv raiz) {
        if (raiz == null)
            return;

        inFix(raiz.getEsq());

        System.out.print(raiz.getDado() + " ");

        inFix(raiz.getDir());
    }

    public void posFixado() {
        posFix(raiz);
    }

    public void posFix(NodoArv raiz) {
        if (raiz == null)
            return;

        posFix(raiz.getEsq());
        posFix(raiz.getDir());

        System.out.print(raiz.getDado() + " ");
    }

    public boolean pesquisa(int d) {
        //Retorna V ou F, caso o valor exista ou n�o
        boolean res = pesq_arv(raiz, d);
        return res;
    }

    public boolean pesq_arv(NodoArv raiz, int d) {
        //Realiza a pesquisa por um m�todo n�o recursivo.
        boolean achou = false;
        NodoArv aux = raiz;

        while ((achou == false) && (aux != null)) {

            if (aux.getDado() == d) {
                achou = true;
            } else {
                if (d <= aux.getDado())
                    aux = aux.getEsq();
                else
                    aux = aux.getDir();
            }
        }
        return achou;
    }

    public NodoArv pesquisa_rec(int d) {
        //Retorna V ou F, caso o valor exista ou n�o
        NodoArv res = pesq_arv_rec(raiz, d);
        return res;
    }

    public NodoArv pesq_arv_rec(NodoArv raiz, int d) {

        NodoArv res = null;

        if (raiz != null) {
            if (raiz.getDado() == d) {
                res = raiz;
            } else {
                if (d < raiz.getDado())
                    res = pesq_arv_rec(raiz.getEsq(), d);
                else
                    res = pesq_arv_rec(raiz.getDir(), d);
            }
        }
        return res;
    }

    public void remove(int d) {
        NodoArv atual;

        // Verifica se o nodo existe
        atual = this.pesquisa_rec(d);

        if (atual == null) {
            System.out.println("O Elemento " + d + " Nao Esta Presente na Arvore");
        }

        // Chamada de M�todos
        if ((atual.getEsq() == null) && (atual.getDir() == null))
            removeFolha(raiz, d);
        else {
            if ((atual.getEsq() != null) && (atual.getDir() != null))
                removeDoisFilhos(raiz, d);
            else
                removeUmFilho(raiz, d);
        }
    }

    public void removeFolha(NodoArv raiz, int d) {
        // Remove uma folha da �rvore - Nodo folha n�o possui filhos
        NodoArv atual, pai;
        boolean achou = false;

        atual = raiz;
        pai = null;

        while ((atual != null) && (achou == false)) {

            if (d == atual.getDado()) {

                if (pai == null) { //raiz da �rvore, seta raiz com null
                    this.raiz = null;
                } else {
                    if (atual.getDado() < pai.getDado())
                        pai.setEsq(null);
                    else
                        pai.setDir(null);
                }
                achou = true;
            } else {
                if (d < atual.getDado()) {
                    pai = atual;
                    atual = atual.getEsq();
                } else {
                    pai = atual;
                    atual = atual.getDir();
                }
            }
        }
    }

    public void removeUmFilho(NodoArv raiz, int d) {
        //Remove um nodo que possui um filho
        NodoArv atual, pai;
        boolean achou = false;

        atual = raiz;
        pai = null;

        while ((atual != null) && (achou == false)) {

            if (d == atual.getDado()) {
                if (pai == null) { //raiz da �rvore
                    if (atual.getEsq() != null) {
                        this.raiz = atual.getEsq();
                    } else {
                        this.raiz = atual.getDir();
                    }
                } else {
                    if ((atual.getDir() == null) && (atual.getEsq() != null)) {
                        if (pai.getEsq() == atual)
                            pai.setEsq(atual.getEsq());

                        if (pai.getDir() == atual)
                            pai.setDir(atual.getEsq());
                    }

                    if ((atual.getEsq() == null) && (atual.getDir() != null)) {
                        if (pai.getEsq() == atual)
                            pai.setEsq(atual.getDir());
                        if (pai.getDir() == atual)
                            pai.setDir(atual.getDir());
                    }

                }
                achou = true;
            } else {
                if (d < atual.getDado()) {
                    pai = atual;
                    atual = atual.getEsq();
                } else {
                    pai = atual;
                    atual = atual.getDir();
                }
            }
        }
    } // fim m�todo remove com 1 filho


    public void removeDoisFilhos(NodoArv raiz, int d) {
        //Remove um nodo que possui dois filhos

        NodoArv atual, pai;
        boolean achou = false;

        atual = raiz;
        pai = raiz;

        while ((atual != null) && (achou == false)) {

            if (d == atual.getDado()) {
                //Desce � esquerda e depois � extrema direita do nodo a ser removido
                NodoArv aux = atual.getEsq();
                NodoArv ant = atual;

                while (aux.getDir() != null) {
                    ant = aux;
                    aux = aux.getDir();
                }
                //Nodo Folha
                if ((aux.getEsq() == null) && (aux.getDir() == null)) {
                    atual.setDado(aux.getDado());
                    if (ant == atual) { //um nivel abaixo da raiz da �rvore
                        atual.setEsq(null); //anula a arvore da esq, a partir da raiz
                    } else {
                        ant.setDir(null);
                    }
                }

                //Nodo com um filho � esquerda
                if ((aux.getEsq() != null) && (aux.getDir() == null)) {
                    atual.setDado(aux.getDado());

                    if (ant.getDir() == aux) {
                        ant.setDir(aux.getEsq());
                    }
                    if (ant.getEsq() == aux) {
                        ant.setEsq(aux.getEsq());
                    }
                    aux.setDir(null);
                    aux.setEsq(null);
                }
                achou = true;
            } else {
                if (d < atual.getDado()) {
                    pai = atual;
                    atual = atual.getEsq();
                } else {
                    pai = atual;
                    atual = atual.getDir();
                }
            }
        }
    }// fim do m�todo

    // Exercício 2
    public int encontraMenorNaoRecursivo() {
        NodoArv menor = raiz;

        while (menor.getEsq() != null) menor = menor.getEsq();

        return menor.getDado();
    }

    // Exercício 3
    public int encontraMaiorRecursivo() {
        return maiorValor(raiz).getDado();
    }

    private NodoArv maiorValor(NodoArv ref) {
        if (ref.getDir() == null) {
            return ref;
        } else {
            return maiorValor(ref.getDir());
        }
    }

    // Exercício 4
    private int numeroDePares = 0;

    public int encontraNumerosParesRecursivo() {
        this.numeroDePares = 0;
        this.atualizaNodosPares(raiz);
        return this.numeroDePares;
    }

    private void atualizaNodosPares(NodoArv ref) {
        if (ref != null) {
            atualizaNodosPares(ref.getEsq());

            if (ref.getDado() % 2 == 0) this.numeroDePares++;

            atualizaNodosPares(ref.getDir());
        }
    }

    // Exercício 5
    private int somaDosPrimos = 0;

    public int encontraSomaDePrimosRecursivo() {
        this.somaDosPrimos = 0;
        this.somaPrimos(raiz);
        return this.somaDosPrimos;
    }

    private void somaPrimos(NodoArv ref) {
        if (ref != null) {
            somaPrimos(ref.getEsq());

            if (ePrimo(ref.getDado())) this.somaDosPrimos += ref.getDado();

            somaPrimos(ref.getDir());
        }
    }

    private boolean ePrimo(int num) {
        boolean flag = false;
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                flag = true;
                break;
            }
        }

        return !flag;
    }

    //Exercicio 6
    public int alturaDaArvore() {
        return this.getAltura(raiz);
    }

    private int getAltura(NodoArv ref) {
        if (ref.getEsq() == null && ref.getDir() == null)
            return 0;

        int left = 0;
        if (ref.getEsq() != null)
            left = getAltura(ref.getEsq());

        int right = 0;
        if (ref.getDir() != null)
            right = getAltura(ref.getDir());

        return (Math.max(left, right) + 1);
    }

    //Exercicio 7
    public int encontraNumeroDeNodosNaoRecursivo() {
        if (raiz == null)
            return 0;

        Queue<NodoArv> queue = new LinkedList<NodoArv>();

        queue.add(raiz);

        int count = 0;
        while (!queue.isEmpty()) {

            NodoArv temp = queue.poll();
            if (temp.getEsq() != null && temp.getDir() != null)
                count++;

            if (temp.getEsq() != null) {
                queue.add(temp.getEsq());
            }

            if (temp.getDir() != null) {
                queue.add(temp.getDir());
            }
        }
        return count;
    }
}
