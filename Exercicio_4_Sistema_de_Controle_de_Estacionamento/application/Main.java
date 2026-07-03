package JDBC_1_Pratica.Exercicio_4_Sistema_de_Controle_de_Estacionamento.application;

import JDBC_1_Pratica.Exercicio_4_Sistema_de_Controle_de_Estacionamento.Repository.EstacionamentoRepository;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EstacionamentoRepository repo = new EstacionamentoRepository();
        boolean continuar = true;

        try {
            while (continuar) {

                System.out.println(" SISTEMA DE CONTROLE DE ESTACIONAMENTO ");
                System.out.println("1 - Entrada de veiculo");
                System.out.println("2 - Saida de veiculo");
                System.out.println("3 - Listar patio");
                System.out.println("4 - Atualizar tipo");
                System.out.println("5 - Ver historico");
                System.out.println("0 - Sair");
                System.out.print("Escolha: ");

                int opcao = Integer.parseInt(sc.nextLine());

                switch (opcao) {
                    case 1 -> { System.out.println(" Entrada de Veiculo "); repo.entradaVeiculo(sc); }
                    case 2 -> { System.out.println(" Saida de Veiculo "); repo.saidaVeiculo(sc); }
                    case 3 -> { System.out.println(" Patio "); repo.listarVeiculos(); }
                    case 4 -> { System.out.println(" Atualizar Tipo "); repo.atualizarTipoVeiculo(sc); }
                    case 5 -> { System.out.println(" Historico "); repo.listarHistorico(); }
                    case 0 -> { System.out.println("Sistema encerrado. Ate logo!"); continuar = false; }
                    default -> System.out.println("Opcao invalida. Tente novamente.");
                }
            }

        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Digite apenas numeros no menu.");
        } finally {
            sc.close();
        }
    }
}