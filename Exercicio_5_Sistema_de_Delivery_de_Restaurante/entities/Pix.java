package JDBC_1_Pratica.Exercicio_5_Sistema_de_Delivery_de_Restaurante.entities;

import JDBC_1_Pratica.Exercicio_5_Sistema_de_Delivery_de_Restaurante.Enums.TipoPagamento;

public final class Pix extends Pagamento {
    public Pix() {
        super(TipoPagamento.PIX);
    }

    @Override
    public void processar() {
        System.out.println("Gerando chave Pix...");
    }
}