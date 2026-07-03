package JDBC_1_Pratica.Exercicio_6_Sistema_de_Reserva_de_Hotel.entities;

public final class QuartoSimples extends Quarto {

    public QuartoSimples(int idQuarto, int numero, int diasEstadia) {
        super(idQuarto, numero, 150.00, diasEstadia);
    }

    @Override
    public String getTipoQuarto() {
        return "Simples";
    }
}