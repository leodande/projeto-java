package model;

public class Pedido {

	private int numero;
	private String dataEmissao;
	private String formaDePagamento;
	private double valorTotal;
	private String situacao;
	
	@Override
	public String toString() {
		return "Pedido [numero=" + numero + ", dataEmissao=" + dataEmissao + ", formaDePagamento=" + formaDePagamento
				+ ", valorTotal=" + valorTotal + ", situacao=" + situacao + "]";
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
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
	
	public Pedido() {
		super();
	}
	
	public Pedido(int numero, String dataEmissao, String formaDePagamento, double valorTotal, String situacao) {
		super();
		
		this.numero = numero;
		this.dataEmissao = dataEmissao;
		this.formaDePagamento = formaDePagamento;
		this.valorTotal = valorTotal;
		this.situacao = situacao;
		
	}
	
	public void  mostrar() {
		
		System.out.println("Número de Pedido: " + this.numero);
		System.out.println("Data de Emissão: " + this.dataEmissao);
		System.out.println("Forma de Pagamento: " + this.formaDePagamento);
		System.out.println("Valor Total: " + this.valorTotal);
		System.out.println("Situação: " + this.situacao);
		
	}

}
