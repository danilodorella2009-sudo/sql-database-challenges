package JDBC_1_Pratica.Exercicio_2_Sistema_de_Compra_Online.Repository;

import JDBC_1_Pratica.Exercicio_2_Sistema_de_Compra_Online.ClassConection.ClassConection;
import JDBC_1_Pratica.Exercicio_2_Sistema_de_Compra_Online.entities.Produto;

import java.sql.*;

public class ProdutoRepository {

    public Produto buscarPorId(int id) throws SQLException {
        String sql = "SELECT id, nome, preco_unitario, marca FROM produtos WHERE id = ?";
        try (Connection conn = ClassConection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                return new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco_unitario"),
                        rs.getString("marca"));
            return null;
        }
    }

    public void listar() throws SQLException {
        String sql = "SELECT * FROM produtos";
        try (Connection conn = ClassConection.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {
            System.out.println(" Produtos Disponíveis ");
            while (rs.next())
                System.out.println("ID: " + rs.getInt("id")
                        + " | Nome: " + rs.getString("nome")
                        + " | Preço: R$ " + String.format("%.2f", rs.getDouble("preco_unitario"))
                        + " | Marca: " + rs.getString("marca"));
        }
    }
}