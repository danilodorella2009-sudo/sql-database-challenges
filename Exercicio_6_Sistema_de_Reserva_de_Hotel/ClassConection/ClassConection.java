package JDBC_1_Pratica.Exercicio_6_Sistema_de_Reserva_de_Hotel.ClassConection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClassConection {

    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/sistemareservahotel";
            String user = "root";
            String password = "";
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar no banco: " + e.getMessage());
        }
    }
}