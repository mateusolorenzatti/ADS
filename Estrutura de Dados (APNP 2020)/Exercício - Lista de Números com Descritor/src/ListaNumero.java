public class ListaNumero {
    private Descritor descritor;

    public ListaNumero(){
        descritor = new Descritor();
    }

    private boolean insereInicio(Numero numero){
        Nodo novo = new Nodo(numero);

        if(descritor.getInicio() == null){
            descritor.setInicio(novo);
            descritor.setFim(novo);
        }
        else{
            novo.setProx(descritor.getInicio());
            descritor.setInicio(novo);
        }
        descritor.incrementaTamanho();

        return true;
    }


    private boolean insereFim(Numero numero){
        Nodo novo = new Nodo(numero);

        if(descritor.getInicio() == null){
            descritor.setInicio(novo);
            descritor.setFim(novo);
        }
        else{
            descritor.getFim().setProx(novo);
            descritor.setFim(descritor.getFim().getProx());
        }

        descritor.setMaior(novo);
        descritor.incrementaTamanho();
        return true;
    }

    private boolean inserePosicao(Numero numero, int pos){
        Nodo novo = new Nodo(numero);
        Nodo atual = descritor.getInicio();
        Nodo ant = descritor.getInicio();
        boolean res = false;

        int i=0;


        if((pos<0) || (pos > descritor.getTamanho())) { //Posi��o inv�lida
            return res; // Retorna false, n�o inseriu
        }

        if((descritor.getTamanho() == 0) || (pos == 0)){ // Lista Vazia ou posi��o informada � zero
            res = this.insereInicio(numero);
        }
        else{
            if(pos == descritor.getTamanho()){
                res = this.insereFim(numero);
            }
            else{ //posicao v�lida
                for(i=0;i<pos;i++){
                    ant = atual;
                    atual = atual.getProx();
                }
                ant.setProx(novo);

                novo.setProx(atual);
                res = true;
            }
            descritor.incrementaTamanho();
        }
        return res;
    }

    public boolean insereAntesDoMaior(Numero numero){

        if ( descritor.getTamanho() > 0) {

            Nodo atual = descritor.getInicio();
            int pos = 0;

            while(atual != null){
                if( (atual.getProx() == descritor.getMaior()) && (numero.getNumero() < descritor.getMaior().getNumero().getNumero()) ){
                    if (descritor.getTamanho() > 1) pos ++;

                    return this.inserePosicao(numero, pos);
                }
                pos ++;
                atual = atual.getProx();
            }

            return this.insereFim(numero);
        }else{
            return this.insereFim(numero);
        }
    }

    @Override
    public String toString() {
        String retorno = "";

        Nodo atual = descritor.getInicio();
        int pos = 0;

        while(atual != null){
            retorno += atual.getNumero().toString();
            atual = atual.getProx();
        }

        return retorno;
    }
}
