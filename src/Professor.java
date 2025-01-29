
public class Professor extends Pessoa{
	private String especialidade;
	private double salario;
	private double cargaHora;
	private boolean trabalhando;
	
	public Professor (String nome, String sexo, int idade, String especialidade, double salario, double cargaHora) {
		super(nome, sexo, idade);
		this.especialidade = especialidade;
		this.salario = salario;
		this.cargaHora = cargaHora;
		this.trabalhando = true;
	}
	
	public String toString() {
		return super.toString() +
				"Especialidade: " + especialidade + "\n"
			  + "Salário: " + salario + "\n"
			  + "Carga Horária: " + cargaHora + "\n"
			  + "Trabalhando: " + trabalhando + "\n"
			  + "-------------------------" + "\n";
	}
	
	public void receberAumento(double aumento) {
		this.salario += aumento;
		System.out.println("Meu sálario agora é: " + this.salario);
	}
	
	public void folga(boolean folga) {
		if(folga) {
			this.trabalhando = folga;
			System.out.println("Estou de folga!");
		} else {
			this.trabalhando = folga;
			System.out.println("Tenho que trabalhar!");
		}
	}
	
	public String getEspecialidade() {
		return especialidade;
	}
	
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public double getCargaHora() {
		return cargaHora;
	}
	
	public void setCargaHora(double cargaHora) {
		this.cargaHora = cargaHora;
	}
	
	public boolean getTrabalhando() {
		return trabalhando;
	}
	
	public void setTrabalhando(boolean trabalhando) {
		this.trabalhando = trabalhando;
	}
}
