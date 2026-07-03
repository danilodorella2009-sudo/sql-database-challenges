package JDBC_1_Pratica.Exercicio_4_Sistema_de_Controle_de_Estacionamento.entities;

import JDBC_1_Pratica.Exercicio_4_Sistema_de_Controle_de_Estacionamento.Enums.TipoVeiculo;

public class Carro extends Veiculo {

    public Carro(String placa, int horaEntrada) {
        super(placa, horaEntrada, TipoVeiculo.CARRO);
    }

    @Override
    public double calcularValor(int horas) {
        return TarifaEstacionamento.calcularTarifa(horas);
    }
}