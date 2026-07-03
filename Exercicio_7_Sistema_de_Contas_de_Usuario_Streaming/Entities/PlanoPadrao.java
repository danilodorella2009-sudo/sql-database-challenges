package JDBC_1_Pratica.Exercicio_7_Sistema_de_Contas_de_Usuario_Streaming.Entities;

import JDBC_1_Pratica.Exercicio_7_Sistema_de_Contas_de_Usuario_Streaming.Enums.TipoPlano;

public final class PlanoPadrao extends ContaStreaming {

    private String qualidadeVideo = "Full HD";
    private int limiteTelas = 2;

    public PlanoPadrao(String nome, String email) {
        super(nome, email, 30.00, TipoPlano.PADRAO);
    }

    public String getQualidadeVideo() { return qualidadeVideo; }
    public int getLimiteTelas() { return limiteTelas; }

    @Override
    public String toString() {
        return super.toString()
                + " | Qualidade: " + qualidadeVideo
                + " | Telas: " + limiteTelas
                + String.format(" | Valor: R$ %.2f", getPrecoBase());
    }
}