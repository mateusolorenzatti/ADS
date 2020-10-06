
public class Pedido{
	private int numero;
	private int tempoAtendimento;

	public Pedido() {
	}

	public Pedido(int numero, int tempoAtendimento) {
		this.numero = numero;
		this.tempoAtendimento = tempoAtendimento;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setTempoAtendimento(int tempoAtendimento) {
		this.tempoAtendimento = tempoAtendimento;
	}

	public int getNumero() {
		return numero;
	}

	public int getTempoAtendimento() {
		return tempoAtendimento;
	}

	@Override
	public String toString() {
		return "Pedido NR " + numero + ": tempo de atendimento de " + this.tempoAtendimento + " minutos ";
	}
}