package JDBC_1_Pratica.Exercicio_8_Sistema_de_Passagens_Aereas.Entities;

import JDBC_1_Pratica.Exercicio_8_Sistema_de_Passagens_Aereas.Enums.TipoClasse;

public abstract class Passagem {

    private String nomePassageiro;
    private String numeroVoo;
    private double precoOriginal;
    private TipoClasse tipoClasse;

    public Passagem(String nomePassageiro, String numeroVoo, double precoOriginal, TipoClasse tipoClasse) {
        this.nomePassageiro = nomePassageiro;
        this.numeroVoo = numeroVoo;
        this.precoOriginal = precoOriginal;
        this.tipoClasse = tipoClasse;
    }

    public String getNomePassageiro() {
        return nomePassageiro;
    }

    public String getNumeroVoo() {
        return numeroVoo;
    }

    public double getPrecoOriginal() {
        return precoOriginal;
    }

    public TipoClasse getTipoClasse() {
        return tipoClasse;
    }

    public abstract double calcularPrecoFinal();

    @Override
    public String toString() {
        return "Passageiro: " + nomePassageiro
                + " | Voo: " + numeroVoo
                + " | Classe: " + tipoClasse;
    }
}