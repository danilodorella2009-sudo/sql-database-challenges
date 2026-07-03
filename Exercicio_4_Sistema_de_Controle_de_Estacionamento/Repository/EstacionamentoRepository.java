package JDBC_1_Pratica.Exercicio_4_Sistema_de_Controle_de_Estacionamento.Repository;

import JDBC_1_Pratica.Exercicio_4_Sistema_de_Controle_de_Estacionamento.ClassConection.ClassConection;
import JDBC_1_Pratica.Exercicio_4_Sistema_de_Controle_de_Estacionamento.entities.Carro;
import JDBC_1_Pratica.Exercicio_4_Sistema_de_Controle_de_Estacionamento.entities.Moto;
import JDBC_1_Pratica.Exercicio_4_Sistema_de_Controle_de_Estacionamento.entities.Veiculo;

import java.sql.*;
import java.util.Scanner;

public class EstacionamentoRepository {

    private final int TOTAL_VAGAS = 5;

    private int getQuantidadeVeiculos() throws SQLException {
        String sql = "SELECT COUNT(*) FROM movimentacao";
        try (Connection conn = ClassConection.getConection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {
            return rs.next() ? rs.getInt(1) : 0;
        }
    }

    public void entradaVeiculo(Scanner sc) {
        try {
            if (getQuantidadeVeiculos() >= TOTAL_VAGAS) {
                System.out.println("Estacionamento lotado.");
                return;
            }

            System.out.print("Placa: ");
            String placa = sc.nextLine().trim().toUpperCase();

            System.out.println("Tipo: 1- Carro, 2- Moto");
            int tipoOpcao = Integer.parseInt(sc.nextLine());

            String tipo = "";
            if (tipoOpcao == 1) tipo = "carro";
            else if (tipoOpcao == 2) tipo = "moto";
            else {
                System.out.println("Tipo invalido.");
                return;
            }

            try (Connection conn = ClassConection.getConection()) {

                String sqlCheck = "SELECT id FROM movimentacao WHERE veiculo_placa = ?";
                try (PreparedStatement ps = conn.prepareStatement(sqlCheck)) {
                    ps.setString(1, placa);
                    if (ps.executeQuery().next()) {
                        System.out.println("Veiculo ja esta no patio.");
                        return;
                    }
                }

                String sqlVeiculo = "INSERT IGNORE INTO veiculos (placa, tipo) VALUES (?, ?)";
                try (PreparedStatement ps = conn.prepareStatement(sqlVeiculo)) {
                    ps.setString(1, placa);
                    ps.setString(2, tipo);
                    ps.execute();
                }

                String sqlMov = "INSERT INTO movimentacao (veiculo_placa, horaEntrada) VALUES (?, NOW())";
                try (PreparedStatement ps = conn.prepareStatement(sqlMov)) {
                    ps.setString(1, placa);
                    ps.execute();
                }
            }

            System.out.println("Veiculo " + placa + " estacionado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro no banco: " + e.getMessage());
        }
    }

    public void saidaVeiculo(Scanner sc) {
        System.out.print("Placa: ");
        String placa = sc.nextLine().trim().toUpperCase();

        String sql = "SELECT v.tipo, m.horaEntrada, TIMESTAMPDIFF(HOUR, m.horaEntrada, NOW()) AS tempo "
                + "FROM movimentacao m "
                + "INNER JOIN veiculos v ON m.veiculo_placa = v.placa "
                + "WHERE m.veiculo_placa = ?";

        try (Connection conn = ClassConection.getConection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, placa);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.println("Veiculo nao encontrado no patio.");
                return;
            }

            int tempo = rs.getInt("tempo");
            if (tempo == 0) tempo = 1;
            String tipo = rs.getString("tipo");
            Timestamp horaEntrada = rs.getTimestamp("horaEntrada");

            Veiculo veiculo = tipo.equalsIgnoreCase("carro")
                    ? new Carro(placa, 0)
                    : new Moto(placa, 0);

            double valor = veiculo.calcularValor(tempo);

            System.out.println("Tempo estacionado: " + tempo + " hora(s)");
            System.out.printf("Valor total: R$ %.2f%n", valor);
            System.out.print("Pagamento aprovado? (s/n): ");
            String pagamento = sc.nextLine().trim();

            if (pagamento.equalsIgnoreCase("s")) {

                String sqlDelete = "DELETE FROM movimentacao WHERE veiculo_placa = ?";
                try (PreparedStatement del = conn.prepareStatement(sqlDelete)) {
                    del.setString(1, placa);
                    del.execute();
                }

                String sqlHistorico = "INSERT INTO historico (veiculo_placa, tipo, horaEntrada, horaSaida, valorPago) "
                        + "VALUES (?, ?, ?, NOW(), ?)";
                try (PreparedStatement ins = conn.prepareStatement(sqlHistorico)) {
                    ins.setString(1, placa);
                    ins.setString(2, tipo);
                    ins.setTimestamp(3, horaEntrada);
                    ins.setDouble(4, valor);
                    ins.execute();
                }

                System.out.println("Saida liberada e registrada no historico!");
            } else {
                System.out.println("Pagamento nao autorizado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao processar saida: " + e.getMessage());
        }
    }

