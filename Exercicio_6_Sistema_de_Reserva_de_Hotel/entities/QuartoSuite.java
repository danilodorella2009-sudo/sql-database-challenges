package JDBC_1_Pratica.Exercicio_6_Sistema_de_Reserva_de_Hotel.entities;

public final class QuartoSuite extends Quarto {

    public QuartoSuite(int idQuarto, int numero, int diasEstadia) {
        super(idQuarto, numero, 600.00, diasEstadia);
    }

    @Override
    public String getTipoQuarto() {
        return "Suite";
    }
}