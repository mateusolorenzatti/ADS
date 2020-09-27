import java.util.Scanner;

public class Leitura{
	Scanner ler;
	
	public Leitura(){
		ler = new Scanner(System.in);
	}
	
	public int leInt(String mensagem){
		int n;
		System.out.println(mensagem);
		n = ler.nextInt();
		ler.nextLine();
		return n;
	}
	public float leFloat(String mensagem){
		float n;
		System.out.println(mensagem);
		n = ler.nextFloat();
		ler.nextLine();
		return n;
	}
	public double leDouble(String mensagem){
		double n=0;
		try{
			System.out.println(mensagem);
			n = ler.nextDouble();
			ler.nextLine();
		}
		catch(Exception ex){
			System.out.println("Valor Inválido!");
		}
		return n;
	}
	public char leChar(String mensagem){
		char c=' ';
		try{
			System.out.println(mensagem);
			c = (char) System.in.read();
			ler.nextLine();
		}
		catch(Exception ex){
			System.out.println("Valor Inválido!");
		}
		return c;
	}	
	
	
	public String leString(String mensagem){
		String s;
		System.out.println(mensagem);
		s = ler.nextLine();
		return s;
	}
}