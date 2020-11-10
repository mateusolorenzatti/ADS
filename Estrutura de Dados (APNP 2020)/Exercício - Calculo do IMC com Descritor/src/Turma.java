public class Turma {
    private Descritor descritor;

    public Turma() {
        descritor = new Descritor();
    }

    //Insere no In�cio da Lista
    public boolean insereInicio(Aluno aluno) {
        Nodo novo = new Nodo(aluno);
        if (descritor.getInicio() == null) {
            descritor.setInicio(novo);
            descritor.setFim(novo);
        } else {
            novo.setProx(descritor.getInicio());
            descritor.getInicio().setAnt(novo);
            descritor.setInicio(novo);
        }
        this.incrementa(aluno);

        return true; //Sempre consegue inserir se tiver mem�ria
    }

    //Insere no fim da lista
    public boolean insereFim(Aluno aluno) {
        Nodo novo = new Nodo(aluno);
        if (descritor.getInicio() == null) {
            descritor.setInicio(novo);
            descritor.setFim(novo);
        } else {
            descritor.getFim().setProx(novo);
            novo.setAnt(descritor.getFim());
            descritor.setFim(descritor.getFim().getProx());
        }
        this.incrementa(aluno);

        return true;
    }

    public boolean inserePosicao(Aluno aluno, int pos) {
        Nodo novo = new Nodo(aluno);
        Nodo atual = descritor.getInicio();
        Nodo ant = descritor.getInicio();
        boolean res = false;

        int i = 0;


        if ((pos < 0) || (pos > descritor.getTamanho())) { //Posi��o inv�lida
            return res; // Retorna false, n�o inseriu
        }

        if ((descritor.getTamanho() == 0) || (pos == 0)) { // Lista Vazia ou posi��o informada � zero
            res = this.insereInicio(aluno);
        } else {
            if (pos == descritor.getTamanho()) {
                res = this.insereFim(aluno);
            } else { //posicao v�lida
                for (i = 0; i < pos; i++) {
                    ant = atual;
                    atual = atual.getProx();
                }
                ant.setProx(novo);
                novo.setAnt(ant);

                novo.setProx(atual);
                atual.setAnt(novo);
                res = true;
            }
            this.incrementa(aluno);

        }
        return res;
    }


    public int verificaAluno(Aluno aluno) {
        int posicao = 0;
        int resp = -1;
        Nodo atual = descritor.getInicio();
        while ((resp == -1) && (atual != null)) {
            if (aluno.getNome().equals(atual.getAluno().getNome()) == true) {
                resp = posicao;
            } else {
                posicao++;
            }
            atual = atual.getProx();
        }
        return resp;
    }

    // Retorna verdadeiro ou falso se a lista est� vazia ou n�o.
    public boolean vazia() {
        return descritor.getTamanho() == 0;
    }

    // Retorna o tamanho da lista.
    public int quantidadeAlunos() {
        return descritor.getTamanho();
    }

    public Aluno obtemAluno(int pos) {
        int aux = 0;
        Aluno aluno = null;
        Nodo atual = descritor.getInicio();

        if ((pos >= 0) && (pos < descritor.getTamanho())) {
            for (int i = 0; i < pos; i++) {
                atual = atual.getProx();
            }
            aluno = atual.getAluno();
        }
        return aluno;
    }

    public boolean excluiInicio() {
        boolean res = false;
        Nodo atual = descritor.getInicio();
        Aluno alunoExcluido = atual.getAluno();

        if (descritor.getInicio() == null) { //Lista vazia - n�o pode excluir
            return res;
        } else {
            if (descritor.getTamanho() == 1) { // Lista de apenas um nodo
                descritor.setInicio(null);
                descritor.setFim(null);
                res = true;
            } else {
                descritor.setInicio(descritor.getInicio().getProx());
                descritor.getInicio().setAnt(null);
                res = true;
            }
            this.decrementa(alunoExcluido);
        }
        return res;
    }

    public boolean excluiFim() {
        boolean res = false;
        Nodo atual = descritor.getInicio();

        Aluno alunoExcluido = descritor.getFim().getAluno();

        if (descritor.getInicio() == null) { //Lista vazia - n�o pode excluir
            return res;
        } else {
            if (descritor.getTamanho() == 1) { // Lista de apenas um nodo
                descritor.setInicio(null);
                descritor.setFim(null);
                res = true;
            } else { //Lista com v�rios nodos
                descritor.setFim(descritor.getFim().getAnt());
                descritor.getFim().setProx(null);
                res = true;
            }

            this.decrementa(alunoExcluido);
        }
        return res;
    }

    public boolean excluiPosicao(int pos) {
        boolean res = false;
        Nodo atual = descritor.getInicio();
        Nodo ant = null;
        int qtdAlunos = descritor.getTamanho();

        if ((pos < 0) || (pos > qtdAlunos - 1)) { // Informada uma posi��o inv�lida
            return res; // Posi��o inv�lida
        }
        if (descritor.getInicio() == null) { // Lista Vazia - n�o pode excluir o que n�o existe
            return res;
        }

        //Lista existe
        if (pos == 0) {
            res = this.excluiInicio();
        } else {
            if (pos == qtdAlunos - 1) {
                res = this.excluiFim();
            } else {
                for (int i = 0; i < pos; i++) {
                    ant = atual;
                    atual = atual.getProx();
                }
                ant.setProx(atual.getProx());
                atual.getProx().setAnt(atual.getAnt());

                this.decrementa(atual.getAluno());

                res = true;
            }
        }
        return res;
    }

    public boolean exclui(Aluno aluno) {
        boolean res = false;
        Nodo atual = descritor.getInicio();
        Nodo ant = null;
        int qtdAlunos = descritor.getTamanho();
        int posAluno = 0;

        if (descritor.getInicio() == null) { // Lista Vazia - n�o pode excluir o que n�o existe
            return res;
        } else {
            posAluno = verificaAluno(aluno);// Verifica se o aluno existe na lista, retornando a sua posi��o na lista
            if (posAluno == -1) { // Aluno n�o est� presente na lista
                res = false;
            } else { //Aluno est� presente na lista
                res = this.excluiPosicao(posAluno);
            }
        }
        return res;
    }

    void incrementa(Aluno a){
        descritor.incrementaTamanho();
        descritor.incrementaIMC(IMCInfo.calculaImc(a.getPeso(), a.getAltura()));
    }

    void decrementa(Aluno a){
        descritor.decrementaTamanho();
        descritor.decrementaIMC(IMCInfo.calculaImc(a.getPeso(), a.getAltura()));
    }

    public String informacoesIMC() {
        return this.descritor.getInfoIMC();
    }
}