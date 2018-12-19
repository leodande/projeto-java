package controller;

import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;

import model.*;
import model.Notebook;
import model.Pedido;
import model.Usuario;
import model.DAO.ClienteDAO;
import model.DAO.EnderecoDAO;
import model.DAO.FuncionarioDAO;
import model.DAO.UsuarioDAO;
import util.Ajuda;
import util.Configurador;
import util.GerarSenha;
import util.Teclado;

public class InfoNote {

	Usuario usuario;
	Usuario user; // Não esquecer de dar o import neste objeto

	Notebook notebooks[] = new Notebook[10];

	Pedido pedido;

	private static Cliente clienteGlobal = null;
	@SuppressWarnings("unused")
	private static Funcionario funcionarioGlobal = null;

	private static final int AREA_ADMINISTRATIVA = 9;

	private static final int SAIR = 10;

	boolean logado = false; // Indica se o usuário esta logado.

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

	public static void main(String[] args) {

		InfoNote info = new InfoNote();

		int opcao = SAIR;

		do {

			info.mostrarMenu();
			opcao = Teclado.lerInt("Digite sua opção: ");

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

			case AREA_ADMINISTRATIVA:
				info.areaAdministrativa();
				break;

			case SAIR:
				System.out.println("Saída do Sistema.");
				break;

			default:
				System.out.println("Opção inválida!");
			}
			Teclado.lerTexto("Pressione uma tecla para continuar...");

		} while (opcao != SAIR);

	}

	public InfoNote() {
		// Cria objeto de configurações
		config = new Configurador();
		Locale.setDefault(new Locale(config.getIdioma(), config.getRegiao()));
		// Cria o objeto Ajuda
		ajuda = new Ajuda(config.getArquivoAjuda());

		// public Notebook(String serialNote, int numeroNote, String modelo, String
		// descricao, int estoque, double precoUnitario, String figura, String
		// dataCadastro)

		notebooks[0] = new Notebook("A1", 1, "Negativo N22BR", "CPU intel Core 2 Duo, Memória 2 GB, HD 250 GB", 6,
				1200.00, "img\\n22br.jpg", "19/05/2011");

		notebooks[1] = new Notebook("B22", 2, "Bell B55BR", "CPU intel I3, Memória 4 GB, HD 500 GB", 3, 1800.00,
				"img\\b55br.jpg", "20/05/2011");

		notebooks[2] = new Notebook("H02", 3, "Pompaq P41BR", "CPU intel I3, Memória 3 GB, HD 320 GB", 1, 1600.00,
				"img\\p41br.jpg", "21/05/2011");

		notebooks[3] = new Notebook("Z55", 4, "Negativo N22BR", "CPU intel Dual Core, Memória 2 GB, HD 160 GB", 5,
				1100.00, "img\\cr71ch.jpg", "10/05/2011");

		notebooks[4] = new Notebook("K20", 5, "Negativo N22BR", "CPU AMD Phenon II, Memória 4 GB, HD 500 GB", 2,
				1900.00, "img\\bd22br.jpg", "10/05/2011");

	}

	public void mostrarMenu() {
		System.out.println("=============================================");
		System.out.println("    InfoNote - Se não é Info não vendemos.  "
				+ DateFormat.getDateInstance(DateFormat.SHORT).format(new Date()) + " "
				+ DateFormat.getTimeInstance().format(new Date()));
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
		System.out.println("9 - Área Administrativa");
		System.out.println("10 - Sair");
	}

	public void efetuarLogin() {
		String login, senha;
		login = Teclado.lerTexto("Digite o login: ");
		senha = Teclado.lerTexto("Digite a senha: ");

		cliente = ClienteDAO.buscarPorLoginSenha(login, senha);

		if (cliente != null) {
			logado = cliente.validarLogin(login, senha);
		} else {
			if (logado) {
				System.out.println("Login efetuado com sucesso!");
			} else {
				System.out.println("Usuário ou Senha inválido.");

				int opcao2 = 3;
				do {
					System.out.println("Digite: ");
					System.out.println("1 - Para efetuar Login");
					System.out.println("2 - Para cadastrar-se");
					System.out.println("3 - Para sair do sistema");
					opcao2 = Teclado.lerInt("");

					switch (opcao2) {
					case 1:
						efetuarLogin();
						break;
					case 2:
						cadastrarUsuario();
						break;
					case 3:
						System.out.println("Obrigado e volte sempre!");
						break;
					default:
						System.out.println("Opção inválida");
					}
				} while (!logado);
			}
		}
	}

	public void cadastrarUsuario() {
		System.out.println("===========================================");
		System.out.println("      InfoNote - Cadastro de Usuários.    ");
		System.out.println("===========================================");

		// Contemplando a parte do Usuário
		String login = Teclado.lerTexto("Login: ");
		String senha = Teclado.lerTexto("Senha: ");
		int tipo = 0;
		// Contemplando a parte do Cliente
		String codigoCliente = Teclado.lerTexto("Codigo Cliente: ");
		String nome = Teclado.lerTexto("Nome: ");
		String email = Teclado.lerTexto("E-mail: ");
		// Contemplando o Endereço
		String telefone = Teclado.lerTexto("Telefone: ");
		String logradouro = Teclado.lerTexto("Logradouro: ");
		String numero = Teclado.lerTexto("Número: ");
		String complemento = Teclado.lerTexto("Complemento: ");
		String bairro = Teclado.lerTexto("Bairro: ");
		String cidade = Teclado.lerTexto("Cidade: ");
		String estado = Teclado.lerTexto("Estado: ");
		String cep = Teclado.lerTexto("CEP: ");

		if (senha.equals("") || senha == null) {
			senha = GerarSenha.gerarSenha();
			System.out.println("Senha gerada: " + senha);
		}

		usuario = UsuarioDAO.inserir(login, senha, tipo);
		cliente = ClienteDAO.inserir(login, senha, tipo, codigoCliente, nome, email, telefone);
		Endereco endereco = EnderecoDAO.inserir(logradouro, numero, complemento, bairro, cidade, estado, cep,
				codigoCliente);

		System.out.println("===========================================");
		System.out.println("      Usuário Cadastrado com Sucesso!     ");
		System.out.println("===========================================");
		System.out.println(cliente);
		System.out.println(endereco);

	}

	public void buscarNotebooks() {
		for (int i = 0; i < notebooks.length; i++) {
			if (notebooks[i] != null) {
				System.out.println(notebooks[i].getSerialNote() + "--------" + notebooks[i].getModelo());
			}
		}
	}

	public void manterCarrinho() {
		System.out.println("manterCarrinho - Em Construção");

	}

	public void inserirNotebook() {
		String numeroNote = Teclado.lerTexto("Informe o número do notebook" + " para compra: ");

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
		System.out.println("efetuarCompra - Em Construção");

	}

	public void ajuda() {
		System.out.println(ajuda.getTexto());
	}

	public void efetuarLoginAdm() {
		String login, senha;
		login = Teclado.lerTexto("Digite o login: ");
		senha = Teclado.lerTexto("Digite a senha: ");
		Funcionario funcionario = FuncionarioDAO.buscarPorLoginSenha(login, senha);

		if (funcionario != null) {
			logado = funcionario.validarLogin(login, senha);
		} else {
			if (logado) {
				System.out.println("Login efetuado com sucesso!");
			} else {
				System.out.println("Usuário ou senha inválido.");
			}
		}

	}
	
	public void cadastrarNotebooks() {
		for (int i = 0; i < notebooks.length; i++) {
			if (notebooks[i] != null) {
				System.out.println(notebooks[i].getSerialNote() + "--------" + notebooks[i].getModelo());
			}
		}
	}

	public void areaAdministrativa() {
		InfoNote info = new InfoNote();
		efetuarLoginAdm();
		System.out.println("Opções Administrativas\n");
		System.out.println("1 - Cadastrar Notebook");
		System.out.println("2 - Mostrar Notebooks");
		System.out.println("3 - Editar Notebook");
		System.out.println("4 - Excluir Notebook");
		System.out.println("5 - Sair");

		int opcao = 5;

		do {

			opcao = Teclado.lerInt("Digite sua opção: ");
			switch (opcao) {

			case 1:
				info.cadastrarNotebook();
				break;

			case 2:
				info.mostrarNotebooks();
				break;

			case 3:
				info.editarNotebook();
				break;

			case 4:
				info.excluirNotebook();
				break;

			case 5:
				System.out.println("Saída do Sistema");
				break;

			default:
				System.out.println("Opção inválida!");
			}

			Teclado.lerTexto("Pressione uma tecla para continuar...");
		} while (opcao != 5);
	}

	private void excluirNotebook() {
		// TODO Auto-generated method stub
		
	}

	private void editarNotebook() {
		// TODO Auto-generated method stub
		
	}

	private void mostrarNotebooks() {
		// TODO Auto-generated method stub
		
	}

	private void cadastrarNotebook() {
		// TODO Auto-generated method stub
		
	}

}
