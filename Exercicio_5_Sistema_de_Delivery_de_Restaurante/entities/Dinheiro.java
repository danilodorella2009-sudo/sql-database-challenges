package JDBC_1_Pratica.Exercicio_5_Sistema_de_Delivery_de_Restaurante.entities;

import JDBC_1_Pratica.Exercicio_5_Sistema_de_Delivery_de_Restaurante.Enums.TipoPagamento;

public final class Dinheiro extends Pagamento {
    public Dinheiro() {
        super(TipoPagamento.DINHEIRO);
    }

    @Override
    public void processar() {
        System.out.println("Separe o valor em dinheiro. O entregador levará troco se necessário.");
    }
}