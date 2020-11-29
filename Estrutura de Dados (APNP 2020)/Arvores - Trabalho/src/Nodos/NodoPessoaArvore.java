package Nodos;

import Objetos.Pessoa;

public class NodoPessoaArvore {
    private NodoPessoaArvore esq;
    private Pessoa pessoa;
    private NodoPessoaArvore dir;

    private NodoPessoaLista inicio;

    public NodoPessoaArvore(Pessoa p) {
        pessoa = p;
        esq = null;
        dir = null;
        inicio = null;
    }

    public NodoPessoaArvore getEsq() {
        return esq;
    }

    public void setEsq(NodoPessoaArvore e) {
        esq = e;
    }

    public NodoPessoaArvore getDir() {
        return dir;
    }

    public void setDir(NodoPessoaArvore d) {
        dir = d;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public NodoPessoaLista getInicio() {
        return inicio;
    }

    public void setInicio(NodoPessoaLista prox) {
        this.inicio = prox;
    }

    public boolean vazia() {
        return this.quantidadePessoas() == 0;
    }

    public int quantidadePessoas(){
        NodoPessoaLista atual = inicio;
        int res=0;

        while(atual != null){
            res++;
            atual = atual.getProx();
        }
        return res;
    }

    public boolean insereAmizade(Pessoa pes){
        NodoPessoaLista novo = new NodoPessoaLista(pes);
        NodoPessoaLista atual = this.inicio;

        if(inicio == null){
            inicio = novo;
        }
        else{
            while(atual.getProx() != null){
                atual = atual.getProx();
            }
            atual.setProx(novo);
        }
        return true;
    }

    public int verificaAmizade(Pessoa pes){
        int posicao = 0;
        int resp = -1;
        NodoPessoaLista atual = inicio;

        while((resp == -1) && (atual != null)){
            if(pes.getNome().equals(atual.getPessoa().getNome())){
                resp = posicao;
            }
            else{
                posicao++;
            }
            atual = atual.getProx();
        }
        return resp;
    }

    public boolean removeAmizade(Pessoa pes){
        boolean res=false;
        NodoPessoaLista atual = inicio;
        NodoPessoaLista ant = null;

        if(inicio != null){
            if(verificaAmizade(pes) == -1){
                res=false;
            }
            else{
                if(inicio.getProx() == null){
                    inicio = null;
                }
                else{
                    if(atual.getPessoa().getNome().equals(pes.getNome())){
                        res = excluiInicio();
                    }
                    else{
                        while(!(atual.getPessoa().getNome().equals(pes.getNome()))){
                            ant = atual;
                            atual = atual.getProx();
                        }
                        ant.setProx(atual.getProx());
                        res=true;
                    }
                }
            }
        }
        return res;
    }

    public boolean excluiInicio() {
        boolean res = false;
        NodoPessoaLista atual = inicio;
        if(inicio != null){
            inicio = inicio.getProx();
            atual.setProx(null);
            res=true;
        }
        return res;
    }

    public String relatorioAmizades(){
        String retorno = "Amigos de " +this.pessoa.getNome() + "\n ";
        NodoPessoaLista atual = inicio;

        if(vazia()){
            retorno += " Nenhum amigo na lista! \n";
        }else {
            while (atual != null) {
                retorno += " " + atual.getPessoa().getNome() + "\n ";
                atual = atual.getProx();
            }
        }

        return retorno;
    }

    public void renomearAmizade(String nomeAntigo, String nomeNovo) {
        NodoPessoaLista atual = inicio;

        while(atual != null){
            if(atual.getPessoa().getNome().equals(nomeAntigo)){
                atual.getPessoa().setNome(nomeNovo);
            }

            atual = atual.getProx();
        }
    }
}