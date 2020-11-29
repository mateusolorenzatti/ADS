package Arvores;

import Nodos.NodoPessoaArvore;
import Objetos.Pessoa;

public class ArvorePessoas {

    private NodoPessoaArvore raiz;

    public ArvorePessoas() {
        raiz = null;
    }

    public void insNodo(Pessoa p) {
        if (raiz == null)
            raiz = new NodoPessoaArvore(p);
        else
            insere(raiz, p);
    }

    public void insere(NodoPessoaArvore raiz, Pessoa p) {
        if (raiz.getPessoa().getNome().compareTo(p.getNome()) > 0) {
            if (raiz.getEsq() == null)
                raiz.setEsq(new NodoPessoaArvore(p));
            else
                insere(raiz.getEsq(), p);
        } else {
            if (raiz.getDir() == null)
                raiz.setDir(new NodoPessoaArvore(p));
            else
                insere(raiz.getDir(), p);
        }
    }

    public boolean inserirAmizade(Pessoa p1, Pessoa p2) {
        NodoPessoaArvore p1Temp = this.pesq_arv_rec(this.raiz, p1);
        NodoPessoaArvore p2Temp = pesq_arv_rec(this.raiz, p2);

        if (p1Temp != null && p2Temp != null) {
            return p1Temp.insereAmizade(p2) && p2Temp.insereAmizade(p1);
        } else {
            return false;
        }
    }

    public void preFixado() {
        preFix(raiz);
    }

    public void preFix(NodoPessoaArvore raiz) {
        if (raiz == null)
            return;

        System.out.print(raiz.getPessoa().toString() + " ");

        preFix(raiz.getEsq());
        preFix(raiz.getDir());
    }

    public void central() {
        inFix(raiz);
    }

    public void inFix(NodoPessoaArvore raiz) {
        if (raiz == null)
            return;

        inFix(raiz.getEsq());

        System.out.print(raiz.getPessoa().toString() + " ");

        inFix(raiz.getDir());
    }

    public void posFixado() {
        posFix(raiz);
    }

    public void posFix(NodoPessoaArvore raiz) {
        if (raiz == null)
            return;

        posFix(raiz.getEsq());
        posFix(raiz.getDir());

        System.out.print(raiz.getPessoa().toString() + " ");
    }

    public boolean pesquisa(Pessoa pes) {
        //Retorna V ou F, caso o valor exista ou n�o
        boolean res = pesq_arv(raiz, pes);
        return res;
    }

    public boolean pesq_arv(NodoPessoaArvore raiz, Pessoa pes) {
        //Realiza a pesquisa por um m�todo n�o recursivo.
        boolean achou = false;
        NodoPessoaArvore aux = raiz;

        while ((achou == false) && (aux != null)) {

            if (aux.getPessoa().getNome().equals(pes.getNome())) {
                achou = true;
            } else {
                if (aux.getPessoa().getNome().compareTo(pes.getNome()) >= 0)
                    aux = aux.getEsq();
                else
                    aux = aux.getDir();
            }
        }
        return achou;
    }

    public NodoPessoaArvore pesquisa_rec(Pessoa pes) {
        //Retorna V ou F, caso o valor exista ou n�o
        NodoPessoaArvore res = pesq_arv_rec(raiz, pes);
        return res;
    }

    public NodoPessoaArvore pesq_arv_rec(NodoPessoaArvore raiz, Pessoa pes) {

        NodoPessoaArvore res = null;

        if (raiz != null) {
            if (raiz.getPessoa().getNome().equals(pes.getNome())) {
                res = raiz;
            } else {
                if (raiz.getPessoa().getNome().compareTo(pes.getNome()) >= 0)
                    res = pesq_arv_rec(raiz.getEsq(), pes);
                else
                    res = pesq_arv_rec(raiz.getDir(), pes);
            }
        }
        return res;
    }

    public String dadosIndividual(Pessoa p) {
        NodoPessoaArvore nodo = pesq_arv_rec(raiz, p);

        if (nodo != null) {
            return nodo.relatorioAmizades();
        } else {
            return " Pessoa não encontrada!";
        }
    }

    public void relatorioGeralAmizades() {
        if (this.raiz == null) {
            System.out.println(" Nenhuma pessoa cadastrada!");
        } else {
            System.out.print(" ");
            inFixRelatorio(this.raiz);
        }
    }

    public void inFixRelatorio(NodoPessoaArvore temp) {
        if (temp == null)
            return;

        inFixRelatorio(temp.getEsq());

        System.out.print(temp.relatorioAmizades() + "\n ");

        inFixRelatorio(temp.getDir());
    }

    public void inFixRemoveAmigo(NodoPessoaArvore temp, Pessoa p) {
        if (temp == null)
            return;

        inFixRemoveAmigo(temp.getEsq(), p);

        temp.removeAmizade(p);

        inFixRemoveAmigo(temp.getDir(), p);
    }

    public boolean renomearPessoa(String nomeAntigo, String nomeNovo) {
        NodoPessoaArvore nodoAntigo = pesq_arv_rec(this.raiz, new Pessoa(nomeAntigo));

        Pessoa novaPessoa = new Pessoa(nomeNovo);

        if (nodoAntigo == null) return false;

        // Insere novamente na Árvore, pois poderá afetar na ordem
        this.deleteRec(raiz, nodoAntigo.getPessoa());

        this.insNodo(novaPessoa);

        NodoPessoaArvore novoNodo = pesq_arv_rec(this.raiz, novaPessoa);
        novoNodo.setInicio(nodoAntigo.getInicio());

        // Renomeia as listas
        renameNomeListasRec(raiz, nomeAntigo, nomeNovo);

        return true;
    }

    public void renameNomeListasRec(NodoPessoaArvore temp, String nomeAntigo, String nomeNovo) {
        if (temp == null)
            return;

        temp.renomearAmizade(nomeAntigo, nomeNovo);

        renameNomeListasRec(temp.getEsq(), nomeAntigo, nomeNovo);
        renameNomeListasRec(temp.getDir(), nomeAntigo, nomeNovo);
    }

    public boolean removeSeguramente(Pessoa p) {

        if(this.pesq_arv_rec(raiz, p) != null){
            inFixRemoveAmigo(raiz, p);
            deleteRec(raiz, p);
            return true;
        }
        return false;
    }

    NodoPessoaArvore deleteRec(NodoPessoaArvore temp, Pessoa pes) {
        if (temp == null)
            return temp;

        if (pes.getNome().compareTo(temp.getPessoa().getNome()) < 0)
            temp.setEsq(deleteRec(temp.getEsq(), pes));

        else if (pes.getNome().compareTo(temp.getPessoa().getNome()) > 0)
            temp.setDir(deleteRec(temp.getDir(), pes));

        else {
            if (temp.getEsq() == null)
                return temp.getDir();
            else if (temp.getDir() == null)
                return temp.getEsq();

            temp.setPessoa(minValue(temp.getDir()));

            temp.setDir(deleteRec(temp.getDir(), temp.getPessoa()));
        }

        return temp;
    }

    Pessoa minValue(NodoPessoaArvore temp) {
        Pessoa minv = temp.getPessoa();

        while (temp.getEsq() != null) {
            minv = temp.getEsq().getPessoa();
            temp = temp.getEsq();
        }

        return minv;
    }
}
