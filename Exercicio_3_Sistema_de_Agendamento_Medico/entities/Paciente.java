package JDBC_1_Pratica.Exercicio_3_Sistema_de_Agendamento_Medico.entities;

public final class Paciente extends Pessoa {

    private String cpf;

    public Paciente(int id, String cpf, String nome) {
        super(id, nome);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public void exibirDados() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return super.toString() + " | CPF: " + cpf;
    }
}