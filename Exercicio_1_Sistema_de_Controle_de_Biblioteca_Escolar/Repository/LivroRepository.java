package JDBC_1_Pratica.Exercicio_1_Sistema_de_Controle_de_Biblioteca_Escolar.Repository;

import JDBC_1_Pratica.Exercicio_1_Sistema_de_Controle_de_Biblioteca_Escolar.ClassConection.Conection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LivroRepository {

    public void cadastrar(String titulo, int codigo) throws SQLException {
        Connection conn = Conection.getConnection();
        String sql = "INSERT INTO livro (codigoLivro, tituloLivro, livroDisponivel) "
                + "VALUES (" + codigo + ", '" + titulo + "', 1)";
        conn.createStatement().execute(sql);
        System.out.println("Livro cadastrado com sucesso!");
        conn.close();
    }

    public void listar() throws SQLException {
        Connection conn = Conection.getConnection();
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM livro");
        System.out.println(" Livros Cadastrados ");
        while (rs.next())
            System.out.println("Codigo: " + rs.getInt("codigoLivro")
                    + " | Titulo: " + rs.getString("tituloLivro")
                    + " | Disponivel: " + (rs.getInt("livroDisponivel") == 1 ? "Sim" : "Nao"));
        conn.close();
    }

    public void listarDisponiveis() throws SQLException {
        Connection conn = Conection.getConnection();
        ResultSet rs = conn.createStatement().executeQuery(
                "SELECT * FROM livro WHERE livroDisponivel = 1");
        System.out.println(" Livros Disponiveis ");
        while (rs.next())
            System.out.println("Codigo: " + rs.getInt("codigoLivro")
                    + " | Titulo: " + rs.getString("tituloLivro"));
        conn.close();
    }

    public void listarEmprestados() throws SQLException {
        Connection conn = Conection.getConnection();
        ResultSet rs = conn.createStatement().executeQuery(
                "SELECT * FROM livro WHERE livroDisponivel = 0");
        System.out.println("=== Livros Emprestados ===");
        while (rs.next())
            System.out.println("Codigo: " + rs.getInt("codigoLivro")
                    + " | Titulo: " + rs.getString("tituloLivro"));
        conn.close();
    }

    public void cancelar(int codigo) throws SQLException {
        Connection conn = Conection.getConnection();
        int linhas = conn.createStatement().executeUpdate(
                "DELETE FROM livro WHERE codigoLivro = " + codigo);
        System.out.println(linhas > 0 ? "Livro removido com sucesso!" : "Livro nao encontrado.");
        conn.close();
    }

    public void marcarEmprestado(int codigo) throws SQLException {
        Connection conn = Conection.getConnection();
        conn.createStatement().executeUpdate(
                "UPDATE livro SET livroDisponivel = 0 WHERE codigoLivro = " + codigo);
        conn.close();
    }

    public void marcarDevolvido(int codigo) throws SQLException {
        Connection conn = Conection.getConnection();
        int linhas = conn.createStatement().executeUpdate(
                "UPDATE livro SET livroDisponivel = 1 WHERE codigoLivro = " + codigo);
        System.out.println(linhas > 0 ? "Emprestimo cancelado com sucesso!" : "Livro nao encontrado.");
        conn.close();
    }
}