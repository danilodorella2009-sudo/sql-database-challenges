package JDBC_1_Pratica.Exercicio_7_Sistema_de_Contas_de_Usuario_Streaming.Repository;

import JDBC_1_Pratica.Exercicio_7_Sistema_de_Contas_de_Usuario_Streaming.ClassConection.ClassConection;
import JDBC_1_Pratica.Exercicio_7_Sistema_de_Contas_de_Usuario_Streaming.Entities.ContaStreaming;

import java.sql.*;

public class UsuarioRepository {

    public void salvar(ContaStreaming conta) throws SQLException {
        String sql = "INSERT INTO usuarios (nome, email, tipoPlano, valorMensal) VALUES (?, ?, ?, ?)";
        try (Connection conn = ClassConection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, conta.getNomeUsuario());
            ps.setString(2, conta.getEmail());
            ps.setString(3, conta.getTipoPlano().name());
            ps.setDouble(4, conta.getPrecoBase());
            ps.executeUpdate();
            System.out.println("Usuário cadastrado com sucesso!");
        }
    }

    public void buscarPorEmail(String email) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE email = ?";
        try (Connection conn = ClassConection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                System.out.println("Nome: " + rs.getString("nome")
                        + " | Email: " + rs.getString("email")
                        + " | Plano: " + rs.getString("tipoPlano")
                        + " | Valor: R$ " + String.format("%.2f", rs.getDouble("valorMensal")));
            else
                System.out.println("Usuário não encontrado.");
        }
    }

    public void listar() throws SQLException {
        String sql = "SELECT * FROM usuarios";
        try (Connection conn = ClassConection.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {
            System.out.println(" Usuários Cadastrados ");
            boolean tem = false;
            while (rs.next()) {
                tem = true;
                System.out.println("Nome: " + rs.getString("nome")
                        + " | Email: " + rs.getString("email")
                        + " | Plano: " + rs.getString("tipoPlano")
                        + " | Valor: R$ " + String.format("%.2f", rs.getDouble("valorMensal")));
            }
            if (!tem) System.out.println("Nenhum usuário cadastrado.");
        }
    }

    public void atualizar(String email, String novoNome) throws SQLException {
        String sql = "UPDATE usuarios SET nome = ? WHERE email = ?";
        try (Connection conn = ClassConection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, novoNome);
            ps.setString(2, email);
            int linhas = ps.executeUpdate();
            System.out.println(linhas > 0 ? "Usuário atualizado!" : "Usuário não encontrado.");
        }
    }

    public void deletar(String email) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE email = ?";
        try (Connection conn = ClassConection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            int linhas = ps.executeUpdate();
            System.out.println(linhas > 0 ? "Usuário deletado!" : "Usuário não encontrado.");
        }
    }
}