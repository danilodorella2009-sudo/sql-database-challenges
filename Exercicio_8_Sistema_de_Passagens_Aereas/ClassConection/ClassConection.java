package JDBC_1_Pratica.Exercicio_8_Sistema_de_Passagens_Aereas.ClassConection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClassConection {

    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/sistemapassagens";
            String user = "root";
            String password = "";
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar no banco: " + e.getMessage());
        }
    }
}