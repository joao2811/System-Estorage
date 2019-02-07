package estoque;

import java.util.ArrayList;
import java.util.List;

public class Produtos {

	private List<Integer> id = new ArrayList<>();
	private List<String> produtos = new ArrayList<>();
	private List<Double> price = new ArrayList<>();
	private List<Integer> quantity = new ArrayList<>();
	
	public void addProduct(String produto, Double price, Integer quantity, Integer id) {
		this.id.add(id);
		this.produtos.add(produto);
		this.price.add(price);
		this.quantity.add(quantity);
	}
	
	public void removeProduct(int id) {
		for(int i = 0; i < this.id.size(); i++) {
			if(id == this.id.get(i)) {
				this.id.remove(i);
				this.produtos.remove(i);
				this.price.remove(i);
				this.quantity.remove(i);
			}
		}
	}
	
	public String getProduct(int i) {
		return produtos.get(i);
	}
	
	public Double getPrice(int i) {
		return price.get(i);
	}
	
	public Integer getID(int i) {
		return id.get(i);
	}

	
	public Integer getQuantity(int i) {
		return quantity.get(i);
	}
	
	@Override
	public String toString() {
		StringBuilder montar = new StringBuilder();
		
		for(int i = 0; i < id.size(); i++) {
			montar.append("ID: " + id.get(i) + "\n");
			montar.append("Product: " + produtos.get(i) + "\n");
			montar.append("Quantity: " + quantity.get(i) + "\n");
			montar.append("Price unity R$: " + String.format("%.2f %n", price.get(i)));
			montar.append("Amount R$: " + String.format("%.2f %n", (quantity.get(i) * price.get(i))));
			montar.append("====================================\n");
		}
		
		return montar.toString();
	}
	
	public int getSize() {
		return this.id.size();
	}
}
