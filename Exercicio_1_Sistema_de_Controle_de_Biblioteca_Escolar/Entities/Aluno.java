package JDBC_1_Pratica.Exercicio_1_Sistema_de_Controle_de_Biblioteca_Escolar.Entities;

public abstract class Aluno {

    private int matricula;
    private String nomeAluno;
    private boolean possuiMulta;
    private int livrosEmprestados;

    public Aluno(int matricula, String nomeAluno, boolean possuiMulta, int livrosEmprestados) {
        this.matricula = matricula;
        this.nomeAluno = nomeAluno;
        this.possuiMulta = possuiMulta;
        this.livrosEmprestados = livrosEmprestados;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public boolean isPossuiMulta() {
        return possuiMulta;
    }

    public int getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public abstract void exibirDados();

    @Override
    public String toString() {
        return "Matricula: " + matricula
                + " | Nome: " + nomeAluno
                + " | Multa: " + (possuiMulta ? "Sim" : "Nao")
                + " | Livros emprestados: " + livrosEmprestados;
    }
}