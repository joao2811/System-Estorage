package estoque;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedidos {

	private Integer Id;
	private String Nome;
	private String Empresa;
	private String Transportadora;
	private List<Produtos> Produtos = new ArrayList<>();
	private Date Data_pedido;

	public void addPedidos(Integer id, String nome, String empresa, String transportadora, Produtos prod) {

		this.Id = id;
		this.Nome = nome;
		this.Empresa = empresa;
		this.Transportadora = transportadora;
		this.Produtos.add(prod);
		this.Data_pedido = new Date();

	}

	public Integer getId() {
		return Id;
	}

	public String getNome() {
		return Nome;
	}

	public String getEmpresa() {
		return Empresa;
	}

	public String getTransportadora() {
		return Transportadora;
	}

	public Date getData_pedido() {
		return Data_pedido;
	}

	@Override
	public String toString() {
		SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		StringBuilder montar = new StringBuilder();
		montar.append("\n");
		
		montar.append("Informações do pedido #" + Id + ": \n");
		montar.append("Nome: " + Nome + "\n");
		montar.append("Empresa: " + Empresa + "\n");
		montar.append("Transportadora: " + Transportadora + "\n");
		montar.append("Data do Pedido: " +  form.format(Data_pedido) + "\n");
		montar.append("===================================================\n");
		for(int i = 0; i < this.Produtos.size(); i++) {
			montar.append(this.Produtos.get(i).toString());			
		}

	return montar.toString();
}

}
