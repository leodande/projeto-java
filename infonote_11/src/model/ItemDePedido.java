package model;

import java.text.NumberFormat;

public class ItemDePedido {

	private int qtde;
	private double subtotal;
	private Notebook notebook; 
	private String NumeroFormatado;
	
	public void formataNumero(){
		NumberFormat f = NumberFormat.getCurrencyInstance();
		this.NumeroFormatado = f.format(this.NumeroFormatado);
	}
	
	
	@Override
	public String toString() {
		return "ItemDePedido [qtde=" + qtde + ", subtotal=" + subtotal + "]";
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public ItemDePedido(int qtde,  double subtotal) {
		super();
		
		this.qtde = qtde;
		this.subtotal = subtotal;
			
	}
	
	public void mostrar() {
		
		System.out.println("Quantidade: " + this.qtde);
		System.out.println("Subtotal: " + this.subtotal);
		
	}
	

	public Notebook getNotebook() {
		return notebook;
	}

	public void setNotebook(Notebook notebook) {
		this.notebook = notebook;
	}

	public ItemDePedido(int qtde, double subtotal, Notebook notebook) {
		super();
		this.qtde = qtde;
		this.subtotal = subtotal;
		this.notebook = notebook;
	}
}
