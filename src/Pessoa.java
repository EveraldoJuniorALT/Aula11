
public abstract class Pessoa {
	private String nome;
	private	String sexo;
	private int idade;
	
	public Pessoa(String nome, String sexo, int idade) {
		this.nome = nome;
		this.sexo = sexo;
		this.idade = idade;
	}
	
	@Override
	public String toString() {
		return "-------------------------" + "\n"
			 + "Nome: " + nome + "\n"
			 + "Sexo: " + sexo + "\n"
			 + "Idade: " + idade + "\n"; 
	}
	
	final public void fazerAniversario() {
		if (this.idade >= 15) {
			this.idade ++;
			System.out.println("Agora eu tenho " + idade + " anos.");
		} else {
			System.out.println("Inválido");
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
}
