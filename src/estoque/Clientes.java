package estoque;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Clientes {

	private List<String> nomes = new ArrayList<>();
	private List<String> empresas = new ArrayList<>();
	private List<String> Transportadoras = new ArrayList<>();
	private List<Date> data_cadastro = new ArrayList<>();
	
	public void addClient(String nome, String empresa, String transportadora) {
		this.nomes.add(nome);
		this.empresas.add(empresa);
		this.Transportadoras.add(transportadora);
		this.data_cadastro.add(new Date());
	}
	
	public String getNome(int i) {
		return this.nomes.get(i);
	}
	
	public String getEmpresa(int i) {
		return this.empresas.get(i);
	}
	
	public String getTransportadora(int i) {
		return this.Transportadoras.get(i);
	}

	@Override
	public String toString() {
		StringBuilder montar = new StringBuilder();
		SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		montar.append("Clientes Cadastrados: \n");
		montar.append("=====================\n");
		
		for(int i = 0; i < this.nomes.size(); i++) {
			montar.append("Nome: " + this.nomes.get(i) + "\n");
			montar.append("Empresa: " + this.empresas.get(i) + "\n");
			montar.append("Transportadora: " + this.Transportadoras.get(i) + "\n");
			montar.append("Data e Hora de Cadastro: " + form.format(data_cadastro.get(i)));
			montar.append("==========================================\n");
		}
		
		
		return montar.toString();
	}
	
	public Integer getSize() {
		return nomes.size();
	}
	
	
	
	
	
}
