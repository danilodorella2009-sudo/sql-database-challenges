package JDBC_1_Pratica.Exercicio_2_Sistema_de_Compra_Online.entities;

public abstract class Pagamento {

    protected double valor;

    public Pagamento(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public abstract void processarPagamento();
}