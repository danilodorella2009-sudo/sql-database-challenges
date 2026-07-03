package JDBC_1_Pratica.Exercicio_4_Sistema_de_Controle_de_Estacionamento.entities;

import JDBC_1_Pratica.Exercicio_4_Sistema_de_Controle_de_Estacionamento.Enums.TipoVeiculo;

public class Moto extends Veiculo {

    public Moto(String placa, int horaEntrada) {

        super(placa, horaEntrada, TipoVeiculo.MOTO);
    }

    @Override
    public double calcularValor(int horas) {

        return TarifaEstacionamento.calcularTarifa(horas) * 0.8;
    }
}