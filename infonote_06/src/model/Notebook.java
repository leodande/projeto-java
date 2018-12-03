package model;

public class Notebook {
	
	private String serialNote;
	private int numeroNote;
	private String modelo;
	private String descricao;
	private int estoque;
	private double precoUnitario;
	private String figura;
	private String dataCadastro;

	
	
	public String getSerialNote() {
		return serialNote;
	}

	public void setSerialNote(String serialNote) {
		this.serialNote = serialNote;
	}

	public int getNumeroNote() {
		return numeroNote;
	}

	public void setNumeroNote(int numeroNote) {
		this.numeroNote = numeroNote;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public String getFigura() {
		return figura;
	}

	public void setFigura(String figura) {
		this.figura = figura;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Notebook() {
		super();
	}
	
	public Notebook(String serialNote, int numeroNote, String modelo, String descricao, int estoque, double precoUnitario, String figura, String dataCadastro) {
		super();
		
		this.serialNote = serialNote;
		this.numeroNote = numeroNote;
		this.descricao = descricao;
		this.estoque = estoque;
		this.precoUnitario = precoUnitario;
		this.figura = figura;
		this.dataCadastro = dataCadastro;
		
		
	}
	
	@Override
	public String toString() {
		final String ENTER = "\n";
		String retValue = "";
		
		retValue = "N�mero do Notebook: " + ENTER +
				"Modelo: " + modelo + ENTER +
				" Descr��o: " + descricao + ENTER +
				"Estoque: " + estoque + ENTER +
				"Pre�o Unit�rio: " + precoUnitario + ENTER + 
				"Figura: " + figura + ENTER +
				"Data do Cadastro: " + ENTER + 
				"Itens: ";
		
		return retValue;
	}
	
	public String toString() {
		
		System.out.println("N�mero do Notebook: " + this.numeroNote);
		System.out.println("Modelo: " + this.modelo);
		System.out.println("Descri��o: " + this.descricao);
		System.out.println("Estoque: " + this.estoque);
		System.out.println("Pre�o Unit�rio: " + this.precoUnitario);
		System.out.println("Figura: " + this.figura);
		System.out.println("Data do Cadastro: " + this.dataCadastro);
		
		
	}

}
