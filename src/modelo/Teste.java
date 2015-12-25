package modelo;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Teste {
	ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	Agenda a = new Agenda();
	ArrayList<Professor> professores;

	public static void menu() {
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		Agenda a = new Agenda();
		ArrayList<Professor> professores = new ArrayList<Professor>();
		String opcao = "";
		String quem = "";
		while (!opcao.equals("3")) {
			quem = "";
			System.out.println("0 - Listar todos");
			System.out.println("1 - Adicionar contato");
			System.out.println("2 - Editar contato");
			System.out.println("3 - Sair");
			opcao = filtro();
			if (opcao.equals("0")) {
				a.listarTodos();
			}
			if (opcao.equals("1")) {
				quem = menuProfessorAluno();
				// System.out.println(quem);
				if (quem.equals("P")) {
					a.cadastrarDadosProfessor();
				}
				if (quem.equals("A")) {
					a.cadastrarDadosAluno();
				}
				quem = "";
			}
			if(opcao.equals("2")){
				quem = menuProfessorAluno();
				if (quem.equals("P")) {
					a.editarDadosProfessor();
				}
				if (quem.equals("A")) {
					a.editarDadosAluno();
				}
				quem = "";
			}

		}
	}

	public static String menuProfessorAluno() {
		String opcao = "";
		while (!opcao.equals("1") && !opcao.equals("2")) {
			System.out.println("1- Professor");
			System.out.println("2- Aluno");
			opcao = filtro();
			System.out.println(opcao);
		}
		if (opcao.equals("1"))
			return "P";
		else
			return "A";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menu();

	}

	private static String filtro() {
		Scanner leitor = new Scanner(System.in);
		String filtro;
		int numero;
		while (true) {
			filtro = leitor.next().trim();
			try {
				Integer.parseInt(filtro);
				numero = Integer.parseInt(filtro);
				while (numero > 3 || numero < 0) {
					System.out.println("Digite uma opcao do menu");
					leitor.nextInt();
				}

				break;
			} catch (NumberFormatException e) {
				System.out.println("Formato incorreto! Digite um numero inteiro:");
			}

		}
		return filtro;
	}
}
