package Objetos;

import Descritores.UniversidadeDescritor;
import Nodos.DisciplinaNodo;

import java.sql.PreparedStatement;

public class Universidade {

    private UniversidadeDescritor descritor;

    public Universidade(){
        descritor = new UniversidadeDescritor();
    }


    public boolean insereInicio(Disciplina dis){
        DisciplinaNodo novo = new DisciplinaNodo(dis);

        if(descritor.getInicio() == null){
            descritor.setInicio(novo);
            descritor.setFim(novo);
        }
        else{
            novo.setProx(descritor.getInicio());
            descritor.getInicio().setAnt(novo);
            descritor.setInicio(novo);
        }
        descritor.incrementaTamanho();
        return true;
    }

    public boolean insereFim(Disciplina dis){
        DisciplinaNodo novo = new DisciplinaNodo(dis);
        if(descritor.getInicio() == null){
            descritor.setInicio(novo);
            descritor.setFim(novo);
        }
        else{
            descritor.getFim().setProx(novo);
            novo.setAnt(descritor.getFim());
            descritor.setFim(descritor.getFim().getProx());
        }
        descritor.incrementaTamanho();
        return true;
    }

    public boolean inserePosicao(Disciplina dis, int pos){
        DisciplinaNodo novo = new DisciplinaNodo(dis);
        DisciplinaNodo atual = descritor.getInicio();
        DisciplinaNodo ant = descritor.getInicio();
        boolean res = false;

        int i=0;


        if((pos<0) || (pos > descritor.getTamanho())) { //Posição inválida
            return res; // Retorna false, não inseriu
        }

        if((descritor.getTamanho() == 0) || (pos == 0)){ // Lista Vazia ou posição informada é zero
            res = this.insereInicio(dis);
        }
        else{
            if(pos == descritor.getTamanho()){
                res = this.insereFim(dis);
            }
            else{ //posicao válida
                for(i=0;i<pos;i++){
                    ant = atual;
                    atual = atual.getProx();
                }
                ant.setProx(novo);
                novo.setAnt(ant);

                novo.setProx(atual);
                atual.setAnt(novo);
                res = true;
            }
            descritor.incrementaTamanho();
        }
        return res;
    }

    public int verificaDisciplina(Disciplina dis){
        int posicao = 0;
        int resp = -1;
        DisciplinaNodo atual = descritor.getInicio();
        while((resp == -1) && (atual != null)){
            if(dis.getNome().equals(atual.getDisciplina().getNome())){
                resp = posicao;
            }
            else{
                posicao++;
            }
            atual = atual.getProx();
        }
        return resp;
    }

    public Disciplina getDisciplina(int pos){
        int posicao = 0;
        DisciplinaNodo atual = descritor.getInicio();

        while( atual != null ){

            if(posicao == pos){
                return atual.getDisciplina();
            }
            else{
                posicao++;
            }
            atual = atual.getProx();
        }

        return null;
    }

    public Disciplina getDisciplina(Disciplina dis){
        int posicao = 0;
        DisciplinaNodo atual = descritor.getInicio();

        int pos = this.verificaDisciplina(dis);

        while( atual != null ){

            if(posicao == pos){
                return atual.getDisciplina();
            }
            else{
                posicao++;
            }
            atual = atual.getProx();
        }

        return null;
    }

    // Retorna verdadeiro ou falso se a lista está vazia ou não.
    public boolean vazia() {
        return descritor.getTamanho()  == 0;
    }

    // Retorna o tamanho da lista.
    public int quantidadeAlunos() {
        return descritor.getTamanho();
    }

    public boolean excluiInicio() {
        boolean res=false;
        DisciplinaNodo atual = descritor.getInicio();
        if(descritor.getInicio()==null){ //Lista vazia - não pode excluir
            return res;
        }
        else{
            if(descritor.getTamanho() == 1) { // Lista de apenas um nodo
                descritor.setInicio(null);
                descritor.setFim(null);
                res = true;
            }
            else {
                descritor.setInicio(descritor.getInicio().getProx());
                descritor.getInicio().setAnt(null);
                res = true;
            }
            descritor.decrementaTamanho();
        }
        return res;
    }

    public boolean excluiFim() {
        boolean res=false;
        DisciplinaNodo atual = descritor.getInicio();
        if(descritor.getInicio()==null){ //Lista vazia - não pode excluir
            return res;
        }
        else{
            if(descritor.getTamanho() == 1) { // Lista de apenas um nodo
                descritor.setInicio(null);
                descritor.setFim(null);
                res = true;
            }
            else { //Lista com vários nodos
                descritor.setFim(descritor.getFim().getAnt());
                descritor.getFim().setProx(null);
                res=true;
            }
            descritor.decrementaTamanho();
        }
        return res;
    }

