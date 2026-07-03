package JDBC_1_Pratica.Exercicio_3_Sistema_de_Agendamento_Medico.Repository;

import JDBC_1_Pratica.Exercicio_3_Sistema_de_Agendamento_Medico.ClassConection.ClassConection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaRepository {

    public void agendar(int pacienteId, String especialidade, String horario) throws SQLException {
        String sql = "INSERT INTO consulta (paciente_id, especialidade, horario) VALUES (?, ?, ?)";
        try (Connection conn = ClassConection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pacienteId);
            stmt.setString(2, especialidade);
            stmt.setString(3, horario);
            stmt.executeUpdate();
            System.out.println("Consulta agendada com sucesso!");
        }
    }

    public void listar() throws SQLException {
        String sql = "SELECT c.id, p.nome, c.especialidade, c.horario "
                + "FROM consulta c JOIN pacientes p ON c.paciente_id = p.id";
        try (Connection conn = ClassConection.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {
            System.out.println("=== Consultas Agendadas ===");
            while (rs.next())
                System.out.println("ID: " + rs.getInt("id")
                        + " | Paciente: " + rs.getString("nome")
                        + " | Especialidade: " + rs.getString("especialidade")
                        + " | Horario: " + rs.getString("horario"));
        }
    }

    public boolean deletar(int id) throws SQLException {
        String sql = "DELETE FROM consulta WHERE id = ?";
        try (Connection conn = ClassConection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }
}