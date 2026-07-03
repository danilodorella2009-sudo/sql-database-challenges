package JDBC_1_Pratica.Exercicio_1_Sistema_de_Controle_de_Biblioteca_Escolar.ClassConection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {

    private static final String URL = "jdbc:mysql://localhost:3306/sistemabibliotecaescolar";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar: " + e.getMessage());
        }
    }
}