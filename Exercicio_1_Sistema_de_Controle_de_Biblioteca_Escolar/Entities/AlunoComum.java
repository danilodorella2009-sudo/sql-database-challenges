package JDBC_1_Pratica.Exercicio_1_Sistema_de_Controle_de_Biblioteca_Escolar.Entities;

public final class AlunoComum extends Aluno {

    private static final int LIMITE_LIVROS = 3;

    public AlunoComum(int matricula, String nomeAluno, boolean possuiMulta, int livrosEmprestados) {
        super(matricula, nomeAluno, possuiMulta, livrosEmprestados);
    }

    public int getLimiteLivros() {
        return LIMITE_LIVROS;
    }

    @Override
    public void exibirDados() {
        System.out.println(toString() + " | Limite de livros: " + LIMITE_LIVROS);
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: Comum | Limite: " + LIMITE_LIVROS + " livros";
    }
}