    public boolean excluiPosicao(int pos){
        boolean res=false;
        DisciplinaNodo atual = descritor.getInicio();
        DisciplinaNodo ant = null;
        int qtdAlunos = descritor.getTamanho();

        if((pos<0) || (pos>qtdAlunos-1)){ // Informada uma posição inválida
            return res; // Posição inválida
        }
        if( descritor.getInicio() == null) { // Lista Vazia - não pode excluir o que não existe
            return res;
        }

        //Lista existe
        if(pos == 0) {
            res = this.excluiInicio();
        }
        else {
            if(pos == qtdAlunos-1) {
                res = this.excluiFim();
            }
            else {
                for(int i=0; i<pos; i++){
                    ant = atual;
                    atual = atual.getProx();
                }
                ant.setProx(atual.getProx());
                atual.getProx().setAnt(atual.getAnt());
                descritor.decrementaTamanho();
                res = true;
            }
        }
        return res;
    }

    public boolean exclui(Disciplina dis){
        boolean res=false;
        DisciplinaNodo atual = descritor.getInicio();
        DisciplinaNodo ant = null;
        int qtdAlunos = descritor.getTamanho();
        int posAluno = 0;

        if( descritor.getInicio() == null) { // Lista Vazia - não pode excluir o que não existe
            return res;
        }
        else {
            posAluno = verificaDisciplina(dis);// Verifica se o aluno existe na lista, retornando a sua posição na lista
            if( posAluno == -1){ // Aluno não está presente na lista
                res = false;
            }
            else { //Aluno está presente na lista
                res = this.excluiPosicao(posAluno);
            }
        }
        return res;
    }

    public boolean inserirAlunoEmDisciplina(Aluno al, Disciplina dis){
        int posicao = verificaDisciplina(dis);

        if (posicao >= 0){
            Disciplina disciplina = getDisciplina(posicao);

            if ( !disciplina.existe(al) ) {
                return disciplina.insereFim(al);

            }else{
                return false;
            }

        }else{ return false; }
    }

    public boolean inserirNotaAluno(Aluno al, Disciplina dis , Double nota) {
        int posicao = verificaDisciplina(dis);

        if (posicao >= 0){
            Disciplina disciplina = getDisciplina(posicao);

            if ( disciplina.existe(al) ) {
                int alunoPos = disciplina.verificaAluno(al);

                if ( alunoPos >= 0 ){
                    Aluno aluno = disciplina.obtemAluno(alunoPos);

                    return aluno.insereNota(nota);

                }else {  return false; }

            }else{
                return false;
            }

        }else{ return false; }
    }

    public String relatorioDisciplinas() {
        String retorno = " Relatório de Disciplinas: \n";

        int posicao = 0;
        DisciplinaNodo atual = descritor.getInicio();

        if ( this.vazia() ) { return " Nenhuma disciplina cadastrada! "; }

        while( atual != null ){

            retorno += " - Disciplina: " + atual.getDisciplina().getNome() + " -> " + atual.getDisciplina().quantidadeAlunos() + " alunos(as) \n";

            atual = atual.getProx();
        }

        return retorno;
    }

    public String dadosAlunosPorDisciplina(Disciplina dis) {
        Disciplina disciplina = getDisciplina(dis) ;

        if ( disciplina == null) { return "Disciplina Inexistente! "; }

        String retorno = " Relatório da Disciplina " + disciplina.getNome() + " : \n";

        if ( !disciplina.vazia() ) {
            retorno += disciplina.relatorioAlunosEMedias();

        }else { retorno += " Nenhum aluno(a) cadastrado. "; }

        return retorno;

    }

    public String dadosDisciplinaPorAluno(Aluno aluno) {
        String retorno = "";
        for (int i = 0; i < descritor.getTamanho() ; i++ ) {
            retorno += this.getDisciplina(i).dadosAluno(aluno);
        }
        if( retorno.equals("") ){
            return " Aluno Inexistente! ";
        }
        return retorno;
    }

    public boolean removeDisciplina(Disciplina disciplina) {
        int posicao = this.verificaDisciplina(disciplina);

        if ( posicao >= 0 ){
            if (getDisciplina(posicao).vazia()) {
                return this.excluiPosicao(posicao);
            }else{
                return false;
            }
        }
        return false;
    }

    public boolean removerAlunoDaDisciplina(Aluno al, Disciplina dis) {
        int posicao = this.verificaDisciplina(dis);

        if ( posicao >= 0 ){
            return getDisciplina(posicao).exclui(al);

        }else{
            return false;
        }
    }

    public boolean removerAlunoDasDisciplinas(Aluno al) {
        boolean encontrado = false;
        int posAluno = -1;

        for (int i = 0; i < descritor.getTamanho() ; i++ ) {
            posAluno = this.getDisciplina(i).verificaAluno(al);

            if ( posAluno >= 0 ) {
                encontrado = true;
                this.getDisciplina(i).excluiPosicao(posAluno);
            }
        }

        return encontrado;
    }
}
