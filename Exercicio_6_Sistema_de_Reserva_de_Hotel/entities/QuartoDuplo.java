package JDBC_1_Pratica.Exercicio_6_Sistema_de_Reserva_de_Hotel.entities;

public final class QuartoDuplo extends Quarto {

    public QuartoDuplo(int idQuarto, int numero, int diasEstadia) {
        super(idQuarto, numero, 300.00, diasEstadia);
    }

    @Override
    public String getTipoQuarto() {
        return "Duplo";
    }
}