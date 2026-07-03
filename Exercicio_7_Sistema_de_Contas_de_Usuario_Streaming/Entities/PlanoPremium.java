package JDBC_1_Pratica.Exercicio_7_Sistema_de_Contas_de_Usuario_Streaming.Entities;

import JDBC_1_Pratica.Exercicio_7_Sistema_de_Contas_de_Usuario_Streaming.Enums.TipoPlano;

public final class PlanoPremium extends ContaStreaming {

    private String qualidadeVideo = "4K Ultra HD";
    private int limiteTelas = 4;
    private boolean permiteDownload = true;

    public PlanoPremium(String nome, String email) {
        super(nome, email, 50.00, TipoPlano.PREMIUM);
    }

    public String getQualidadeVideo() { return qualidadeVideo; }
    public int getLimiteTelas() { return limiteTelas; }
    public boolean isPermiteDownload() { return permiteDownload; }

    @Override
    public String toString() {
        return super.toString()
                + " | Qualidade: " + qualidadeVideo
                + " | Telas: " + limiteTelas
                + " | Download: " + (permiteDownload ? "Sim" : "Não")
                + String.format(" | Valor: R$ %.2f", getPrecoBase());
    }
}