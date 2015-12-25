package modelo;

import java.util.*;

public class Agenda {
	 private List<Aluno> alunos = new ArrayList<Aluno>();
	private List<Professor> professores = new ArrayList<Professor>();


	Scanner leitor = new Scanner(System.in);

	public void listarTodos() {
		System.out.println("Lista de contatos de alunos: ");
		if (alunos.size() > 0) {
			for (Aluno aluno : alunos) {
				System.out.println("Nome: " + aluno.getNome());
				System.out.println("Telefone: " + aluno.getTelefone());
				System.out.println("Email: " + aluno.getEmail());
				System.out.println("N Matricula: " + aluno.getNumeroMatricula() + "\n");
			}
		} else
			System.out.println("Nao ha contatos na lista de alunos.");
		System.out.println("Lista de contatos de professsores:");
		if (professores.size() > 0) {
			for (Professor professor : professores) {
				System.out.println("Nome: " + professor.getNome());
				System.out.println("Telefone: " + professor.getTelefone());
				System.out.println("Email: " + professor.getEmail());
				System.out.println("Registro: " + professor.getNumeroRegistro());
				System.out.println("Quantidade Hora: " + professor.getQuantidadeHoraAula() + "\n");

			}
		} else
			System.out.println("Nao ha contatos na lista de professores.");
	}

	public void cadastrarDadosProfessor() {

		System.out.println("Nome:");
		String nome = leitor.next();
		System.out.println("Telefone:");
		String telefone = leitor.next();
		System.out.println("Email:");
		String email = leitor.next();
		System.out.println("Registro:");
		String numeroRegistro = leitor.next();
		System.out.println("Quantidade hora:");
		String quantidadeHoraAula = leitor.next();
		Professor p = new Professor(nome, email, telefone, numeroRegistro, quantidadeHoraAula);
		professores.add(p);
	}
	
	public void cadastrarDadosAluno() {
		System.out.println("Nome:");
		String nome = leitor.next();
		System.out.println("Telefone:");
		String telefone = leitor.next();
		System.out.println("Email:");
		String email = leitor.next();
		System.out.println("N Matricula");
		String numeroMatricula = leitor.next();
		Aluno a = new Aluno(nome, email, telefone, numeroMatricula);
		alunos.add(a);
	}

	public void editarDadosProfessor() {
		String opcaoMenuPesquisar = "";
		String opcaoMenuAlterar = "";
		String numeroDigitado = "";
		while (!opcaoMenuPesquisar.equals("2")) {
			opcaoMenuPesquisar = "";
			
			numeroDigitado = "";
			int cont = 0;
			if (professores.size() > 0) {
			System.out.println("1 - Inserir numero de Registro");
			System.out.println("2 - Sair");
			opcaoMenuPesquisar = leitor.next();
			if (opcaoMenuPesquisar.equals("1")) {
				
					System.out.println("Insira o numero de Registro do Professor");
					numeroDigitado = leitor.next();

					for (Professor professor : professores) {
						if (professor.getNumeroRegistro().equals(numeroDigitado)) {
							cont = 1;
							opcaoMenuAlterar = "";
							while(!opcaoMenuAlterar.equals("8")){
								String opcaoDelecao ="";
								System.out.println("1 - Alterar nome do professor.");
								System.out.println("2 - Alterar e-mail do professor.");
								System.out.println("3 - Alterar telefone do professor.");
								System.out.println("4 - Alterar registro do professor.");
								System.out.println("5 - Alterar quantidade de horas de aulas");
								System.out.println("6 - Exibir dados do professor.");
								System.out.println("7 - Deletar");
								System.out.println("8 - Sair");
								opcaoMenuAlterar = leitor.next();
								if(opcaoMenuAlterar.equals("1")){
									System.out.println("Insira um novo nome:");
									professor.setNome(leitor.next());
								}
								if(opcaoMenuAlterar.equals("2")){
									System.out.println("Insira um novo e-mail:");
									professor.setEmail(leitor.next());
								}
								if(opcaoMenuAlterar.equals("3")){
									System.out.println("Insira um novo telefone:");
									professor.setTelefone(leitor.next());
								}
								if(opcaoMenuAlterar.equals("4")){
									System.out.println("Insira um novo registro:");
									professor.setNumeroRegistro(leitor.next());
								}
								if(opcaoMenuAlterar.equals("5")){
									System.out.println("Insira uma nova quantidade de horas de aulas:");
									professor.setQuantidadeHoraAula(leitor.next());
									
								}
								if(opcaoMenuAlterar.equals("6")){
									System.out.println("Nome: "+professor.getNome());
									System.out.println("E-mail: "+professor.getEmail());
									System.out.println("Telefone: "+professor.getTelefone());
									System.out.println("Registro: "+professor.getNumeroRegistro());
									System.out.println("Quantidade de horas de aulas "+professor.getQuantidadeHoraAula());
								}
								if(opcaoMenuAlterar.equals("7")){
									System.out.println("Vc tem certeza q deseja remover o professor "+ professor.getNome()+ " do sistema?(S/N)");
									opcaoDelecao = leitor.next();
									while(!opcaoDelecao.equals("S")||opcaoDelecao.equals("N")){
										System.out.println("Digite uma opcao valida S OU N");
										opcaoDelecao =  leitor.next();
									}
									if(opcaoDelecao.equals("S")){
										professores.remove(professor);
										break;
									}
								}
							}
						}
					}
					if (cont == 0) {
						System.out.println("Nao ha nenhum professor com esse numero de registro");
					}
				} 
			}
				else {
					System.out.println("Nao ha professores registrados para se realizar uma edicao.");
					break;
				}
		}

	}

