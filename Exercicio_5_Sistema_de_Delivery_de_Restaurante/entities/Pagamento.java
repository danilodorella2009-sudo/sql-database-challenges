package JDBC_1_Pratica.Exercicio_5_Sistema_de_Delivery_de_Restaurante.entities;

import JDBC_1_Pratica.Exercicio_5_Sistema_de_Delivery_de_Restaurante.Enums.TipoPagamento;

public abstract class Pagamento {
    private TipoPagamento tipo;

    public Pagamento(TipoPagamento tipo) {
        this.tipo = tipo;
    }

    public TipoPagamento getTipo() {
        return tipo;
    }

    public abstract void processar();

    @Override
    public String toString() {
        return tipo.name();
    }
}