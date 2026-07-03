package JDBC_1_Pratica.Exercicio_2_Sistema_de_Compra_Online.entities;

public final class PagamentoBoleto extends Pagamento {

    public PagamentoBoleto(double valor) {
        super(valor);
    }

    @Override
    public void processarPagamento() {
        System.out.println("Pagamento via BOLETO no valor de: R$ " + String.format("%.2f", valor));
    }
}