	public void editarDadosAluno() {
		String opcaoMenuPesquisar = "";
		String opcaoMenuAlterar = "";
		String numeroDigitado = "";
		while (!opcaoMenuPesquisar.equals("2")) {
			opcaoMenuPesquisar = "";
			
			numeroDigitado = "";
			int cont = 0;
			if (alunos.size() > 0) {
			System.out.println("1 - Inserir numero de Registro");
			System.out.println("2 - Sair");
			opcaoMenuPesquisar = leitor.next();
			if (opcaoMenuPesquisar.equals("1")) {
				
					System.out.println("Insira o numero de Matricula do Aluno");
					numeroDigitado = leitor.next();

					for (Aluno aluno : alunos) {
						if (aluno.getNumeroMatricula().equals(numeroDigitado)) {
							cont = 1;
							opcaoMenuAlterar = "";
							while(!opcaoMenuAlterar.equals("7")){
								System.out.println("1 - Alterar nome do aluno.");
								System.out.println("2 - Alterar e-mail do aluno.");
								System.out.println("3 - Alterar telefone do aluno.");
								System.out.println("4 - Alterar registro do aluno.");
								System.out.println("5 - Exibir dados do aluno.");
								System.out.println("6 - Deletar");
								System.out.println("7 - Sair");
								opcaoMenuAlterar = leitor.next();
								if(opcaoMenuAlterar.equals("1")){
									System.out.println("Insira um novo nome:");
									aluno.setNome(leitor.next());
								}
								if(opcaoMenuAlterar.equals("2")){
									System.out.println("Insira um novo e-mail:");
									aluno.setEmail(leitor.next());
								}
								if(opcaoMenuAlterar.equals("3")){
									System.out.println("Insira um novo telefone:");
									aluno.setTelefone(leitor.next());
								}
								if(opcaoMenuAlterar.equals("4")){
									System.out.println("Insira um novo registro:");
									aluno.setNumeroMatricula(leitor.next());
								}
								if(opcaoMenuAlterar.equals("5")){
									System.out.println("Nome: "+aluno.getNome());
									System.out.println("E-mail: "+aluno.getEmail());
									System.out.println("Telefone: "+aluno.getTelefone());
									System.out.println("Registro: "+aluno.getNumeroMatricula());				
								}
								if(opcaoMenuAlterar.equals("6")){
									String opcaoDelecao = "";
									System.out.println("Vc tem certeza q deseja remover o aluno "+ aluno.getNome()+ " do sistema?(S/N)");
									opcaoDelecao = leitor.next();
									while(!opcaoDelecao.equals("S")||opcaoDelecao.equals("N")){
										System.out.println("Digite uma opcao valida S OU N");
										opcaoDelecao =  leitor.next();
									}
									if(opcaoDelecao.equals("S")){
										alunos.remove(aluno);
										break;
									}
								}
							}
						}
					}
					if (cont == 0) {
						System.out.println("Nao ha nenhum aluno com esse numero de matricula");
					}
				} 
			}
				else {
					System.out.println("Nao ha alunos registrados para se realizar uma edicao.");
					break;
				}
		}

	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

}
