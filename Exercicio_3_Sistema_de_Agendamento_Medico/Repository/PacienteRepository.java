package JDBC_1_Pratica.Exercicio_3_Sistema_de_Agendamento_Medico.Repository;

import JDBC_1_Pratica.Exercicio_3_Sistema_de_Agendamento_Medico.ClassConection.ClassConection;
import JDBC_1_Pratica.Exercicio_3_Sistema_de_Agendamento_Medico.entities.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PacienteRepository {

    public void salvar(String cpf, String nome) throws SQLException {
        String sql = "INSERT INTO pacientes (cpf, nome) VALUES (?, ?)";
        try (Connection conn = ClassConection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            stmt.setString(2, nome);
            stmt.executeUpdate();
            System.out.println("Paciente cadastrado com sucesso!");
        }
    }

    public void listar() throws SQLException {
        String sql = "SELECT * FROM pacientes";
        try (Connection conn = ClassConection.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {
            System.out.println("=== Pacientes Cadastrados ===");
            while (rs.next())
                System.out.println("ID: " + rs.getInt("id")
                        + " | CPF: " + rs.getString("cpf")
                        + " | Nome: " + rs.getString("nome"));
        }
    }

    public Paciente buscarPorCpf(String cpf) throws SQLException {
        String sql = "SELECT * FROM pacientes WHERE cpf = ?";
        try (Connection conn = ClassConection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next())
                    return new Paciente(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome"));
                return null;
            }
        }
    }

    public boolean atualizar(String cpf, String novoNome) throws SQLException {
        String sql = "UPDATE pacientes SET nome = ? WHERE cpf = ?";
        try (Connection conn = ClassConection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, novoNome);
            stmt.setString(2, cpf);
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deletar(String cpf) throws SQLException {
        String sql = "DELETE FROM pacientes WHERE cpf = ?";
        try (Connection conn = ClassConection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            return stmt.executeUpdate() > 0;
        }
    }
}