
public class Bolsista extends Aluno{
	private double bolsa;
	
	public Bolsista(String nome, String sexo, int idade, String matricula, String curso, boolean estudando, double bolsa) {
		super(nome, sexo, idade, matricula, curso, estudando);
		this.bolsa = bolsa;
	}
	
	public String toString() {
		return super.toString() +
				"Bolsa: " + bolsa + "\n"
		      + "-------------------------" + "\n";
	}
	
	public void renovarBolsa() {
		System.out.println("Bolsa renovada!");
	}
	
	@Override
	public void pagarMensalidade() {
		System.out.println("Você é bolsista. Mensalidade paga com desconto de: " + this.bolsa);
	}
	
	public double getBolsa() {
		return bolsa;
	}
	
	public void setBolsa(double bolsa) {
		this.bolsa = bolsa;
	}
}
