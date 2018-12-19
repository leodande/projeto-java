package model;

import java.text.NumberFormat;

public class Pedido {

	private int numeroPedido;
	private String dataEmissao;
	private String formaDePagamento;
	private double valorTotal;
	private String situacao;
	private String enderecoEntrega;
	@SuppressWarnings("unused")
	private String NumeroFormatado;
	
	public void formataNumero(){
		NumberFormat f = NumberFormat.getCurrencyInstance();
		this.NumeroFormatado = f.format(this.valorTotal);
	}
	
	@Override
	public String toString() {
		final String ENTER = "\n";
		String retValue = "";
		
		retValue = "Informações sobre Pedido: " + ENTER +
				"Número do Pedido: " + numeroPedido + ENTER +
				" Data de Emissão: " + dataEmissao + ENTER +
				"Forma de pagamento: " + formaDePagamento + ENTER +
				"Valor Total: " + valorTotal + ENTER + 
				"Situação: " + situacao + ENTER +
				"Endereço de Entrega: " + ENTER + 
				"Itens: ";
				
		for (int i = 0; i < itens.length; i++) {
			retValue  = itens[i] + ENTER;
		}
		return retValue;
	}

	
	
	public int getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public String getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	public String getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(String enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public Pedido() {
		super();
	}

	public Pedido(int numeroPedido, String dataEmissao, String formaDePagamento, double valorTotal, String situacao, String enderecoEntrega) {
		super();

		this.numeroPedido = numeroPedido;
		this.dataEmissao = dataEmissao;
		this.formaDePagamento = formaDePagamento;
		this.valorTotal = valorTotal;
		this.situacao = situacao;
		this.enderecoEntrega = enderecoEntrega;
	}

	public boolean inserirItem(ItemDePedido item) {
		for (int i = 0; i < itens.length; i++) {
			if (itens[i] == null) {
				itens[i] = item;
				return true;
			}
		}
		return false;
	}


	//private Endereco enderecoEntrega;
	private ItemDePedido itens[] = new ItemDePedido[10];

	

	public ItemDePedido[] getItens() {
		return itens;
	}

	public void setItens(ItemDePedido[] itens) {
		this.itens = itens;
	}

}
