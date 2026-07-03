package JDBC_1_Pratica.Exercicio_4_Sistema_de_Controle_de_Estacionamento.entities;

public final class TarifaEstacionamento {

    private TarifaEstacionamento() {
    }

    public static double calcularTarifa(int horas) {
        if (horas <= 1) return 10.0;
        return 10.0 + (horas - 1) * 5.0;
    }
}