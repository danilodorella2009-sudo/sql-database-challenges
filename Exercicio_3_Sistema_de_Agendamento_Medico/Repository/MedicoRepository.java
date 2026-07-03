package JDBC_1_Pratica.Exercicio_3_Sistema_de_Agendamento_Medico.Repository;

import JDBC_1_Pratica.Exercicio_3_Sistema_de_Agendamento_Medico.ClassConection.ClassConection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicoRepository {

    public void salvar(String nome, String especialidade) throws SQLException {
        String sql = "INSERT INTO medicos (nome, especialidade) VALUES (?, ?)";
        try (Connection conn = ClassConection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, especialidade);
            stmt.executeUpdate();
            System.out.println("Medico cadastrado com sucesso!");
        }
    }

    public void listar() throws SQLException {
        String sql = "SELECT * FROM medicos";
        try (Connection conn = ClassConection.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {
            System.out.println("=== Medicos Cadastrados ===");
            while (rs.next())
                System.out.println("ID: " + rs.getInt("id")
                        + " | Nome: " + rs.getString("nome")
                        + " | Especialidade: " + rs.getString("especialidade"));
        }
    }

    public boolean deletar(int id) throws SQLException {
        String sql = "DELETE FROM medicos WHERE id = ?";
        try (Connection conn = ClassConection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }
}