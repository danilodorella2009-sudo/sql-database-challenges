package JDBC_1_Pratica.Exercicio_2_Sistema_de_Compra_Online.entities;

public final class PagamentoDinheiro extends Pagamento {

    public PagamentoDinheiro(double valor) {
        super(valor);
    }

    @Override
    public void processarPagamento() {
        System.out.println("Pagamento em DINHEIRO no valor de: R$ " + String.format("%.2f", valor));
    }
}