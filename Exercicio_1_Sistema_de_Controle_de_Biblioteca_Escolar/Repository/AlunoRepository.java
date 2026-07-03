package JDBC_1_Pratica.Exercicio_1_Sistema_de_Controle_de_Biblioteca_Escolar.Repository;

import JDBC_1_Pratica.Exercicio_1_Sistema_de_Controle_de_Biblioteca_Escolar.ClassConection.Conection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoRepository {

    public void cadastrar(String nome, int matricula) throws SQLException {
        Connection conn = Conection.getConnection();
        String sql = "INSERT INTO aluno (matricula, nomeAluno, possuiMulta, livrosEmprestados) "
                + "VALUES (" + matricula + ", '" + nome + "', 0, 0)";
        conn.createStatement().execute(sql);
        System.out.println("Aluno cadastrado com sucesso!");
        conn.close();
    }

    public void listar() throws SQLException {
        Connection conn = Conection.getConnection();
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM aluno");
        System.out.println(" Alunos Cadastrados ");
        while (rs.next())
            System.out.println("Matricula: " + rs.getInt("matricula")
                    + " | Nome: " + rs.getString("nomeAluno")
                    + " | Multa: " + (rs.getInt("possuiMulta") == 1 ? "Sim" : "Nao")
                    + " | Livros emprestados: " + rs.getInt("livrosEmprestados"));
        conn.close();
    }

    public void listarParaEmprestimo() throws SQLException {
        Connection conn = Conection.getConnection();
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM aluno");
        System.out.println(" Alunos ");
        while (rs.next())
            System.out.println("Matricula: " + rs.getInt("matricula")
                    + " | Nome: " + rs.getString("nomeAluno"));
        conn.close();
    }

    public void listarComEmprestimo() throws SQLException {
        Connection conn = Conection.getConnection();
        ResultSet rs = conn.createStatement().executeQuery(
                "SELECT * FROM aluno WHERE livrosEmprestados > 0");
        System.out.println(" Alunos com Livros Emprestados ");
        while (rs.next())
            System.out.println("Matricula: " + rs.getInt("matricula")
                    + " | Nome: " + rs.getString("nomeAluno"));
        conn.close();
    }

    public void cancelar(int matricula) throws SQLException {
        Connection conn = Conection.getConnection();
        int linhas = conn.createStatement().executeUpdate(
                "DELETE FROM aluno WHERE matricula = " + matricula);
        System.out.println(linhas > 0 ? "Aluno removido com sucesso!" : "Aluno nao encontrado.");
        conn.close();
    }

    public void adicionarEmprestimo(int matricula) throws SQLException {
        Connection conn = Conection.getConnection();
        conn.createStatement().executeUpdate(
                "UPDATE aluno SET livrosEmprestados = livrosEmprestados + 1 WHERE matricula = " + matricula);
        conn.close();
    }

    public void removerEmprestimo(int matricula) throws SQLException {
        Connection conn = Conection.getConnection();
        conn.createStatement().executeUpdate(
                "UPDATE aluno SET livrosEmprestados = livrosEmprestados - 1 "
                        + "WHERE matricula = " + matricula + " AND livrosEmprestados > 0");
        conn.close();
    }
}