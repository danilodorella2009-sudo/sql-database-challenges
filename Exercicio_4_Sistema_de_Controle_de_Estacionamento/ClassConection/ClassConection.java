package JDBC_1_Pratica.Exercicio_4_Sistema_de_Controle_de_Estacionamento.ClassConection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClassConection {

    public static Connection getConection()  {
        try {
            String url = "jdbc:mysql://localhost:3306/sistemaestacionamento";
            String user = "root";
            String password = "";
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar no banco: " + e.getMessage());
        }
    }
}