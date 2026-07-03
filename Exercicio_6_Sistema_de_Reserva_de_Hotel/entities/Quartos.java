package JDBC_1_Pratica.Exercicio_6_Sistema_de_Reserva_de_Hotel.entities;

public class Quartos {

    private int idQuarto;
    private int numero;
    private double valorDiaria;
    private String tipoQuartos;
    private int diaEstadias;

    public Quartos(int idQuarto, int numero, double valorDiaria, String tipoQuartos, int diasEstadia) {
        this.idQuarto = idQuarto;
        this.numero = numero;
        this.valorDiaria = valorDiaria;
        this.tipoQuartos = tipoQuartos;
        this.diaEstadias = diasEstadia;
    }

    public int getIdQuarto() {
        return idQuarto;
    }

    public int getNumero() {
        return numero;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public String getTipoQuartos() {
        return tipoQuartos;
    }

    public int getDiasEstadia() {
        return diaEstadias;
    }

    public double getValorTotal() {
        return valorDiaria * diaEstadias;
    }
}

