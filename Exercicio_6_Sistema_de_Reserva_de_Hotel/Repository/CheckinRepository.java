package JDBC_1_Pratica.Exercicio_6_Sistema_de_Reserva_de_Hotel.Repository;

import JDBC_1_Pratica.Exercicio_6_Sistema_de_Reserva_de_Hotel.ClassConection.ClassConection;

import java.sql.*;

public class CheckinRepository {

    public void cadastrar(String nomeCliente, String cpf, String telefone,
                          String dataCheckin, String dataCheckout, String cidade,
                          double valorTotal, String pagamento, int idQuarto) throws SQLException {
        String sql = "INSERT INTO Chekin (nomeCliente, cpf, telefone, dataCheckin, dataCheckout, "
                + "cidade, ValorTotal, pagamento, idQuarto) VALUES ('"
                + nomeCliente + "', '" + cpf + "', '" + telefone + "', '"
                + dataCheckin + "', '" + dataCheckout + "', '" + cidade + "', '"
                + valorTotal + "', '" + pagamento + "', '" + idQuarto + "')";
        try (Connection conn = ClassConection.getConnection()) {
            conn.createStatement().execute(sql);
            System.out.println("Reserva cadastrada! Valor cobrado: R$ " + valorTotal);
        }
    }

    public void buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM Chekin WHERE idChekin = " + id;
        try (Connection conn = ClassConection.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {
            if (!rs.next()) {
                System.out.println("Reserva nao encontrada.");
            } else {
                System.out.println("=== Reserva ===");
                System.out.println("ID: " + rs.getInt("idChekin"));
                System.out.println("Nome: " + rs.getString("nomeCliente"));
                System.out.println("CPF: " + rs.getString("cpf"));
                System.out.println("Telefone: " + rs.getString("telefone"));
                System.out.println("Cidade: " + rs.getString("cidade"));
                System.out.println("Check-in: " + rs.getString("dataCheckin"));
                System.out.println("Check-out: " + rs.getString("dataCheckout"));
                System.out.println("Valor Total: R$ " + rs.getDouble("ValorTotal"));
                System.out.println("Pagamento: " + rs.getString("pagamento"));
            }
        }
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM Chekin WHERE idChekin = " + id;
        try (Connection conn = ClassConection.getConnection()) {
            int linhas = conn.createStatement().executeUpdate(sql);
            System.out.println(linhas > 0
                    ? "Reserva deletada com sucesso!"
                    : "Reserva nao encontrada.");
        }
    }
}