    public void listarVeiculos() {
        System.out.println(" Veiculos no Patio ");
        String sql = "SELECT m.veiculo_placa, v.tipo, m.horaEntrada "
                + "FROM movimentacao m "
                + "INNER JOIN veiculos v ON m.veiculo_placa = v.placa "
                + "ORDER BY m.horaEntrada";

        try (Connection conn = ClassConection.getConection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {

            boolean temVeiculo = false;
            while (rs.next()) {
                temVeiculo = true;
                System.out.printf("Placa: %-10s | Tipo: %-5s | Entrada: %s%n",
                        rs.getString("veiculo_placa"),
                        rs.getString("tipo").toUpperCase(),
                        rs.getTimestamp("horaEntrada"));
            }
            if (!temVeiculo) System.out.println("Nenhum veiculo estacionado.");

        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
    }

    public void atualizarTipoVeiculo(Scanner sc) {
        System.out.print("Placa do veiculo: ");
        String placa = sc.nextLine().trim().toUpperCase();

        System.out.println("Novo tipo: 1- Carro, 2- Moto");
        int tipoOpcao;
        try {
            tipoOpcao = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Tipo invalido.");
            return;
        }

        String novoTipo = "";
        if (tipoOpcao == 1) novoTipo = "carro";
        else if (tipoOpcao == 2) novoTipo = "moto";
        else {
            System.out.println("Tipo invalido.");
            return;
        }

        String sql = "UPDATE veiculos SET tipo = ? WHERE placa = ?";
        try (Connection conn = ClassConection.getConection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, novoTipo);
            ps.setString(2, placa);
            int linhas = ps.executeUpdate();
            System.out.println(linhas > 0
                    ? "Tipo atualizado com sucesso!"
                    : "Placa nao encontrada.");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    public void listarHistorico() {
        System.out.println(" Historico de Saidas ");
        String sql = "SELECT * FROM historico ORDER BY horaSaida DESC";

        try (Connection conn = ClassConection.getConection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {

            boolean temRegistro = false;
            while (rs.next()) {
                temRegistro = true;
                System.out.printf("Placa: %-10s | Tipo: %-5s | Entrada: %s | Saida: %s | Valor: R$ %.2f%n",
                        rs.getString("veiculo_placa"),
                        rs.getString("tipo").toUpperCase(),
                        rs.getTimestamp("horaEntrada"),
                        rs.getTimestamp("horaSaida"),
                        rs.getDouble("valorPago"));
            }
            if (!temRegistro) System.out.println("Nenhum registro no historico.");

        } catch (SQLException e) {
            System.out.println("Erro ao listar historico: " + e.getMessage());
        }
    }
}