package JDBC_1_Pratica.Exercicio_2_Sistema_de_Compra_Online.entities;

public final class Produto {

    private int id;
    private String nomeProduto;
    private double precoProduto;
    private String nomeMarca;

    public Produto(int id, String nomeProduto, double precoProduto, String nomeMarca) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.nomeMarca = nomeMarca;
    }

    public int getId() {
        return id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    @Override
    public String toString() {
        return nomeProduto + " | Marca: " + nomeMarca
                + " | Preço: R$ " + String.format("%.2f", precoProduto);
    }
}