package JDBC_1_Pratica.Exercicio_5_Sistema_de_Delivery_de_Restaurante.Repository;

import JDBC_1_Pratica.Exercicio_5_Sistema_de_Delivery_de_Restaurante.ClassConection.ClassConection;



import java.sql.*;

public class AutenticadorRepository {

    public boolean autenticar(String login, String senha) {
        String sql = "SELECT id FROM usuarios WHERE login = ? AND senha = ?";
        try (Connection conn = ClassConection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, login);
            ps.setString(2, senha);
            return ps.executeQuery().next();
        } catch (SQLException e) {
            System.out.println("Erro ao autenticar: " + e.getMessage());
            return false;
        }
    }

    public void cadastrar(String login, String senha) {
        String sql = "INSERT INTO usuarios (login, senha) VALUES (?, ?)";
        try (Connection conn = ClassConection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, login);
            ps.setString(2, senha);
            ps.execute();
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        }
    }

    public void atualizarSenha(String login, String novaSenha) {
        String sql = "UPDATE usuarios SET senha = ? WHERE login = ?";
        try (Connection conn = ClassConection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, novaSenha);
            ps.setString(2, login);
            int linhas = ps.executeUpdate();
            System.out.println(linhas > 0 ? "Senha atualizada!" : "Usuário não encontrado.");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar senha: " + e.getMessage());
        }
    }

    public void deletar(String login) {
        String sql = "DELETE FROM usuarios WHERE login = ?";
        try (Connection conn = ClassConection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, login);
            ps.execute();
            System.out.println("Usuário removido.");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
    }
}