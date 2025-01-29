
public class Aluno extends Pessoa{
	private String matricula;
	private String curso;
	private boolean estudando;
	
	public Aluno(String nome, String sexo, int idade, String matricula, String curso, boolean estudando) {
		super(nome, sexo, idade);
		this.matricula = matricula;
		this.curso = curso;
		this.estudando = estudando;
		}
	
	@Override
	public String toString() {
		return super.toString() + 
				"Matrícula: " + matricula + "\n"
			  + "Curso: " + curso + "\n" 
			  + "Estudando? " + estudando + "\n"
			  + "-------------------------" + "\n";
	}
	
	public void cancerlarMatricula() {
		this.matricula = "Sem Matrícula";
	}
	
	public void pagarMensalidade() {
		System.out.println("Mensalidade de " + getNome() +  " paga!");
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getCurso() {
		return curso;
	}
	
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	public boolean getEstudando() {
		return estudando;
	}
	
	public void setEstudando(boolean estudando) {
		this.estudando = estudando;
	}
}
