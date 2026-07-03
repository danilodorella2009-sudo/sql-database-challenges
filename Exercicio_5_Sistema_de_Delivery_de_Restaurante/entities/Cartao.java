package JDBC_1_Pratica.Exercicio_5_Sistema_de_Delivery_de_Restaurante.entities;

import JDBC_1_Pratica.Exercicio_5_Sistema_de_Delivery_de_Restaurante.Enums.TipoPagamento;

public final class Cartao extends Pagamento {
    public Cartao() {
        super(TipoPagamento.CARTAO);
    }

    @Override
    public void processar() {
        System.out.println("Conectando com a maquininha de cartão...");
    }
}