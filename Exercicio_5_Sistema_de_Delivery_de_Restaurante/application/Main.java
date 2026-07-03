package JDBC_1_Pratica.Exercicio_5_Sistema_de_Delivery_de_Restaurante.application;

import JDBC_1_Pratica.Exercicio_5_Sistema_de_Delivery_de_Restaurante.Repository.AutenticadorRepository;
import JDBC_1_Pratica.Exercicio_5_Sistema_de_Delivery_de_Restaurante.Repository.CardapioRepository;
import JDBC_1_Pratica.Exercicio_5_Sistema_de_Delivery_de_Restaurante.Repository.PedidoRepository;
import JDBC_1_Pratica.Exercicio_5_Sistema_de_Delivery_de_Restaurante.entities.Cartao;
import JDBC_1_Pratica.Exercicio_5_Sistema_de_Delivery_de_Restaurante.entities.Dinheiro;
import JDBC_1_Pratica.Exercicio_5_Sistema_de_Delivery_de_Restaurante.entities.Pagamento;
import JDBC_1_Pratica.Exercicio_5_Sistema_de_Delivery_de_Restaurante.entities.Pix;
import JDBC_1_Pratica.Exercicio_5_Sistema_de_Delivery_de_Restaurante.entities.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AutenticadorRepository autenticador = new AutenticadorRepository();
        CardapioRepository cardapio = new CardapioRepository();
        PedidoRepository pedidoRepo = new PedidoRepository();

        try {
            System.out.println("Sistema de Delivery");
            System.out.println("1 - Login");
            System.out.println("2 - Cadastrar novo usuário");
            System.out.print("Escolha: ");
            int opcaoInicial = Integer.parseInt(sc.nextLine());

            if (opcaoInicial == 2) {
                System.out.print("E-mail: ");
                String novoLogin = sc.nextLine();
                System.out.print("Senha: ");
                String novaSenha = sc.nextLine();
                autenticador.cadastrar(novoLogin, novaSenha);
                return;
            }

            System.out.print("E-mail: ");
            String email = sc.nextLine();
            System.out.print("Senha: ");
            String senha = sc.nextLine();

            if (!autenticador.autenticar(email, senha)) {
                System.out.println("E-mail ou senha inválidos.");
                return;
            }

            System.out.println("Login realizado com sucesso!");

            boolean continuar = true;
            while (continuar) {

                System.out.println(" MENU ");
                System.out.println("1 - Fazer pedido");
                System.out.println("2 - Ver meus pedidos");
                System.out.println("3 - Cancelar pedido");
                System.out.println("4 - Atualizar senha");
                System.out.println("5 - Cancelar meu cadastro");
                System.out.println("0 - Sair");

                System.out.print("Escolha: ");

                int menu = Integer.parseInt(sc.nextLine());

                if (menu == 1) {
                    List<Produto> produtos = cardapio.listarProdutos();
                    List<Produto> carrinho = new ArrayList<>();
                    int opcao;

                    do {
                        System.out.println("Cardápio:");
                        for (Produto p : produtos)
                            System.out.println(p.getCodigo() + " - " + p.getNome()
                                    + "  R$ " + String.format("%.2f", p.getPreco()));
                        System.out.println("0 - Finalizar pedido");
                        System.out.print("Escolha um produto: ");
                        opcao = Integer.parseInt(sc.nextLine());

                        for (Produto p : produtos) {
                            if (p.getCodigo() == opcao) {
                                carrinho.add(p);
                                System.out.println(p.getNome() + " adicionado ao carrinho!");
                            }
                        }
                    } while (opcao != 0);

                    if (carrinho.isEmpty()) {
                        System.out.println("Carrinho vazio.");
                        continue;
                    }

                    System.out.println("Forma de pagamento:");
                    System.out.println("1 - Pix");
                    System.out.println("2 - Dinheiro");
                    System.out.println("3 - Cartão");
                    System.out.print("Escolha: ");
                    int forma = Integer.parseInt(sc.nextLine());

                    Pagamento pagamento;
                    if (forma == 2) pagamento = new Dinheiro();
                    else if (forma == 3) pagamento = new Cartao();
                    else pagamento = new Pix();

                    double total = carrinho.stream().mapToDouble(Produto::getPreco).sum();
                    double taxaEntrega = total < 50 ? 8.0 : 0.0;
                    int numeroPedido = (int) (Math.random() * 10000);

                    pagamento.processar();
                    System.out.println("Produtos do pedido:");
                    carrinho.forEach(p -> System.out.println("- " + p.getNome()));
                    System.out.println("Taxa de entrega: R$ " + String.format("%.2f", taxaEntrega));
                    System.out.println("Total: R$ " + String.format("%.2f", total + taxaEntrega));
                    System.out.println("Número do pedido: " + numeroPedido);

                    pedidoRepo.salvar(email, numeroPedido, pagamento, carrinho, taxaEntrega);

                } else if (menu == 2) {
                    pedidoRepo.listarPedidos(email);

                } else if (menu == 3) {
                    System.out.print("Número do pedido a cancelar: ");
                    int num = Integer.parseInt(sc.nextLine());
                    pedidoRepo.cancelarPedido(num);

                } else if (menu == 4) {
                    System.out.print("Nova senha: ");
                    String novaSenha = sc.nextLine();
                    autenticador.atualizarSenha(email, novaSenha);

                } else if (menu == 5) {
                    System.out.print("Digite sua senha para confirmar: ");
                    String senhaConfirm = sc.nextLine();

                    if (!senhaConfirm.equals(senha)) {
                        System.out.println("Senha incorreta. Cancelamento negado.");
                    } else {
                        autenticador.deletar(email);
                        System.out.println("Cadastro cancelado. Até logo!");
                        continuar = false;
                    }

                } else if (menu == 0) {
                    System.out.println("Saindo...");
                    continuar = false;

                } else {
                    System.out.println("Opção inválida.");
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Digite apenas números nas opções.");
        }

        sc.close();
    }
}