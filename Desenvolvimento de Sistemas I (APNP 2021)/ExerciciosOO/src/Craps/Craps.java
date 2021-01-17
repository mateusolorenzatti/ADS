package Craps;

import java.util.Random;

/*

1 - Utilize  a  classe  Craps  disponibilizada  e  explique  o  que  representam  as variáveis
estáticas  e  a  enum  declaradas  (pesquise  sobre  enumerações).  Por que são privadas?

    Mesmo sem poder alterar os conteúdos, o conceito de utilizar uma palavra ou regra que
    remeta um valor faz sentido apenas para os métodos da classe do jogo. Não faria sentido,
    nessa situação, classes externas saberem que YO_LEVEN é 11, por exemplo.

2 - Explique em detalhes o que é realizado no programa principal (main).

     No começo instancia-se as variáveis e se roda os dados pela primeira vez para saber a
     soma. Após, é aplicado um switch case onde se seleciona as opções que podem ter ocorrido,
     como vencer ou perder, conforme as palavras-chave do jogo em si (imagino). Se não se
     adequar a nenhuma opção, se apresenta os pontos e segue para um laço que termina quando o
     status assumir um valor diferente de "CONTINUE" (Indicando que ainda ninguém venceu ou perdeu)
     Assim ele vai realizando as somas até saber se um dos valores conferem com a soma da iteração
     e o jogador venceu, ou se as rodadas terminaram e o jogador perdeu.
     No fim exibe o resultado.

3 - Explique  o  que  faz  o  método  estático  rollDice().  O  que  faz  o  método randomNumbers.nextInt()?

    O método simula dois dados sendo jogados e retorna a soma de ambos.
    O "dado" nese caso seria a função nextInt(6), que gera um valor aleatório até 6
    (Somando 1 pois, o 0 não faz parte do dado)

4 - Modifique  o  jogo  para  que  os  dados  sejam  viciados  e  sempre  retorne  um valor fixo de soma.



 */


public class Craps {
    private static final Random randomNumbers = new Random();

    private enum Status {CONTINUE, WON, LOST}

    ;
    private static final int SNAKE_EYES = 2;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;
    private static final int TREY = 3;

    public static void main(String[] args) {
        int myPoint = 0;

        Status gameStatus;
        int sumOfDice = rollDice();

        switch (sumOfDice) {
            case SEVEN:
            case YO_LEVEN:
                gameStatus = Status.WON;
                break;
            case SNAKE_EYES:
            case TREY:
            case BOX_CARS:
                gameStatus = Status.LOST;
                break;
            default:
                gameStatus = Status.CONTINUE;
                myPoint = sumOfDice;
                System.out.println("Pontos: " + myPoint);
        }

        while (gameStatus == Status.CONTINUE) {
            sumOfDice = rollDice();
            if (sumOfDice == myPoint) {
                gameStatus = Status.WON;
            } else {
                if (sumOfDice == SEVEN) {
                    gameStatus = Status.LOST;
                }
            }
        }

        if (gameStatus == Status.WON) {
            System.out.println("Você venceu!!");
        } else {
            System.out.println("Você perdeu..");
        }
    }

    private static int rollDice() {
        int die1 = 1 + randomNumbers.nextInt(6);
        int die2 = 1 + randomNumbers.nextInt(6);
        int sum = die1 + die2;

        System.out.println("Soma: " + sum);
        return sum;
    }
}