package Exercicio1;

import Geral.Char.PilhaChar;

public class VerificaParentesis {

    public static void main(String[] args) {
        VerificaParentesis tst = new VerificaParentesis();

        String teste1 = "((())))";
        String teste2 = "(())()";

        System.out.println(" Teste 1: " + tst.expressaoValida(teste1) );
        System.out.println(" Teste 2: " + tst.expressaoValida(teste2) );
    }

    public boolean expressaoValida(String entrada){
        PilhaChar pilha = new PilhaChar();

        for (char st : entrada.toCharArray()) {
            if (st == '(') {
                pilha.push(st);
            }
            else {
                if(pilha.isEmpty()) { return false; }

                char top = pilha.peek().getCh();
                if(st == ')' && top == '('){
                    pilha.pop();
                }
            }
        }
        return pilha.isEmpty();
    }
}
