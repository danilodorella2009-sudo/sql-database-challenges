package JDBC_1_Pratica.Exercicio_2_Sistema_de_Compra_Online.entities;

public final class PagamentoCartao extends Pagamento {

    public PagamentoCartao(double valor) {
        super(valor);
    }

    @Override
    public void processarPagamento() {
        System.out.println("Pagamento no cartão no valor de: R$ " + String.format("%.2f", valor));
    }
}