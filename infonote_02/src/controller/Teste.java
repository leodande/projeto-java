package controller;

import model.*;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ItemDePedido Idp1 = new ItemDePedido();
		Idp1.setQtde(2);
		Idp1.setSubtotal(22.98);
		System.out.println(Idp1.toString());

		ItemDePedido Idp2 = new ItemDePedido();
		Idp2.setQtde(1);
		Idp2.setSubtotal(98.75);
		System.out.println(Idp2.toString());
		
		Usuario cliente =  new Usuario();
		cliente.setMatricula(201);
		cliente.setLogin("111");
		cliente.setSenha("");
		cliente.setNome("João");
		cliente.setEmail("j.c@gmail.com");
		cliente.setTelefone("");
		System.out.println(cliente.toString());
		
		Endereco end = new Endereco();
		end.setBairro("");
		end.setCidade("");
		end.setCep("");
		end.setLogradouro("");
		end.setComplemento("");
		end.setEstado("");
		end.setNumero("");
		System.out.println(end.toString());
		
		Notebook note = new Notebook();
		note.setDescricao(null);
		note.setModelo("Intel");
		note.setNumeroNote(2002-4);
		note.setDataCadastro("0001-5");
		note.setFigura("");
		note.setPrecoUnitario(2.000);
		
		note.setDescricao(null);
		note.setModelo("CCE");
		note.setNumeroNote(2044-4);
		note.setDataCadastro("0456-5");
		note.setFigura("");
		note.setPrecoUnitario(1500.00);
		
		note.setDescricao(null);
		note.setModelo("Positivo");
		note.setNumeroNote(2012-4);
		note.setDataCadastro("00063-5");
		note.setFigura("");
		note.setPrecoUnitario(1.800);
		System.out.println(note.toString());
		
		Pedido pdd = new Pedido();
		pdd.setNumero("");
		pdd.setDataEmissao("23-11-2018");
		pdd.setFormaDePagamento("");
		pdd.setValorTotal("");
		pdd.setSituacao("");
		
	}
	
	

}
