package JDBC_1_Pratica.Exercicio_2_Sistema_de_Compra_Online.aplication;

import JDBC_1_Pratica.Exercicio_2_Sistema_de_Compra_Online.Repository.ClienteRepository;
import JDBC_1_Pratica.Exercicio_2_Sistema_de_Compra_Online.Repository.ProdutoRepository;
import JDBC_1_Pratica.Exercicio_2_Sistema_de_Compra_Online.entities.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClienteRepository clienteRepo = new ClienteRepository();
        ProdutoRepository produtoRepo = new ProdutoRepository();

        try {
            System.out.println("SISTEMA DE COMPRA ONLINE");
            System.out.println("1 - Login");
            System.out.println("2 - Cadastrar");
            System.out.print("Escolha: ");
            int opcaoInicial = Integer.parseInt(sc.nextLine());

            int idCliente;

            if (opcaoInicial == 1) {
                System.out.print("CPF: ");
                String cpfLogin = sc.nextLine();
                System.out.print("Nome: ");
                String nomeLogin = sc.nextLine();

                idCliente = clienteRepo.login(cpfLogin, nomeLogin);

                if (idCliente == -1) {
                    System.out.println("Cliente não encontrado.");
                    return;
                }
                System.out.println("Login realizado com sucesso!");

            } else {
                System.out.println(" Cadastro ");
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("CPF: ");
                String cpf = sc.nextLine();
                System.out.print("Endereço: ");
                String endereco = sc.nextLine();

                idCliente = clienteRepo.cadastrar(nome, cpf, endereco);
                System.out.println("Cadastrado com sucesso!");
            }

            int opcaoMenu;
            do {
                    System.out.println("1 - Comprar");
                    System.out.println("2 - Atualizar endereço");
                    System.out.println("3 - Deletar cliente");
                    System.out.println("4 - Buscar cliente");
                    System.out.println("0 - Sair");
                    System.out.print("Escolha: ");
                    opcaoMenu = Integer.parseInt(sc.nextLine());

                    if (opcaoMenu == 2) {
                        System.out.print("CPF do cliente: ");
                        String cpfUpdate = sc.nextLine();
                        System.out.print("Novo endereço: ");
                        String novoEndereco = sc.nextLine();
                        clienteRepo.atualizar(cpfUpdate, novoEndereco);

                    } else if (opcaoMenu == 3) {
                        System.out.print("CPF do cliente: ");
                        String cpfDelete = sc.nextLine();
                        clienteRepo.deletar(cpfDelete);

                    } else if (opcaoMenu == 4) {
                        System.out.print("CPF do cliente: ");
                        String cpfBusca = sc.nextLine();
                        clienteRepo.buscar(cpfBusca);

                    } else if (opcaoMenu == 0) {
                        System.out.println("Encerrando sistema...");
                        return;
                    }

                } while (opcaoMenu != 1);

            Carrinho carrinho = new Carrinho();
            String continuar;

            do {
                produtoRepo.listar();
                System.out.print("ID do produto: ");
                int idProduto = Integer.parseInt(sc.nextLine());

                Produto produto = produtoRepo.buscarPorId(idProduto);
                if (produto != null) {
                    carrinho.adicionarProduto(produto);
                    System.out.println("Adicionado: " + produto.getNomeProduto());
                } else {
                    System.out.println("Produto não encontrado.");
                }

                System.out.print("Adicionar mais produto? (S/N): ");
                continuar = sc.nextLine();

            } while (continuar.equalsIgnoreCase("S"));

            System.out.println(" Resumo da Compra ");
            for (Produto p : carrinho.getProdutos())
                System.out.println("- " + p.getNomeProduto()
                        + " | R$ " + String.format("%.2f", p.getPrecoProduto()));
            System.out.println("Total: R$ " + String.format("%.2f", carrinho.calcularTotal()));

            System.out.println("Forma de pagamento: ");
            System.out.println("1 - Cartão");
            System.out.println("2 - PIX");
            System.out.println("3 - Boleto");
            System.out.println("4 - Dinheiro");
            System.out.print("Escolha: ");
            int opcao = Integer.parseInt(sc.nextLine());

            Pagamento pagamento;
            if (opcao == 1) pagamento = new PagamentoCartao(carrinho.calcularTotal());
            else if (opcao == 2) pagamento = new PagamentoPix(carrinho.calcularTotal());
            else if (opcao == 3) pagamento = new PagamentoBoleto(carrinho.calcularTotal());
            else if (opcao == 4) pagamento = new PagamentoDinheiro(carrinho.calcularTotal());
            else { System.out.println("Opção inválida."); return; }

            pagamento.processarPagamento();

            String formaPagamento = pagamento.getClass().getSimpleName()
                    .replace("Pagamento", "").toUpperCase();

            clienteRepo.salvarCompra(idCliente, carrinho.calcularTotal(), formaPagamento);

        } catch (SQLException e) {
            System.out.println("Erro no banco: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Digite apenas números.");
        } catch (Exception e) {
            System.out.println("Dados já existentes ou entrada inválida.");
        } finally {
            sc.close();
        }
    }
}