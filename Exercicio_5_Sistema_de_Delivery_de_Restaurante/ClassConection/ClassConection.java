package JDBC_1_Pratica.Exercicio_5_Sistema_de_Delivery_de_Restaurante.ClassConection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClassConection {

    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/sistemadelivery";
            String user = "root";
            String password = "";
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar no banco: " + e.getMessage());
        }
    }
}