package JDBC_1_Pratica.Exercicio_3_Sistema_de_Agendamento_Medico.entities;

public final class Consulta {

    private int id;
    private int pacienteId;
    private String especialidade;
    private String horario;

    public Consulta(int id, int pacienteId, String especialidade, String horario) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.especialidade = especialidade;
        this.horario = horario;
    }

    public int getId() {
        return id;
    }

    public int getPacienteId() {
        return pacienteId;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getHorario() {
        return horario;
    }

    @Override
    public String toString() {
        return "ID: " + id
                + " | Paciente ID: " + pacienteId
                + " | Especialidade: " + especialidade
                + " | Horario: " + horario;
    }
}