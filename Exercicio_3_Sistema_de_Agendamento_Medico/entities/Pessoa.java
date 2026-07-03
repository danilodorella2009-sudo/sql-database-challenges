package JDBC_1_Pratica.Exercicio_3_Sistema_de_Agendamento_Medico.entities;

public abstract class Pessoa {

    private int id;
    private String nome;

    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public abstract void exibirDados();

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome;
    }
}