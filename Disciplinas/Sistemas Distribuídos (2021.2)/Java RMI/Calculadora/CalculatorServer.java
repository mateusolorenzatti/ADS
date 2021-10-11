import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;

// cria o servidor que implementa os métodos declarados no arquivo Calculator.java
public class CalculatorServer implements Calculator {

    // Metodos que fazem as somas e retornam o resultado
    public long add(long a, long b)
            throws RemoteException {
        return a + b;
    }

    public long sub(long a, long b)
            throws RemoteException {
        return a - b;
    }

    public long mul(long a, long b)
            throws RemoteException {
        return a * b;
    }

    public long div(long a, long b)
            throws RemoteException {
        return a / b;
    }

    public static void main(String[] args) throws RemoteException {
        CalculatorServer calc = new CalculatorServer();
        Calculator stub = (Calculator) UnicastRemoteObject.exportObject(calc, 0);  //cria o servidor e exporta as funcionalidades dele
        Registry reg = LocateRegistry.getRegistry(); // faz o registro de que nesta máquina possui um serviço rodando na porta padrão (1099)
        reg.rebind("calculadora", stub); // registra o serviço "calculadora" na porta acima
        System.out.println("server pronto");
    }
}
