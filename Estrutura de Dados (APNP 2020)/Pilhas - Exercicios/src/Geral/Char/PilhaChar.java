package Geral.Char;

public class PilhaChar {

    NodoChar topo;

    public PilhaChar() {
        topo = null;
    }

    public boolean isEmpty() { //Testa se a pilha est� vazia
        return topo == null;
    }

    public int tamanho(){
        if ( this.isEmpty() ) return 0;

        NodoChar atual = topo;
        int res=0;

        while(atual != null){
            res++;
            atual = atual.getAnt();
        }
        return res;
    }

    public void push(char dado) { // Empilha
        NodoChar aux = new NodoChar(dado);
        if (topo == null) {
            topo = aux;
        } else {
            aux.setAnt(topo);
            topo = aux;
        }
    }

    public NodoChar pop() { //Desempilha
        NodoChar aux = null;
        if (this.isEmpty() == false) { //Geral.Char.Int.Pilha n�o est� vazia
            aux = topo;
            topo = topo.getAnt();
            aux.setAnt(null);
        }
        return aux;
    }

    public NodoChar peek() { //Retorna o topo da pilha, mas n�o retira da pilha
        NodoChar aux = null;
        if (this.isEmpty() == false) {
            aux = new NodoChar(topo.getCh());//Cria uma c�pia do nodo do topo da pilha
        }

        return aux;
    }
}