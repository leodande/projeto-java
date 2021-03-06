package controller;

import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;

import model.*;
import model.Notebook;
import model.Pedido;
import model.Usuario;
import util.Ajuda;
import util.Configurador;
import util.GerarSenha;
import util.Teclado;

public class InfoNote {
	
	Usuario user; // N�o esquecer de dar o import neste objeto

	Notebook notebooks[] = new Notebook[10];

	Pedido pedido;

	private static Cliente clienteGlobal = null;
	@SuppressWarnings("unused")
	private static Funcionario funcionarioGlobal = null;

	boolean logado = false; // Indica se o usu�rio esta logado.
	
	Configurador config;
	Ajuda ajuda;
	
	private static final int LOGIN = 1;
	private static final int CADASTRAR_USUARIO = 2;
	private static final int BUSCAR_NOTEBOOK = 3;
	private static final int INSERIR_NOTEBOOK = 4;
	private static final int REMOVER_NOTEBOOK = 5;
	private static final int VER_CARRINHO = 6;
	private static final int EFETUAR_COMPRA = 7;
	private static final int AJUDA = 8;
	private static final int SAIR = 9;
	
	public static void main(String[] args)  {

		InfoNote info = new InfoNote();

		int opcao = SAIR;

		do {

			info.mostrarMenu();
			opcao = Teclado.lerInt("Digite sua op��o: ");
			
			switch (opcao) {

			case LOGIN:
				info.efetuarLogin();
				break;

			case CADASTRAR_USUARIO:
				info.cadastrarUsuario();
				break;

			case BUSCAR_NOTEBOOK:
				info.buscarNotebook();
				break;

			case INSERIR_NOTEBOOK:
				info.manterCarrinho();
				break;

			case REMOVER_NOTEBOOK:
				info.manterCarrinho();
				break;

			case VER_CARRINHO:
				info.manterCarrinho();
				break;

			case EFETUAR_COMPRA:
				if (!info.logado) {
					System.out.println("Efetue login para efetuar compra.");
					break;
				} else {
					info.efetuarCompra();
					break;
				}
				
			case AJUDA:
				info.ajuda();
				break;
				
			case SAIR:
				System.out.println("Sa�da do Sistema.");
				break;

			default:
				System.out.println("Op��o inv�lida!");
			}
			Teclado.lerTexto("Pressione uma tecla para continuar...");

		} while (opcao != SAIR);

	}

		
		public InfoNote()  {
			// Cria objeto de configura��es
			config = new Configurador();
			Locale.setDefault(new Locale(config.getIdioma(), config.getRegiao()));
			// Cria o objeto Ajuda
			ajuda = new Ajuda(config.getArquivoAjuda());

		// public Notebook(String serialNote, int numeroNote, String modelo, String
		// descricao, int estoque, double precoUnitario, String figura, String
		// dataCadastro)

		notebooks[0] = new Notebook("A1", 1, "Negativo N22BR", "CPU intel Core 2 Duo, Mem�ria 2 GB, HD 250 GB", 6,
				1200.00, "img\\n22br.jpg", "19/05/2011");

		notebooks[1] = new Notebook("B22", 2, "Bell B55BR", "CPU intel I3, Mem�ria 4 GB, HD 500 GB", 3, 1800.00,
				"img\\b55br.jpg", "20/05/2011");

		notebooks[2] = new Notebook("H02", 3, "Pompaq P41BR", "CPU intel I3, Mem�ria 3 GB, HD 320 GB", 1, 1600.00,
				"img\\p41br.jpg", "21/05/2011");

		notebooks[3] = new Notebook("Z55", 4, "Negativo N22BR", "CPU intel Dual Core, Mem�ria 2 GB, HD 160 GB", 5,
				1100.00, "img\\cr71ch.jpg", "10/05/2011");

		notebooks[4] = new Notebook("K20", 5, "Negativo N22BR", "CPU AMD Phenon II, Mem�ria 4 GB, HD 500 GB", 2,
				1900.00, "img\\bd22br.jpg", "10/05/2011");

	}

