import java.util.*;

public class CarrinhoDeCompras {
    // atributos
    private List<Item> itemList;

    // construtor
    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }

    // método para calcular valor total dos itens utilizando o Stream API
    public double calcularValorTotal() {
        if (itemList.isEmpty()) {
            throw new RuntimeException("A lista está vazia!");
        }
        return itemList.stream()
                .mapToDouble(item -> item.getPreco() * item.getQuantidade())
                .sum();
    }

    public void adicionarItens(String nome, double preco, int quantidade) {
        itemList.add(new Item(nome, preco, quantidade));
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItens("Item 1", 2.50, 1);
        carrinhoDeCompras.adicionarItens("Item 2", 1.50, 1);

        System.out.println(carrinhoDeCompras.calcularValorTotal());
    }

}