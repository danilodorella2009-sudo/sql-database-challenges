package JDBC_1_Pratica.Exercicio_1_Sistema_de_Controle_de_Biblioteca_Escolar.Application;

import JDBC_1_Pratica.Exercicio_1_Sistema_de_Controle_de_Biblioteca_Escolar.Repository.AlunoRepository;
import JDBC_1_Pratica.Exercicio_1_Sistema_de_Controle_de_Biblioteca_Escolar.Repository.LivroRepository;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AlunoRepository alunoRepo = new AlunoRepository();
        LivroRepository livroRepo = new LivroRepository();
        int opcao;

        do {
            System.out.println(" SISTEMA DE BIBLIOTECA ");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Cadastrar livro");
            System.out.println("3 - Realizar emprestimo");
            System.out.println("4 - Listar alunos");
            System.out.println("5 - Listar livros");
            System.out.println("6 - Cancelar cadastro de aluno");
            System.out.println("7 - Cancelar cadastro de livro");
            System.out.println("8 - Cancelar emprestimo");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            try {
                opcao = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas numeros.");
                sc.nextLine();
                opcao = -1;
                continue;
            }

            try {
                switch (opcao) {

                    case 1:
                        System.out.println(" Cadastrar Aluno ");
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();
                        System.out.print("Matricula: ");
                        int matricula = sc.nextInt();
                        sc.nextLine();
                        alunoRepo.cadastrar(nome, matricula);
                        break;

                    case 2:
                        System.out.println(" Cadastrar Livro ");
                        System.out.print("Titulo: ");
                        String titulo = sc.nextLine();
                        System.out.print("Codigo: ");
                        int codigo = sc.nextInt();
                        sc.nextLine();
                        livroRepo.cadastrar(titulo, codigo);
                        break;

                    case 3:
                        System.out.println(" Realizar Emprestimo ");
                        alunoRepo.listarParaEmprestimo();
                        System.out.print("Matricula do aluno: ");
                        int matEmp = sc.nextInt();
                        sc.nextLine();
                        livroRepo.listarDisponiveis();
                        System.out.print("Codigo do livro: ");
                        int codEmp = sc.nextInt();
                        sc.nextLine();
                        livroRepo.marcarEmprestado(codEmp);
                        alunoRepo.adicionarEmprestimo(matEmp);
                        System.out.println("Emprestimo realizado com sucesso!");
                        break;

                    case 4:
                        System.out.println(" Lista de Alunos ");
                        alunoRepo.listar();
                        break;

                    case 5:
                        System.out.println(" Lista de Livros ");
                        livroRepo.listar();
                        break;

                    case 6:
                        System.out.println(" Cancelar Cadastro de Aluno");
                        alunoRepo.listar();
                        System.out.print("Matricula do aluno a cancelar: ");
                        int matCancelar = sc.nextInt();
                        sc.nextLine();
                        alunoRepo.cancelar(matCancelar);
                        break;

                    case 7:
                        System.out.println(" Cancelar Cadastro de Livro ");
                        livroRepo.listar();
                        System.out.print("Codigo do livro a cancelar: ");
                        int codCancelar = sc.nextInt();
                        sc.nextLine();
                        livroRepo.cancelar(codCancelar);
                        break;

                    case 8:
                        System.out.println(" Cancelar Emprestimo ");
                        livroRepo.listarEmprestados();
                        System.out.print("Codigo do livro a devolver: ");
                        int codDev = sc.nextInt();
                        sc.nextLine();
                        alunoRepo.listarComEmprestimo();
                        System.out.print("Matricula do aluno: ");
                        int matDev = sc.nextInt();
                        sc.nextLine();
                        livroRepo.marcarDevolvido(codDev);
                        alunoRepo.removerEmprestimo(matDev);
                        break;

                    case 0:
                        System.out.println("Sistema encerrado. Ate logo!");
                        break;

                    default:
                        System.out.println("Opcao invalida. Tente novamente.");
                }

            } catch (SQLException e) {
                System.out.println("Erro no banco de dados: " + e.getMessage());
            }

        } while (opcao != 0);

        sc.close();
    }
}