	public void mostrarMenu() {
		System.out.println("=============================================");
		System.out.println("    InfoNote - Se n�o � Info n�o vendemos.  " +
		DateFormat.getDateInstance(DateFormat.SHORT).format(new Date())
		+ " " +
		DateFormat.getTimeInstance().format(new Date()));
		if (logado == true) {
			System.out.println("Seja bem vindo, " + clienteGlobal.getNomeInvertido());
		}

		System.out.println("==============================================");
		System.out.println("1 - Login");
		System.out.println("2 - Cadastrar Cliente");
		System.out.println("3 - Buscar notebook");
		System.out.println("4 - Inserir Notebook no carrinho");
		System.out.println("5 - Remover Notebook no carrinho");
		System.out.println("6 - ver Carrinho");
		System.out.println("7 - Efetuar Compra");
		System.out.println("8 - Ajuda");
		System.out.println("9 - Sair");
	}

	public void efetuarLogin() {
		String login, senha;
		login = Teclado.lerTexto("Digite o login: ");
		senha = Teclado.lerTexto("Digite a senha: ");
		if (clienteGlobal != null) {
			logado = clienteGlobal.validarLogin(login, senha);
			if (logado) {
				System.out.println("Login efetuado com sucesso!");

			} else {
				System.out.println("Login ou Senha inv�lido.");
			}
		}
		
	}

	public void cadastrarUsuario() {
		System.out.println("===========================================");
		System.out.println("      InfoNote - Cadastro de Usu�rios.    ");
		System.out.println("===========================================");

		// Contemplando a parte do Usu�rio
		String login = Teclado.lerTexto("Login: ");
		String senha = Teclado.lerTexto("Senha: ");
		int tipo = 1;
		// Contemplando a parte do Cliente
		String codigoCliente = Teclado.lerTexto("Codigo Cliente: ");
		String nome = Teclado.lerTexto("Nome: ");
		String email = Teclado.lerTexto("E-mail: ");
		// Contemplando o Endere�o
		String telefone = Teclado.lerTexto("Telefone: ");
		String logradouro = Teclado.lerTexto("Logradouro: ");
		String numero = Teclado.lerTexto("N�mero: ");
		String complemento = Teclado.lerTexto("Complemento: ");
		String bairro = Teclado.lerTexto("Bairro: ");
		String cidade = Teclado.lerTexto("Cidade: ");
		String estado = Teclado.lerTexto("Estado: ");
		String cep = Teclado.lerTexto("CEP: ");

		if (senha.equals("") || senha == null) {
			senha = GerarSenha.gerarSenha();
			System.out.println("Senha gerada: " + senha);
		}

		Endereco endereco = new Endereco(logradouro, numero, complemento, bairro, cidade, estado, cep);

		Cliente cliente = new Cliente(login, senha, tipo, codigoCliente, nome, email, telefone, endereco);
		clienteGlobal = cliente;

		System.out.println("===========================================");
		System.out.println("      Usu�rio Cadastrado com Sucesso!     ");
		System.out.println("===========================================");
		System.out.println(cliente);
		System.out.println(endereco);

	}

	public void buscarNotebook() {
		for (int i = 0; i < notebooks.length; i++) {
			if (notebooks[i] != null) {
				System.out.println(notebooks[i].getSerialNote() + "--------" + notebooks[i].getModelo());
			}
		}
	}

	public void manterCarrinho() {
		System.out.println("manterCarrinho - Em Constru��o");

	}

	public void inserirNotebook() {
		String numeroNote = Teclado.lerTexto("Informe o n�mero do notebook" + " para compra: ");

		if (pedido == null) {
			pedido = new Pedido();
		}

		Notebook aux = null;
		for (int i = 0; i < notebooks.length; i++) {
			if (notebooks[i] != null && numeroNote.equals(notebooks[i].getSerialNote())) {
				aux = notebooks[i];
			}
		}

		if (aux == null) {
			return;
		}

		ItemDePedido item = new ItemDePedido(1, aux.getPrecoUnitario(), aux);

		pedido.inserirItem(item);
	}

	public void efetuarCompra() {
		System.out.println("efetuarCompra - Em Constru��o");

	}
	
	public void ajuda(){
		System.out.println(ajuda.getTexto());
		}

}
