package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import estoque.Clientes;
import estoque.Pedidos;
import estoque.Produtos;
import processo.Transportadoras;

public class Main {

	public static void main(String[] args) {

		//=======================================//
		Produtos produtos = new Produtos();
		List<Pedidos> pedidos = new ArrayList<>();
		Clientes clientes = new Clientes();
		//==============Classes=================//
		
		//==============Scanner=================//
		Scanner ler = new Scanner(System.in);
		//======================================//
		
		//======Verifica��es==========//
		boolean vr1 = false;
		boolean vr2 = false;
		boolean vr3 = false;
		//============================//
		
		//======Variaveis========//
		int opc = 0;
		//=======================//
		
		//=====================La�o de Repeti��o===============//
		while(vr2 == false) {
		//=====================La�o do menu=====================//
			while(vr1 == false) {
				System.out.println("       System Estorage");
				System.out.println("=============================");
				System.out.println("[1]. Cadastrar Produtos");
				System.out.println("[2]. Cadastrar Clientes");
				System.out.println("[3]. Registrar Pedido");
				System.out.println("[4]. Remover Produto");
				System.out.println("[5]. Remover Cliente");
				System.out.println("[6]. Remover Pedido");
				System.out.println("[7]. Visualizar Clientes");
				System.out.println("[8]. Visualizar Estoque");
				System.out.println("[9]. Visualizar Pedidos");
				System.out.println("[10]. Sair");
				System.out.println("=============================");
				System.out.print("Escolha uma das op��es: ");
				try {
					opc = Integer.parseInt(ler.nextLine());
					vr1 = opc <= 10 && opc > 0?true:false;
					if(vr1 == false) {
						System.out.println("Digite uma op��o v�lida!!!\nTecle Enter para continuar....");
						ler.nextLine();
					}
				}
				catch(Exception ex) {
					System.out.println("Digite apenas n�meros!!!");
					System.out.println("Tecle Enter para continuar....\n");
					ler.nextLine();
					vr1 = false;
				}
			}
		//========================================================//
			switch(opc) {
			
			//=====================Opc 1=========================//
			case 1:
				
				//=========verificacao bloco de erro && variaveis=============//
				boolean vr_bloco1 = false;
				boolean vr_bloco2 = false;
				boolean vr_bloco3 = false;
				boolean vr_bloco4 = false;
				boolean cadastrar = true;
				int num = 0;
				String nome_produto = "";
				Double pre�o = 0.0;
				Integer quantidade = 0, id = 0;
				//===============================================//
				
				//===============================================//
				System.out.println("\nCadastro de Produtos");
				System.out.println("====================\n");
				//==============================================//				
				
				//============Numero de produtos a serem cadastrados=====================//
				while(vr_bloco1 == false) {
					System.out.print("Digite Quantos Produtos Gostaria De Cadastras: ");
					try {num = Integer.parseInt(ler.nextLine());
						 vr_bloco1 = num > 0? true:false;
						 if(vr_bloco1 == false) {
							 System.out.println("Digite um n�mero v�lido!!!\nTecle Enter para continuar....");
							 ler.nextLine();
						 }
					}
					catch(Exception ex) {
						System.out.println("\nDigite apenas n�meros!!!\nTecle Enter para continuar....");
						ler.nextLine();
						vr_bloco1 = false;
					}					
				}
				//======================================================================//
				
				//===========================La�o para adicionar produtos================//
				for(int i = 0; i < num; i++) {
					vr_bloco2 = false;
					vr_bloco3 = false;
					vr_bloco4 = false;
					// repeticao do vr_bloco2 do la�o while para caso acontecer algum erro
					while(vr_bloco2 == false) {
						//=================Pesquisa pelo produto no estoque ========================//
						System.out.println("==============================");
						System.out.print("Nome do produto: ");
						nome_produto = ler.nextLine();
						for(int i2 = 0; i2 < produtos.getSize(); i2++) {
							//Confirmar o cadastro do produto
							if(nome_produto.equalsIgnoreCase(produtos.getProduct(i2))) {
								while(vr_bloco3 == false) {
									System.out.print("Produto j� cadastrado, deseja mesmo assim o cadastras?[S/N]: ");
									String pdc = ler.nextLine();
									if(pdc.equalsIgnoreCase("S") || pdc.equalsIgnoreCase("sim")) {
										cadastrar = true;
										vr_bloco3 = true;
										break;
									}
									else if(pdc.equalsIgnoreCase("n") || pdc.equalsIgnoreCase("n�o")) {
										cadastrar = false;
										vr_bloco3 = true;
										break;
									}
									else vr_bloco3 = false;									
								}
							}
							//==================================
						}
						
						if(cadastrar == true) {
							System.out.print("Pre�o R$: ");
							//=======Verifica��o do valor digitado=======//
							while(vr_bloco4 == false) {
								try {
									pre�o = Double.parseDouble(ler.nextLine());
									vr_bloco4 = true;
								}
								catch(Exception ex) {
									System.out.print("Digite um valor v�lido!!!\nTecle Enter para continuar....\n");
									ler.nextLine();
									vr_bloco4 = false;
								}
							}
							//===========================================//
							//======Verifica��o do valor digitado ======//
							vr_bloco4 = false;
							System.out.print("Quantidade de Produtos: ");
							while(vr_bloco4 == false) {
								try {
									quantidade = Integer.parseInt(ler.nextLine());
									vr_bloco4 = true;
								}
								catch(Exception ex) {
									System.out.print("Digite um valor v�lido!!!\nTecle Enter para continuar....\n");
									ler.nextLine();
									vr_bloco4 = false;
								}
							}
							//==========================================//
							//======Verifica��o do valor digitado ======//
							vr_bloco4 = false;
							System.out.print("ID Do Produto: ");
							while(vr_bloco4 == false) {
								try {
									id = Integer.parseInt(ler.nextLine());
									vr_bloco4 = true;
									System.out.println("==============================");

								}
								catch(Exception ex) {
									System.out.print("Digite um valor v�lido!!!\nTecle Enter para continuar....\n");
									ler.nextLine();
									vr_bloco4 = false;
								}
							}
							//==========================================//
							
							produtos.addProduct(nome_produto, pre�o, quantidade, id);
							System.out.println("\nProduto Cadastrado Com Sucesso!!!\nTecle Enter para continuar.....");
							System.out.println("==============================");
							ler.nextLine();	
							vr_bloco2 = true;
							vr_bloco4 = false;
							vr1 = false;
						}
						else {
							vr_bloco2 = true;
							vr1 = false;
							System.out.println("\nTecle Enter para continuar.....");
							ler.nextLine();
							vr_bloco4 = false;
						}						
						//========================================================================//
					}
				}				
				break;
			//===================================================//
			
			//========================Opc 2======================//	
			case 2:
				
				//=================Variaveis e blocos de erro====================//
				
				boolean cr_bloco1 = false;
				boolean cr_bloco2 = false;
				cadastrar = true;
				String nome = "";
				String empresa = "";
				String transportadora = "";

				int num2 = 0;
				//===============================================================//
				
				System.out.println("Cadastro de Clientes");
				System.out.println("====================\n");
				
				//============Numero de produtos a serem cadastrados=====================//
				while(cr_bloco1 == false) {
					System.out.print("Digite quantos clientes gostaria de cadastrar: ");
					try {
						num2 = Integer.parseInt(ler.nextLine());
						cr_bloco1 = num2 > 0? true:false;
						if(cr_bloco1 == false) {
							System.out.println("Digite um n�mero v�lido!!!\nTecle Enter para continuar....");
							ler.nextLine();
						}
					}
					catch(Exception ex) {
						System.out.println("\nDigite apenas n�meros!!!\nTecle Enter para continuar....");
						ler.nextLine();
						cr_bloco1 = false;
					}					
				}
				//======================================================================//				
								
				for(int i = 0; i<num2; i++) {
					
					System.out.println("==============================");
					System.out.print("Digite o nome do cliente: ");
					nome = ler.nextLine();
					
					while(cr_bloco2 == false) {
						System.out.print("Digite o nome da empresa: ");
						empresa = ler.nextLine();
						
						if(clientes.getSize() > 0) {
							for(int i2 = 0; i2 < clientes.getSize(); i2++) {
								if(empresa.equalsIgnoreCase(clientes.getEmpresa(i2))) {
									System.out.print("Empresa j� cadastrada, deseja mesmo assim o cadastrar?[S/N]: ");
									String yesno = ler.nextLine();
									
									if(yesno.equalsIgnoreCase("s") || yesno.equalsIgnoreCase("sim")) {
										cadastrar = true;
										cr_bloco2 = true;
										break;
									}
									else if(yesno.equalsIgnoreCase("n") || yesno.equalsIgnoreCase("n�o")) {
										cadastrar = false;
										cr_bloco2 = true;
										break;
									}
									else {
										System.out.println("Escolha uma das op��es corretamente!!!\nTecle Enter para continuar....\n");
										ler.nextLine();
										continue;
									}
								}
								else {
									cr_bloco2 = true;
									cadastrar = true;
								}
							}
						}
						else {
							cr_bloco2 = true;
							cadastrar = true;
						}
					}
					
					if(cadastrar == true) {
						System.out.print("Digite a transportadora desejada: ");
						transportadora = ler.nextLine();
						System.out.println("==============================");

						clientes.addClient(nome, empresa, transportadora);
						System.out.println("Cliente Cadastrado Com Sucesso!!!\nTecle Enter para continuar....\n");
						ler.nextLine();

						vr1 = false;
						cr_bloco2 = false;
						cadastrar = true;
					}
					else {
						vr_bloco2 = true;
						vr1 = false;
						System.out.println("\nTecle Enter para continuar.....");
						ler.nextLine();
						cr_bloco2 = false;
						cadastrar = true;
					}
				}
				
				
				break;
			//===================================================//	
				
			default:
				
				System.out.println("Nenhuma op��o selecionada!!!\n");
				vr2 = false;
				
				break;			
			}
		}
		//========================================================//
		
		//=================Finalizar Scanner==================//
		ler.close();
		//====================================================//
	}

}
