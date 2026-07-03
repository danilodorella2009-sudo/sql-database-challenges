package JDBC_1_Pratica.Exercicio_3_Sistema_de_Agendamento_Medico.entities;

public final class Medico extends Pessoa {

    private String especialidade;

    public Medico(int id, String nome, String especialidade) {
        super(id, nome);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    @Override
    public void exibirDados() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return super.toString() + " | Especialidade: " + especialidade;
    }
}