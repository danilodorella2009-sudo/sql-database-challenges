package JDBC_1_Pratica.Exercicio_2_Sistema_de_Compra_Online.entities;

import java.util.ArrayList;
import java.util.List;

public final class Carrinho {

    private List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto p : produtos)
            total += p.getPrecoProduto();
        return total;
    }
}