package JDBC_1_Pratica.Exercicio_3_Sistema_de_Agendamento_Medico.aplication;

import JDBC_1_Pratica.Exercicio_3_Sistema_de_Agendamento_Medico.Repository.ConsultaRepository;
import JDBC_1_Pratica.Exercicio_3_Sistema_de_Agendamento_Medico.Repository.MedicoRepository;
import JDBC_1_Pratica.Exercicio_3_Sistema_de_Agendamento_Medico.Repository.PacienteRepository;
import JDBC_1_Pratica.Exercicio_3_Sistema_de_Agendamento_Medico.entities.Paciente;
import JDBC_1_Pratica.Exercicio_3_Sistema_de_Agendamento_Medico.enums.Especialidade;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PacienteRepository pacienteRepo = new PacienteRepository();
        MedicoRepository medicoRepo = new MedicoRepository();
        ConsultaRepository consultaRepo = new ConsultaRepository();
        boolean continuar = true;

        try {
            while (continuar) {

                System.out.println("  SISTEMA DE AGENDAMENTO MEDICO ");
                System.out.println("1  - Cadastrar paciente");
                System.out.println("2  - Buscar paciente por CPF");
                System.out.println("3  - Listar pacientes");
                System.out.println("4  - Atualizar nome do paciente");
                System.out.println("5  - Deletar paciente");
                System.out.println("6  - Cadastrar medico");
                System.out.println("7  - Listar medicos");
                System.out.println("8  - Deletar medico");
                System.out.println("9  - Agendar consulta");
                System.out.println("10 - Listar consultas");
                System.out.println("11 - Deletar consulta");
                System.out.println("0  - Sair");
                System.out.print("Escolha: ");

                int opcao = Integer.parseInt(sc.nextLine());

                switch (opcao) {

                    case 1 -> {
                        System.out.println(" Cadastrar Paciente ");
                        System.out.print("CPF (11 numeros): ");
                        String cpf = sc.nextLine();
                        if (!cpf.matches("\\d{11}")) {
                            System.out.println("CPF invalido.");
                            break;
                        }
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();
                        if (nome.matches(".*\\d.*")) {
                            System.out.println("Nome invalido.");
                            break;
                        }
                        pacienteRepo.salvar(cpf, nome);
                    }

                    case 2 -> {
                        System.out.println(" Buscar Paciente ");
                        System.out.print("CPF (11 numeros): ");
                        String cpf = sc.nextLine();
                        if (!cpf.matches("\\d{11}")) {
                            System.out.println("CPF invalido.");
                            break;
                        }
                        Paciente p = pacienteRepo.buscarPorCpf(cpf);
                        System.out.println(p != null ? "Encontrado: " + p : "Paciente nao encontrado.");
                    }

                    case 3 -> {
                        System.out.println(" Lista de Pacientes ");
                        pacienteRepo.listar();
                    }

                    case 4 -> {
                        System.out.println(" Atualizar Paciente ");
                        pacienteRepo.listar();
                        System.out.print("CPF do paciente: ");
                        String cpf = sc.nextLine();
                        if (!cpf.matches("\\d{11}")) {
                            System.out.println("CPF invalido.");
                            break;
                        }
                        System.out.print("Novo nome: ");
                        String novoNome = sc.nextLine();
                        boolean ok = pacienteRepo.atualizar(cpf, novoNome);
                        System.out.println(ok ? "Nome atualizado!" : "Paciente nao encontrado.");
                    }

                    case 5 -> {
                        System.out.println(" Deletar Paciente ");
                        pacienteRepo.listar();
                        System.out.print("CPF do paciente: ");
                        String cpf = sc.nextLine();
                        if (!cpf.matches("\\d{11}")) {
                            System.out.println("CPF invalido.");
                            break;
                        }
                        boolean ok = pacienteRepo.deletar(cpf);
                        System.out.println(ok ? "Paciente deletado!" : "Paciente nao encontrado.");
                    }

                    case 6 -> {
                        System.out.println(" Cadastrar Medico ");
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();
                        System.out.println("Especialidade:");
                        for (int i = 0; i < Especialidade.values().length; i++)
                            System.out.println((i + 1) + " - " + Especialidade.values()[i]);
                        int esp = Integer.parseInt(sc.nextLine());
                        if (esp < 1 || esp > Especialidade.values().length) {
                            System.out.println("Invalido.");
                            break;
                        }
                        medicoRepo.salvar(nome, Especialidade.values()[esp - 1].name());
                    }

                    case 7 -> {
                        System.out.println(" Lista de Medicos ");
                        medicoRepo.listar();
                    }

                    case 8 -> {
                        System.out.println(" Deletar Medico ");
                        medicoRepo.listar();
                        System.out.print("ID do medico: ");
                        int id = Integer.parseInt(sc.nextLine());
                        boolean ok = medicoRepo.deletar(id);
                        System.out.println(ok ? "Medico deletado!" : "Medico nao encontrado.");
                    }

                    case 9 -> {
                        System.out.println(" Agendar Consulta ");
                        pacienteRepo.listar();
                        System.out.print("ID do paciente: ");
                        int pacienteId = Integer.parseInt(sc.nextLine());
                        System.out.println("Especialidade:");
                        for (int i = 0; i < Especialidade.values().length; i++)
                            System.out.println((i + 1) + " - " + Especialidade.values()[i]);
                        int esp = Integer.parseInt(sc.nextLine());
                        if (esp < 1 || esp > Especialidade.values().length) {
                            System.out.println("Invalido.");
                            break;
                        }
                        System.out.print("Horario (HH:mm): ");
                        String horario = sc.nextLine();
                        consultaRepo.agendar(pacienteId, Especialidade.values()[esp - 1].name(), horario);
                    }

                    case 10 -> {
                        System.out.println(" Lista de Consultas ");
                        consultaRepo.listar();
                    }

                    case 11 -> {
                        System.out.println(" Deletar Consulta ");
                        consultaRepo.listar();
                        System.out.print("ID da consulta: ");
                        int id = Integer.parseInt(sc.nextLine());
                        boolean ok = consultaRepo.deletar(id);
                        System.out.println(ok ? "Consulta deletada!" : "Consulta nao encontrada.");
                    }

                    case 0 -> {
                        System.out.println("Sistema encerrado. Ate logo!");
                        continuar = false;
                    }

                    default -> System.out.println("Opcao invalida. Tente novamente.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro no banco de dados: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Digite apenas numeros no menu.");
        }

        sc.close();
    }
}