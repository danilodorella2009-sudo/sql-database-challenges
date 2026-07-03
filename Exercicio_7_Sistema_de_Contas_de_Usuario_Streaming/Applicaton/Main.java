package JDBC_1_Pratica.Exercicio_7_Sistema_de_Contas_de_Usuario_Streaming.Applicaton;

import JDBC_1_Pratica.Exercicio_7_Sistema_de_Contas_de_Usuario_Streaming.Entities.ContaStreaming;
import JDBC_1_Pratica.Exercicio_7_Sistema_de_Contas_de_Usuario_Streaming.Entities.PlanoPadrao;
import JDBC_1_Pratica.Exercicio_7_Sistema_de_Contas_de_Usuario_Streaming.Entities.PlanoPremium;
import JDBC_1_Pratica.Exercicio_7_Sistema_de_Contas_de_Usuario_Streaming.Repository.UsuarioRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UsuarioRepository repo = new UsuarioRepository();
        boolean continuar = true;

        try {
            while (continuar) {

                System.out.println(" SISTEMA DE STREAMING ");
                System.out.println("1 - Cadastrar usuário");
                System.out.println("2 - Buscar usuário");
                System.out.println("3 - Listar usuários");
                System.out.println("4 - Atualizar nome");
                System.out.println("5 - Deletar usuário");
                System.out.println("0 - Sair");
                System.out.print("Escolha: ");

                int opcao = Integer.parseInt(sc.nextLine());

                if (opcao == 1) {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("E-mail: ");
                    String email = sc.nextLine();

                    System.out.println("Plano: 1- Padrão  2- Premium");
                    int plano = Integer.parseInt(sc.nextLine());

                    ContaStreaming conta;
                    if (plano == 1) {
                        conta = new PlanoPadrao(nome, email);
                    } else if (plano == 2) {
                        conta = new PlanoPremium(nome, email);
                    } else {
                        System.out.println("Plano inválido.");
                        continue;
                    }

                    System.out.println(conta);
                    repo.salvar(conta);

                } else if (opcao == 2) {
                    System.out.print("E-mail: ");
                    String email = sc.nextLine();
                    repo.buscarPorEmail(email);

                } else if (opcao == 3) {
                    repo.listar();

                } else if (opcao == 4) {
                    repo.listar();
                    System.out.print("E-mail do usuário: ");
                    String email = sc.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();
                    repo.atualizar(email, novoNome);

                } else if (opcao == 5) {
                    repo.listar();
                    System.out.print("E-mail do usuário: ");
                    String email = sc.nextLine();
                    System.out.print("Confirmar exclusão? (s/n): ");
                    String confirmar = sc.nextLine();
                    if (confirmar.equalsIgnoreCase("s"))
                        repo.deletar(email);
                    else
                        System.out.println("Operação cancelada.");

                } else if (opcao == 0) {
                    System.out.println("Encerrando sistema...");
                    continuar = false;

                } else {
                    System.out.println("Opção inválida.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro no banco de dados: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Digite apenas números.");
        }

        sc.close();
    }
}