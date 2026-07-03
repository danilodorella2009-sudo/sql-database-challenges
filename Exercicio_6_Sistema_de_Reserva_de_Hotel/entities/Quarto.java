package JDBC_1_Pratica.Exercicio_6_Sistema_de_Reserva_de_Hotel.entities;

public abstract class Quarto {

    private int idQuarto;
    private int numero;
    private double valorDiaria;
    private int diasEstadia;

    public Quarto(int idQuarto, int numero, double valorDiaria, int diasEstadia) {
        this.idQuarto = idQuarto;
        this.numero = numero;
        this.valorDiaria = valorDiaria;
        this.diasEstadia = diasEstadia;
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

    public int getDiasEstadia() {
        return diasEstadia;
    }

    public double getValorTotal() {
        return valorDiaria * diasEstadia;
    }

    public abstract String getTipoQuarto();

    @Override
    public String toString() {
        return "ID: " + idQuarto
                + " | Numero: " + numero
                + " | Tipo: " + getTipoQuarto()
                + " | Diaria: R$ " + valorDiaria
                + " | Dias: " + diasEstadia
                + String.format(" | Total: R$ %.2f", getValorTotal());
    }
}