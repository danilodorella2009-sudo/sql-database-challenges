package JDBC_1_Pratica.Exercicio_2_Sistema_de_Compra_Online.Repository;

import JDBC_1_Pratica.Exercicio_2_Sistema_de_Compra_Online.ClassConection.ClassConection;

import java.sql.*;

public class ClienteRepository {

    public int cadastrar(String nome, String cpf, String endereco) throws SQLException {
        String sql = "INSERT INTO pessoa (nome, cpf, endereco) VALUES (?, ?, ?)";
        try (Connection conn = ClassConection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, nome);
            ps.setString(2, cpf);
            ps.setString(3, endereco);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) return rs.getInt(1);
            return -1;
        }
    }

    public int login(String cpf, String nome) throws SQLException {
        String sql = "SELECT id FROM pessoa WHERE cpf = ? AND nome = ?";
        try (Connection conn = ClassConection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cpf);
            ps.setString(2, nome);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt("id");
            return -1;
        }
    }

    public void buscar(String cpf) throws SQLException {
        String sql = "SELECT * FROM pessoa WHERE cpf = ?";
        try (Connection conn = ClassConection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("CPF: " + rs.getString("cpf"));
                System.out.println("Endereço: " + rs.getString("endereco"));
            } else {
                System.out.println("Cliente não encontrado.");
            }
        }
    }

    public void atualizar(String cpf, String novoEndereco) throws SQLException {
        String sql = "UPDATE pessoa SET endereco = ? WHERE cpf = ?";
        try (Connection conn = ClassConection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, novoEndereco);
            ps.setString(2, cpf);
            int linhas = ps.executeUpdate();
            System.out.println(linhas > 0 ? "Cliente atualizado!" : "Cliente não encontrado.");
        }
    }

    public void deletar(String cpf) throws SQLException {
        String sql = "DELETE FROM pessoa WHERE cpf = ?";
        try (Connection conn = ClassConection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cpf);
            int linhas = ps.executeUpdate();
            System.out.println(linhas > 0 ? "Cliente deletado!" : "Cliente não encontrado.");
        }
    }

    public void salvarCompra(int idCliente, double total, String formaPagamento) throws SQLException {
        String sql = "INSERT INTO compra (id_cliente, valor, frete, FormaDePagamento) VALUES (?, ?, ?, ?)";
        try (Connection conn = ClassConection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCliente);
            ps.setDouble(2, total);
            ps.setDouble(3, 10.0);
            ps.setString(4, formaPagamento);
            ps.executeUpdate();
            System.out.println("Compra salva com sucesso!");
        }
    }
}