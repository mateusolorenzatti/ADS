package Exercicio3;

import Geral.Char.PilhaChar;

public class PalindromoPilha {

    public static void main(String[] args) {
        String p1 = "arara";
        String p2 = "batman";
        String p3 = "civic";
        String p4 = "honda";
        String p5 = "racecar";

        System.out.println(p1 + " é palindromo? R:" + PalindromoPilha.ePalindromo(p1.toCharArray()));
        System.out.println(p2 + " é palindromo? R:" + PalindromoPilha.ePalindromo(p2.toCharArray()));
        System.out.println(p3 + " é palindromo? R:" + PalindromoPilha.ePalindromo(p3.toCharArray()));
        System.out.println(p4 + " é palindromo? R:" + PalindromoPilha.ePalindromo(p4.toCharArray()));
        System.out.println(p5 + " é palindromo? R:" + PalindromoPilha.ePalindromo(p5.toCharArray()));

    }

    static boolean ePalindromo(char arg[]){
        int length = arg.length;
        PilhaChar temp = new PilhaChar();

        int i, mid = length / 2;

        for (i = 0; i < mid; i++){
            temp.push(arg[i]);
        }

        if (length % 2 != 0) {
            i++;
        }

        while (i < length) {
            char ele = temp.pop().getCh();

            if (ele != arg[i])  return false;

            i++;
        }

        return true;
    }
}
