package JDBC_1_Pratica.Exercicio_7_Sistema_de_Contas_de_Usuario_Streaming.Entities;

import JDBC_1_Pratica.Exercicio_7_Sistema_de_Contas_de_Usuario_Streaming.Enums.TipoPlano;

public abstract class ContaStreaming {

    private String nomeUsuario;
    private String email;
    private double precoBase;
    private TipoPlano tipoPlano;

    public ContaStreaming(String nomeUsuario, String email, double precoBase, TipoPlano tipoPlano) {
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.precoBase = precoBase;
        this.tipoPlano = tipoPlano;
    }

    public String getNomeUsuario() { return nomeUsuario; }
    public void setNomeUsuario(String nomeUsuario) { this.nomeUsuario = nomeUsuario; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public double getPrecoBase() { return precoBase; }
    public TipoPlano getTipoPlano() { return tipoPlano; }

    @Override
    public String toString() {
        return "Usuário: " + nomeUsuario
                + " | E-mail: " + email
                + " | Plano: " + tipoPlano;
    }
}