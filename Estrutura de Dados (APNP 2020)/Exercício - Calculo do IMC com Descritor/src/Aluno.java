public class Aluno{
	private int matricula;
	private String nome;
	private int peso;
	private int altura;
	
	public Aluno() {
		this.matricula=0;
		this.nome = "";
		this.peso = 0;
		this.altura = 0;
	}

	public Aluno(int matricula, String nome, int peso, int altura) {
		super();
		this.matricula=matricula;
		this.nome = nome;
		this.peso = peso;
		this.altura = altura;
	}
	
	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome(){
		return nome;
	}
	public void setNome(String nome){
		this.nome=nome;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return "Aluno [matricula= " + matricula + ", nome=" + nome + ", peso=" + peso + ", altura=" + altura + "]";
	}
}