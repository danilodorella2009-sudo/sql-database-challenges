package JDBC_1_Pratica.Exercicio_6_Sistema_de_Reserva_de_Hotel.Repository;

import JDBC_1_Pratica.Exercicio_6_Sistema_de_Reserva_de_Hotel.ClassConection.ClassConection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuartosRepository {

    public void cadastrar(int numero, String tipo, double valorDiaria, int dias) throws SQLException {
        String sql = "INSERT INTO Quartos (numero, ValorDiaria, tipoQuartos, diasEstadia) "
                + "VALUES ('" + numero + "', '" + valorDiaria + "', '" + tipo + "', '" + dias + "')";
        try (Connection conn = ClassConection.getConnection()) {
            conn.createStatement().execute(sql);
            System.out.println("Quarto cadastrado com sucesso!");
        }
    }

    public void listar() throws SQLException {
        String sql = "SELECT *, (ValorDiaria * diasEstadia) AS totalQuarto FROM Quartos";
        try (Connection conn = ClassConection.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {
            System.out.println("=== Quartos Cadastrados ===");
            while (rs.next())
                System.out.println("ID: " + rs.getInt("idQuarto")
                        + " | Numero: " + rs.getInt("numero")
                        + " | Tipo: " + rs.getString("tipoQuartos")
                        + " | Diaria: R$ " + rs.getDouble("ValorDiaria")
                        + " | Dias: " + rs.getInt("diasEstadia")
                        + " | Total: R$ " + rs.getDouble("totalQuarto"));
        }
    }

    public double buscarValorTotal(int idQuarto) throws SQLException {
        String sql = "SELECT (ValorDiaria * diasEstadia) AS total FROM Quartos WHERE idQuarto = " + idQuarto;
        try (Connection conn = ClassConection.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {
            if (rs.next())
                return rs.getDouble("total");
            return 0;
        }
    }

    public void deletar(int idQuarto) throws SQLException {
        String sql = "DELETE FROM Quartos WHERE idQuarto = " + idQuarto;
        try (Connection conn = ClassConection.getConnection()) {
            int linhas = conn.createStatement().executeUpdate(sql);
            System.out.println(linhas > 0
                    ? "Quarto deletado com sucesso!"
                    : "Quarto nao encontrado.");
        }
    }
}