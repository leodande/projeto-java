package controller;

import model.*;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario user = new Usuario(1, "joseph", "climber", "Joseph Climber", "josephclimber@gmail.com", "2222-3344");
		
		user.mostrar();
		
		Endereco end1 = new Endereco("rua", 220, "casa", "Irajá", "Rio de Janeiro", "RJ", 21250-260);
		
		end1.mostrar();
		
		ItemDePedido ped1 = new ItemDePedido(2 , 22.98);
		ItemDePedido ped2 = new ItemDePedido(1, 98.75);
		
		ped1.mostrar();
		ped2.mostrar();
		
		Notebook note1 = new Notebook(1, "Intel", "16GB e 1TB", 20024, 2.000, "note01.jpg", "25-01-2005");
		Notebook note2 = new Notebook(2, "CCE", "16GB", 20444, 1.500, "note03.jpg", "04-10-2016");
		Notebook note3 = new Notebook(3, "Positivo", "16GB", 20124, 1.800, "note04.jpg", "10-06-2017");
		
		note1.mostrar();
		note2.mostrar();
		note3.mostrar();
		
		Pedido ped = new Pedido(0001, "23-11-2018", "Dinheiro", 1.200, "Regular");
		
		ped.mostrar();
	}
		
	}
	
	


