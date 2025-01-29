import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Informacao {
	public void opcoesInfo() {
		try (Scanner scanner = new Scanner(System.in)) {
			int resp = 0;

			while (true) {
				boolean entradaValida = false;

				do {
					System.out.println("Escolha uma opção abaixo:");
					System.out.println("1. Adicionar Informação");
					System.out.println("2. Consultar Informação");
					System.out.println("3. Sair");
					if (scanner.hasNextInt()) { // Verifica se a entrada é um número inteiro.
						resp = scanner.nextInt();
						scanner.nextLine(); // Consome a próxima linha deixada pelo enter.
						entradaValida = true; // Recebe o valor 'true' para sair do loop.
					} else {
						System.out.println("Entrada inválida. Por favor, digite apenas números!");
						scanner.nextLine(); // Consome a entrada inválida.
					}
				} while (!entradaValida);

				if (resp == 3) {
					System.out.println("Encerrando...");
					break;
				}

				switch (resp) {
				case 1:
					adicionarInfo(scanner);
					break;

				case 2:
					consultarInfo(scanner);
					break;

				default:
					System.out.println("Opção Inválida, Tenta novamente!");
					break;
				}
			}
		}
	}
	List<Professor> profs = new ArrayList<>();
	List<Visitante> Visitantes = new ArrayList<>();
	List<Aluno> alunos = new ArrayList<>();
	List<Bolsista> bolsistas = new ArrayList<>();
	List<Tecnico> tecnicos = new ArrayList<>();

	public void adicionarInfo(Scanner scanner) {
		Random random = new Random();
		int resp = 0;

		while (true) {
			boolean entradaValida = false;
			do {
				System.out.println("------------------------");
				System.out.println("1. Adicionar Aluno");
				System.out.println("2. Adicionar Bolsista");
				System.out.println("3. Adicionar Técnico");
				System.out.println("4. Adicionar Professor");
				System.out.println("5. Adicionar Visitante");
				System.out.println("6. Sair");

				if (scanner.hasNextInt()) { // Verifica se a entrada é um número inteiro.
					resp = scanner.nextInt();
					scanner.nextLine();
					entradaValida = true; // Recebe o valor 'true' para sair do loop.
				} else {
					System.out.println("Entrada inválida. Por favor, digite apenas números!");
					scanner.nextLine(); // Consome a entrada inválida.
				}
			} while (!entradaValida);

			if (resp == 6) {
				break;
			}

			switch (resp) {
			case 1:
				Aluno aluno = coletarAluno(scanner, random);
				alunos.add(aluno);
				break;

			case 2:
				Bolsista bolsa = coletarBolsista(scanner, random);
				bolsistas.add(bolsa);
				break;

			case 3:
				Tecnico tecnico = coletarTecnico(scanner, random);
				tecnicos.add(tecnico);
				break;

			case 4:
				Professor prof = coletarProfessor(scanner);
				profs.add(prof);
				break;

			case 5:
				Visitante visitante = coletarVisitante(scanner);
				Visitantes.add(visitante);
				break;

			default:
				System.out.println("Opção Inválida, Tente novamente!");
				break;
			}
		}
	}

	public Aluno coletarAluno(Scanner scanner, Random random) {
		boolean entradaValida = false; // Variável de controle do loop do-while.
		String nome;

		do {
			System.out.print("Digite o Nome: ");
			nome = scanner.nextLine().trim();

			if (nome.matches("[a-zA-ZÀ-ÿ' ]+")) {
				entradaValida = true;
			} else {
				System.out.println("Entrada Inválida. Por favor, digite apenas letras!");
			}
		} while (!entradaValida);

		String sexo;
		boolean entradaValida1 = false; // Variável de controle do do-while.

		do {
			System.out.print("Digite o Sexo: [M/F] ");
			sexo = scanner.nextLine().trim();

			if (sexo.matches("[a-zA-ZÀ-ÿ' ]+")) {
				if (sexo.equalsIgnoreCase("masculino") || sexo.equalsIgnoreCase("m")) {
					entradaValida1 = true;

				} else if (sexo.equalsIgnoreCase("feminino") || sexo.equalsIgnoreCase("f")) {
					entradaValida1 = true;

				} else {
					System.out.println("Entrada Inválida. Por favor, digite M ou F!");
				}
			} else {
				System.out.println("Entrada Inválida. Por favor, digite apenas letras!");
			}
		} while (!entradaValida1);

		boolean entradaValida2 = false; // Variável para controle do loop.
		int idade = 0; // Inicializa a variável.

		do {
			System.out.print("Digite a Idade: ");
			if (scanner.hasNextInt()) { // Verifica se a entrada é um número inteiro.
				idade = scanner.nextInt();
				scanner.nextLine();
				entradaValida2 = true;

			} else {
				System.out.println("Entrada inválida. Por favor, digite apenas números!");
				scanner.nextLine(); // Consome a entrada inválida.
			}
		} while (!entradaValida2);

		String matricula = gerarMatr(random);

		boolean entradaValida3 = false;
		String curso;

		do {
			System.out.print("Qual o Curso: ");
			curso = scanner.nextLine().trim();

			if (curso.matches("[a-zA-ZÀ-ÿ' ]+")) {
				entradaValida3 = true;
			} else {
				System.out.println("Entrada Inválida. Por favor, digite apenas letras!");
			}
		} while (!entradaValida3);

		boolean estudando = false;
		boolean entradaValida4 = false;
		String resp1;

		do {
			System.out.print("Está estudando? [S/N] ");
			resp1 = scanner.nextLine();
			if (resp1.matches("[a-zA-ZÀ-ÿ' ]+")) {
				if (resp1.equalsIgnoreCase("sim") || resp1.equalsIgnoreCase("s")) {
					estudando = true;
					entradaValida4 = true;

				} else if (resp1.equalsIgnoreCase("não") || resp1.equalsIgnoreCase("n")) {
					estudando = false;
					entradaValida4 = true;

				} else {
					System.out.println("Entrada Inválida. Por favor, digite 'S' ou 'N'!");
				}
			} else {
				System.out.println("Entrada Inválida. Por favor, digite apenas letras!");
			}
		} while (!entradaValida4);
		return new Aluno(nome, sexo, idade, matricula, curso, estudando);
	}

	public String gerarMatr(Random random) {
		StringBuilder matricula = new StringBuilder();

		for (int i = 0; i < 8; i++) {
			int numeroAle = random.nextInt(10);
			matricula.append(numeroAle);
		}
		return matricula.toString();
	}

	public Bolsista coletarBolsista(Scanner scanner, Random random) {
		boolean entradaValida = false;
		String nome;
		do {
			System.out.print("Digite o Nome: ");
			nome = scanner.nextLine().trim();
			if (nome.matches("[a-zA-ZÀ-ÿ' ]+")) {
				entradaValida = true;
			} else {
				System.out.println("Entrada Inválida. Por favor, digite apenas letras!");
			}
		} while (!entradaValida);

		String sexo;
		boolean entradaValida1 = false;

		do {
			System.out.print("Digite o Sexo: [M/F] ");
			sexo = scanner.nextLine().trim();

			if (sexo.matches("[a-zA-ZÀ-ÿ' ]+")) {
				if (sexo.equalsIgnoreCase("masculino") || sexo.equalsIgnoreCase("m")) {
					entradaValida1 = true;
				} else if (sexo.equalsIgnoreCase("feminino") || sexo.equalsIgnoreCase("f")) {
					entradaValida1 = true;
				} else {
					System.out.println("Entrada Inválida. Por favor, digite M ou F!");
				}
			} else {
				System.out.println("Entrada Inválida. Por favor, digite apenas letras!");
			}
		} while (!entradaValida1);

		boolean entradaValida2 = false; // Variável para controle do loop.
		int idade = 0; // Inicializa a variável.

		do {
			System.out.print("Digite a Idade: ");
			if (scanner.hasNextInt()) {
				idade = scanner.nextInt();
				scanner.nextLine();
				entradaValida2 = true;
			} else {
				System.out.println("Entrada inválida. Por favor, digite apenas números!");
				scanner.nextLine(); // Consome a entrada inválida.
			}

		} while (!entradaValida2);

		String matricula = gerarMatr(random);

		boolean entradaValida3 = false;
		String curso;

		do {
			System.out.print("Qual o Curso: ");
			curso = scanner.nextLine().trim();

			if (curso.matches("[a-zA-ZÀ-ÿ' ]+")) {
				entradaValida3 = true;
			} else {
				System.out.println("Entrada Inválida. Por favor, digite apenas letras!");
			}
		} while (!entradaValida3);

		boolean estudando = false;
		boolean entradaValida4 = false;
		String resp1;

		do {
			System.out.print("Está estudando? [S/N] ");
			resp1 = scanner.nextLine();

			if (resp1.matches("[a-zA-ZÀ-ÿ' ]+")) {
				if (resp1.equalsIgnoreCase("sim") || resp1.equalsIgnoreCase("s")) {
					estudando = true;
					entradaValida4 = true;
				} else if (resp1.equalsIgnoreCase("não") || resp1.equalsIgnoreCase("n")) {
					estudando = false;
					entradaValida4 = true;
				} else {
					System.out.println("Entrada Inválida. Por favor, digite 'S' ou 'N'");
				}
			} else {
				System.out.println("Entrada Inválida. por favor, digite apenas letras!");
			}
		} while (!entradaValida4);

		boolean entradaValida5 = false;
		double bolsa = 0;

		do {
			System.out.print("Quantos porcento é a bolsa? ");
			if (scanner.hasNextDouble()) {
				bolsa = scanner.nextDouble();
				scanner.nextLine();
				entradaValida5 = true;
				;
			} else {
				System.out.println("Entrada Inválida. Por favor, digite apenas números.");
				scanner.nextLine();
			}

		} while (!entradaValida5);

		return new Bolsista(nome, sexo, idade, matricula, curso, estudando, bolsa);
	}

	public Tecnico coletarTecnico(Scanner scanner, Random random) {
		boolean entradaValida = false; // Variável de controle do loop do-while.
		String nome;

		do {
			System.out.print("Digite o Nome: ");
			nome = scanner.nextLine().trim();

			if (nome.matches("[a-zA-ZÀ-ÿ' ]+")) {
				entradaValida = true;
			} else {
				System.out.println("Entrada Inválida. Por favor, digite apenas letras!");
			}
		} while (!entradaValida);

		String sexo;
		boolean entradaValida1 = false; // Variável de controle do do-while.

		do {
			System.out.print("Digite o Sexo: [M/F] ");
			sexo = scanner.nextLine().trim();

			if (sexo.matches("[a-zA-ZÀ-ÿ' ]+")) {
				if (sexo.equalsIgnoreCase("masculino") || sexo.equalsIgnoreCase("m")) {
					entradaValida1 = true;

				} else if (sexo.equalsIgnoreCase("feminino") || sexo.equalsIgnoreCase("f")) {
					entradaValida1 = true;

				} else {
					System.out.println("Entrada Inválida. Por favor, digite M ou F!");
				}
			} else {
				System.out.println("Entrada Inválida. Por favor, digite apenas letras!");
			}
		} while (!entradaValida1);

		boolean entradaValida2 = false; // Variável para controle do loop.
		int idade = 0; // Inicializa a variável.

		do {
			System.out.print("Digite a Idade: ");
			if (scanner.hasNextInt()) { // Verifica se a entrada é um número inteiro.
				idade = scanner.nextInt();
				scanner.nextLine();
				entradaValida2 = true;

			} else {
				System.out.println("Entrada inválida. Por favor, digite apenas números!");
				scanner.nextLine(); // Consome a entrada inválida.
			}
		} while (!entradaValida2);

		String matricula = gerarMatr(random);

		boolean entradaValida3 = false;
		String curso;

		do {
			System.out.print("Qual o Curso: ");
			curso = scanner.nextLine();

			if (curso.matches("[a-zA-ZÀ-ÿ' ]+")) {
				entradaValida3 = true;
			} else {
				System.out.println("Entrada Inválida. Por favor, digite apenas letras!");
			}
		} while (!entradaValida3);

		boolean entradaValida4 = false;
		boolean estudando = false;
		String resp1;

		do {
			System.out.print("Está estudando? [S/N] ");
			resp1 = scanner.nextLine();

			if (resp1.matches("[a-zA-ZÀ-ÿ' ]+")) {
				if (resp1.equalsIgnoreCase("sim") || resp1.equalsIgnoreCase("s")) {
					estudando = true;
					entradaValida4 = true;
				} else if (resp1.equalsIgnoreCase("não") || resp1.equalsIgnoreCase("n")) {
					estudando = false;
					entradaValida4 = true;
				} else {
					System.out.println("Entrada Inválida. Por favor, digite S ou N!");
				}
			} else {
				System.out.println("Entrada Inválida. Por favor, digite apenas letras!");
			}
		} while (!entradaValida4);

		String registroPro = gerarRegistro(random);

		return new Tecnico(nome, sexo, idade, matricula, curso, estudando, registroPro);
	}

	public String gerarRegistro(Random random) {
		StringBuilder registro = new StringBuilder();

		for (int i = 0; i < 5; i++) {
			int numAle = random.nextInt(10);
			registro.append(numAle);

		}
		return registro.toString();
	}

	public Professor coletarProfessor(Scanner scanner) {
		boolean entradaValida = false;
		String nome;

		do {
			System.out.print("Digite o Nome: ");
			nome = scanner.nextLine().trim();

			if (nome.matches("[a-zA-ZÀ-ÿ' ]+")) {
				entradaValida = true;
			} else {
				System.out.println("Entrada Inválida. Por favor, digite apenas letras!");
			}
		} while (!entradaValida);

		String sexo;
		boolean entradaValida2 = false;
		do {
			System.out.print("Digite o Sexo: [M/F] ");
			sexo = scanner.nextLine().trim();

			if (sexo.matches("[a-zA-ZÀ-ÿ' ]+")) {
				if (sexo.equalsIgnoreCase("masculino") || sexo.equalsIgnoreCase("m")) {
					entradaValida2 = true;
				} else if (sexo.equalsIgnoreCase("feminino") || sexo.equalsIgnoreCase("f")) {
					entradaValida2 = true;
				} else {
					System.out.println("Entrada Inválida. Por favor, responda com M ou F!");
				}
			} else {
				System.out.println("Entrada Inválida. Por favor, digite apenas letras!");
			}
		} while (!entradaValida2);

		boolean entradaValida3 = false;
		int idade = 0;

		do {
			System.out.print("Digite a Idade: ");
			if (scanner.hasNextInt()) {
				idade = scanner.nextInt();
				scanner.nextLine();
				entradaValida3 = true;
			} else {
				System.out.println("Entrada Inválida. Por favor, digite apenas números!");
				scanner.nextLine();
			}
		} while (!entradaValida3);

		boolean entradaValida4 = false;
		String especialidade;

		do {
			System.out.print("Qual a Especialidade? ");
			especialidade = scanner.nextLine();

			if (especialidade.matches("[a-zA-ZÀ-ÿ' ]+")) {
				entradaValida4 = true;
			} else {
				System.out.println("Entrada Inválida. Por favor, digite apenas letras!");
			}
		} while (!entradaValida4);

		boolean entradaValida5 = false;
		double salario = 0;

		do {
			System.out.print("Qual é o Sálario? ");
			if (scanner.hasNextDouble()) {
				salario = scanner.nextDouble();
				scanner.nextLine();
				entradaValida5 = true;
			} else {
				System.out.println("Entrada Inválida. Por favor, digite apenas números!");
				scanner.nextLine();
			}
		} while (!entradaValida5);

		boolean entradaValida6 = false;
		double cargaHora = 0;

		do {
			System.out.print("Qual a Carga Horária? ");
			if (scanner.hasNextDouble()) {
				cargaHora = scanner.nextDouble();
				scanner.nextLine();
				entradaValida6 = true;
			} else {
				System.out.println("Entrada Inválida. Por favor, digite apenas números!");
				scanner.nextLine();
			}
		} while (!entradaValida6);

		return new Professor(nome, sexo, idade, especialidade, salario, cargaHora);
	}

	public Visitante coletarVisitante(Scanner scanner) {
		boolean entradaValida = false;
		String nome;

		do {
			System.out.print("Digite o Nome: ");
			nome = scanner.nextLine().trim();

			if (nome.matches("[a-zA-ZÀ-ÿ' ]+")) {
				entradaValida = true;
			} else {
				System.out.println("Entrada Inválida. Por favor, digite apenas letras!");
			}
		} while (!entradaValida);

		String sexo;
		boolean entradaValida2 = false;
		do {
			System.out.print("Digite o Sexo: [M/F] ");
			sexo = scanner.nextLine().trim();

			if (sexo.matches("[a-zA-ZÀ-ÿ' ]+")) {
				if (sexo.equalsIgnoreCase("masculino") || sexo.equalsIgnoreCase("m")) {
					entradaValida2 = true;
				} else if (sexo.equalsIgnoreCase("feminino") || sexo.equalsIgnoreCase("f")) {
					entradaValida2 = true;
				} else {
					System.out.println("Entrada Inválida. Por favor, responda com M ou F!");
				}
			} else {
				System.out.println("Entrada Inválida. Por favor, digite apenas letras!");
			}
		} while (!entradaValida2);

		boolean entradaValida3 = false;
		int idade = 0;

		do {
			System.out.print("Digite a Idade: ");
			if (scanner.hasNextInt()) {
				idade = scanner.nextInt();
				scanner.nextLine();
				entradaValida3 = true;
			} else {
				System.out.println("Entrada Inválida. Por favor, digite apenas números!");
				scanner.nextLine();
			}
		} while (!entradaValida3);

		return new Visitante(nome, sexo, idade);
	}

	public void consultarInfo(Scanner scanner) {
		int resp = 0;

		while (true) {
			boolean entradaValida = false;

			do {
				System.out.println("-----------------");
				System.out.println("1. Consultar Aluno");
				System.out.println("2. Consultar Bolsista");
				System.out.println("3. Consultar Técnico");
				System.out.println("4. Consultar Professor");
				System.out.println("5. Consultar Visitante");
				System.out.println("6. Sair");

				if (scanner.hasNextInt()) { // Verifica se a entrada é um número.
					resp = scanner.nextInt();
					scanner.nextLine();
					entradaValida = true; // Recebe o valor 'true' para sair do loop.
				} else {
					System.out.println("Entrada Inválida. Por favor, digite apenas números!");
					scanner.nextLine(); // Consome a entrada inválida.
				}
			} while (!entradaValida);

			if (resp == 6) {
				break;
			}

			switch (resp) {
			case 1:
				if (alunos.size() > 0) {
					consultarAluno(scanner);
				} else {
					System.out.println("Erro, Nenhum Aluno encontrado! ");
				}
				break;

			case 2:
				if (bolsistas.size() > 0) {
					consultarBolsista(scanner);
				} else {
					System.out.println("Erro, Nenhum Bolsista encontrado! ");
				}
				break;

			case 3:
				if (tecnicos.size() > 0) {
					escolherTecnico(scanner);
				} else {
					System.out.println("Erro, Nenhum Tecnico encontrado! ");
				}
				break;

			case 4:
				if (profs.size() > 0) {
					consultarProf(scanner);
				} else {
					System.out.println("Erro, Nenhum Professor encontrado! ");
				}
				break;

			case 5:
				if (Visitantes.size() > 0) {
					consultarVisitante(scanner);
				} else {
					System.out.println("Erro, Nenhum Visitante encontrado! ");
				}
				break;

			default:
				System.out.println("Opção Inválida, tente novamente!");
				break;
			}
		}
	}

	public void consultarAluno(Scanner scanner) {
		int resp = 0;

		while (true) {
			boolean entradaValida = false;

			do {
				System.out.println("----------------------");
				System.out.println("1. Mostrar Dados");
				System.out.println("2. Cancelar Matrícula");
				System.out.println("3. Pagar Mensalidade");
				System.out.println("4. Fazer Aniversário");
				System.out.println("5. Sair");

				if (scanner.hasNextInt()) { // Verifica se a entrada é um número.
					resp = scanner.nextInt();
					scanner.nextLine();
					entradaValida = true; // Recebe o valor 'true' para sair do loop.
				} else {
					System.out.println("Entrada Inválida. Por favor, digite apenas números!");
					scanner.nextLine(); // Consome a entrada inválida.
				}
			} while (!entradaValida);

			if (resp == 5) {
				break;
			}

			switch (resp) {
			case 1:
				int respNum1 = escolherAluno(scanner);
				System.out.println(alunos.get(respNum1));
				break;

			case 2:
				int respNum2 = escolherAluno(scanner);
				alunos.get(respNum2).cancerlarMatricula();
				break;

			case 3:
				int respNum3 = escolherAluno(scanner);
				alunos.get(respNum3).pagarMensalidade();
				break;

			case 4:
				int respNum4 = escolherAluno(scanner);
				alunos.get(respNum4).fazerAniversario();
				break;

			default:
				System.out.println("Opção Inválida, tente novamente!");
				break;
			}
		}
	}

	public int escolherAluno(Scanner scanner) {
		System.out.println("Quantidade de Alunos: " + alunos.size());
		boolean entradaValida = false;
		int respAluno = 0;
		do {
			System.out.println("Escolha:");

			int j = 1;
			for (int i = 0; i < alunos.size(); i++) {
				System.out.println(i + ". Para o " + j + "º Aluno");
				j++;
			}

			if (scanner.hasNextInt()) {
				respAluno = scanner.nextInt();
				scanner.nextLine();
				entradaValida = true;
			} else {
				System.out.println("Entrada Inválida. Por favor, digite apenas números!");
				scanner.nextLine();
			}
		} while (!entradaValida);
		return respAluno;
	}

	public void consultarBolsista(Scanner scanner) {
		int resp = 0;

		while (true) {
			boolean entradaValida = false;
			
			do {
				System.out.println("----------------------");
				System.out.println("1. Mostrar Dados");
				System.out.println("2. Cancelar Matrícula");
				System.out.println("3. Pagar Mensalidade");
				System.out.println("4. Renovar Bolsa");
				System.out.println("5. Fazer Aniversário");
				System.out.println("6. Sair");
				
				if(scanner.hasNextInt()) {
					resp = scanner.nextInt();
					scanner.nextLine();
					entradaValida = true;
				} else {
					System.out.println("Entrada Inválida. Por favor, digite apenas números!");
					scanner.nextLine();
				}
			} while(!entradaValida);

			if (resp == 6) {
				break;
			}

			switch (resp) {
			case 1:
				int respNum1 = escolherBolsista(scanner);
				System.out.println(bolsistas.get(respNum1));
				break;

			case 2:
				int respNum2 = escolherBolsista(scanner);
				bolsistas.get(respNum2).cancerlarMatricula();
				break;

			case 3:
				int respNum3 = escolherBolsista(scanner);
				bolsistas.get(respNum3).pagarMensalidade();
				break;

			case 4:
				int respNum4 = escolherBolsista(scanner);
				bolsistas.get(respNum4).renovarBolsa();
				break;

			case 5:
				int respNum5 = escolherBolsista(scanner);
				bolsistas.get(respNum5).fazerAniversario();
				break;

			default:
				System.out.println("Opção Inválida, tente novamente!");
				break;
			}
		}
	}

	public int escolherBolsista(Scanner scanner) {
		System.out.println("Quantidade de Bolsistas: " + bolsistas.size());
		boolean entradaValida = false;
		int respBolsa = 0;
		do {
			System.out.println("Escolha:");
			
			int j = 1;
			for (int i = 0; i < bolsistas.size(); i++) {
				System.out.println(i + ". Para o " + j + "º Bolsista");
				j++;
			}
			
			if(scanner.hasNextInt()) {
				respBolsa = scanner.nextInt();
				scanner.nextLine();
				entradaValida = true;
			} else {
				System.out.println("Entrada Inválida. Por favor, digite apenas números!");
				scanner.nextLine();
			}
			
		} while(!entradaValida);

		return respBolsa;
	}

	public void consultarTecnico(Scanner scanner) {
		int resp = 0;

		while (true) {
			boolean entradaValida = false;
			
			do {
				System.out.println("---------------------");
				System.out.println("1. Mostrar Dados");
				System.out.println("2. Cancelar Matrícula");
				System.out.println("3. Pagar Mensalidade");
				System.out.println("4. Praticar");
				System.out.println("5. Fazer Aniversário");
				System.out.println("6. Sair");
				
				if(scanner.hasNextInt()) {
					resp = scanner.nextInt();
					scanner.nextLine();
					entradaValida = true;
				} else {
					System.out.println("Entrada Inválida. Por favor, digite apenas números!");
					scanner.nextLine();
				}
			} while(!entradaValida);

			if (resp == 6) {
				break;
			}

			switch (resp) {
			case 1:
				int respNum1 = escolherTecnico(scanner);
				System.out.println(tecnicos.get(respNum1));
				break;

			case 2:
				int respNum2 = escolherTecnico(scanner);
				tecnicos.get(respNum2).cancerlarMatricula();
				break;

			case 3:
				int respNum3 = escolherTecnico(scanner);
				tecnicos.get(respNum3).pagarMensalidade();
				break;

			case 4:
				int respNum4 = escolherTecnico(scanner);
				tecnicos.get(respNum4).Praticar();
				break;

			case 5:
				int respNum5 = escolherTecnico(scanner);
				tecnicos.get(respNum5).fazerAniversario();
				break;

			default:
				System.out.println("Opção Inválida, tente novamente!");
				break;
			}
		}
	}

	public int escolherTecnico(Scanner scanner) {
		System.out.println("Quantidade de Técnicos: " + tecnicos.size());
		boolean entradaValida = false;
		int respTecnico = 0;
		do {
			System.out.println("Escolha:");
			
			int j = 1;
			for (int i = 0; i < tecnicos.size(); i++) {
				System.out.println(i + ". Para o " + j + "º Técnico");
				j++;
			}
			
			if(scanner.hasNextInt()) {
				respTecnico = scanner.nextInt();
				scanner.nextLine();
				entradaValida = true;
			} else {
				System.out.println("Entrada Inválida. Por favor, digite apenas números!");
				scanner.nextLine();
			}
		} while(!entradaValida);
		return respTecnico;
	}

	public void consultarProf(Scanner scanner) {
		int resp = 0;

		while (true) {
			boolean entradaValida = false;
			
			do {
				System.out.println("---------------------");
				System.out.println("1. Mostrar Dados");
				System.out.println("2. Dar Aumento");
				System.out.println("3. Analisar Folga");
				System.out.println("4. Fazer Aniversário");
				System.out.println("5. Sair");
				
				if(scanner.hasNextInt()) { // Verifica se a entrada é um número.
					resp = scanner.nextInt();
					scanner.nextLine();
					entradaValida = true; // Recebe o valor 'true' para sair do loop.
				} else {
					System.out.println("Entrada Inválida. Por favor, digite apenas números!");
					scanner.nextLine(); // Consome a entrada inválida.
				}
			} while(!entradaValida);

			if (resp == 5) {
				break;
			}

			switch (resp) {
			case 1:
				int respNum1 = escolherProf(scanner);
				System.out.println(profs.get(respNum1));
				break;

			case 2:
				int respNum2 = escolherProf(scanner);
				
				boolean entradaValida2 = false;
				double aumento = 0;
				do {
					System.out.print("Qual o valor do Aumento: ");
					
					if(scanner.hasNextDouble()) {
						aumento = scanner.nextDouble();
						scanner.nextLine();
						entradaValida2 = true;
					} else {
						System.out.println("Entrada Inválida. Por favor, digite apenas números!");
						scanner.nextLine();
					}
				} while(!entradaValida2);

				profs.get(respNum2).receberAumento(aumento);
				break;

			case 3:
				int respNum3 = escolherProf(scanner);
				
				boolean entradaValida3 = false;
				String respFolga;
				do {
					System.out.print("Você quer da folga para o Professor " + profs.get(respNum3).getNome() + "[S/N]? ");
					respFolga = scanner.nextLine();
					
					if(respFolga.matches("[a-zA-ZÀ-ÿ' ]+")) {
						if(respFolga.equalsIgnoreCase("sim") || respFolga.equalsIgnoreCase("s")) {
							entradaValida3 = true;
						} else if(respFolga.equalsIgnoreCase("não") || respFolga.equalsIgnoreCase("n")) {
							entradaValida3 = true;
						} else {
							System.out.println("Entrada Inválida. Por favor, digite S ou N!");
						}
					} else {
						System.out.println("Entrada Inválida. Por favor, digite apenas letras!");
					}
				} while (!entradaValida3);

				boolean folgar;
				if (respFolga.equalsIgnoreCase("sim") || respFolga.equalsIgnoreCase("s")) {
					folgar = true;
				} else {
					folgar = false;
				}

				profs.get(respNum3).folga(folgar);
				break;

			case 4:
				int respNum4 = escolherProf(scanner);
				profs.get(respNum4).fazerAniversario();
				break;

			default:
				System.out.println("Opção Inválida, tente novamente!");
				break;
			}
		}
	}

	public int escolherProf(Scanner scanner) {
		System.out.println("Quantidade de Professores: " + profs.size());
		
		boolean entradaValida = false;
		int respProf = 0;
		
		do {
			System.out.println("Escolha:");
			
			int j = 1;
			for (int i = 0; i < profs.size(); i++) {
				System.out.println(i + ". Para o " + j + "º Professor");
				j++;
			}
			
			if(scanner.hasNextInt()) {
				respProf = scanner.nextInt();
				scanner.nextLine();
				entradaValida = true;
			} else {
				System.out.println("Entrada Inválida. Por favor, digite apenas números!");
				scanner.nextLine();
			}
		} while(!entradaValida);
		return respProf;
	}

	public void consultarVisitante(Scanner scanner) {
		int resp = 0;

		while (true) {
			boolean entradaValida = false;
			
			do {
				System.out.println("---------------------");
				System.out.println("1. Mostrar Dados");
				System.out.println("2. Fazer Aniversário");
				System.out.println("3. Sair");
				
				if(scanner.hasNextInt()) {
					resp = scanner.nextInt();
					scanner.nextLine();
					entradaValida = true;
				} else {
					System.out.println("Entrada Inválida. Por favor, digite apenas números!");
					scanner.nextLine();
				}
			} while(!entradaValida);

			if (resp == 3) {
				break;
			}

			switch (resp) {
			case 1:
				int respNum1 = escolherVisitante(scanner);
				System.out.println(Visitantes.get(respNum1));
				break;

			case 2:
				int respNum2 = escolherVisitante(scanner);
				Visitantes.get(respNum2).fazerAniversario();
				break;

			default:
				System.out.println("Opção Inválida, tente novamente!");
				break;
			}
		}
	}

	public int escolherVisitante(Scanner scanner) {
		System.out.println("Quantidade de Visitantes: " + Visitantes.size());
		boolean entradaValida = false;
		int respVisitante = 0;
		
		do {
			System.out.println("Escolha:");
			
			int j = 1;
			for (int i = 0; i < Visitantes.size(); i++) {
				System.out.println(i + ". Para o " + j + "º Visitante");
				j++;
			}
			
			if(scanner.hasNextInt()) {
				respVisitante = scanner.nextInt();
				scanner.nextLine();
				entradaValida = true;
			} else {
				System.out.println("Entrada Inválida. Por favor, digite apenas números!");
				scanner.nextLine();
			}
		} while(!entradaValida);
		return respVisitante;
	}
}
