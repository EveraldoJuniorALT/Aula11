
public class Tecnico extends Aluno{
	private String registroProfissional;
	
	public Tecnico(String nome, String sexo, int idade, String matricula, String curso, boolean estudando, String registroProfissional) {
		super(nome, sexo, idade, matricula, curso, estudando);
		this.registroProfissional = registroProfissional;
	}
	
	public void Praticar() {
		System.out.println("Estou Práticando...");
	}
	
	public String getRegistroProfissional() {
		return registroProfissional;
	}
	
	public void setRegistroProfissional(String registro) {
		this.registroProfissional = registro;
	}
}
