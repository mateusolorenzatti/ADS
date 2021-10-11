import java.lang.invoke.MethodHandles;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {
    public static void main(String s[]) throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry("localhost"); //verifica se existe algum serviço na máquina local
        Calculator skelton = (Calculator) reg.lookup("calculadora"); //procura pelo serviço "calculadora" (que foi definido no servidor)
        System.out.println();

        //faz as chamadas aos métodos remotos

        System.out.println("Soma de 4 e 5 é :" + skelton.add(4, 5));
        System.out.println("Subtração de 9 e 5 é :" + skelton.sub(9, 5));
        System.out.println("Multiplicação of 8 e 3 é :" + skelton.mul(8, 3));
        System.out.println("Divisão de 16 e 4 é :" + skelton.div(16, 4));
    }

}
