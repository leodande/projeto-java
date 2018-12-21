package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Notebook;
import util.Conexao;
import util.Configurador;

public class NotebookDAO {

	Configurador config = new Configurador();
	String url;
	String driver;
	String login;
	String senha;

	public NotebookDAO() {
		url = config.getUrl();
		driver = config.getDriver();
		login = config.getLogin();
		senha = config.getSenha();
	}

	public static Notebook inserir(String serialNote, String modelo, String descricao, int estoque,
			double precoUnitario, String figura, String dataCadastro) {

		Notebook notebook = null;
		NotebookDAO noteDAO = new NotebookDAO();
		try {

			// Criação do insert
			String sql = "insert into contato (nome, email, mensagem) values (?,?,?)";

			// comando.setString(1,mensagem);
			// comando.setInt(2,id);

			// Obter a conexão com o banco de dados
			Conexao conex = new Conexao(noteDAO.url, noteDAO.driver, noteDAO.login, noteDAO.senha);
			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, serialNote);
			comando.setString(2, modelo);
			comando.setString(3, descricao);
			comando.setInt(4, estoque);
			comando.setDouble(5, precoUnitario);
			comando.setString(6, figura);
			comando.setString(7, dataCadastro);

			// Comando executado
			comando.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		notebook = new Notebook(serialNote, modelo, descricao, estoque, precoUnitario, figura, dataCadastro);
		return notebook;
	}

	public static Notebook[] buscarTodos() {
		Notebook[] notebook = null;

		try {

			String sql = "Select * from notebook";

			Conexao conex = new Conexao("jdbc:mysql://localhost:3306/18_conexaobd?useTimezone=true&serverTimezone=UTC",
					"com.mysql.jbdc.Driver", "root", "alunolab");

			Connection con = conex.obterConexao();

			Statement comando = con.createStatement();

			ResultSet rs = comando.executeQuery(sql);

			notebook = new Notebook[10];

			int i = 0;

			while (rs.next()) {
				notebook[i++] = new Notebook(rs.getString("serialNote"), rs.getString("modelo"),
						rs.getString("descricao"), rs.getInt("estoque"), rs.getDouble("precoUnitario"),
						rs.getString("figura"), rs.getString("dataCadastro"));
			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return notebook;
	}

	public static Notebook excluir(String serialNote, String modelo, String descricao, int estoque,
			double precoUnitario, String figura, String dataCadastro) {
		Notebook notebook = null;
		try {

			String sql = "delete from contato where id = ?";

			Conexao conex = new Conexao("jdbc:mysql://localhost:3306/18_conexaobd?useTimezone=true&serverTimezone=UTC",
					"com.mysql.jbdc.Driver", "root", "alunolab");

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, serialNote);
			comando.setString(2, modelo);
			comando.setString(3, descricao);
			comando.setInt(4, estoque);
			comando.setDouble(5, precoUnitario);
			comando.setString(6, figura);
			comando.setString(7, dataCadastro);
			comando.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return notebook;

	}

	public static Notebook atualizar(String mensagem, int id) {
		Notebook notebook = null;
		try {
			// Criação do insert
			String sql = "update contato set mensagem = ? where id = ? ";
			// Obter a conexão com o banco de dados
			Conexao conex = new Conexao("jdbc:mysql://localhost:3306/conexaobd?useTimezone=true&serverTimezone=UTC",
					"com.mysql.jdbc.Driver", "jeffrey", "password");
			// Abrir a conexão
			Connection con = conex.obterConexao();
			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, mensagem);
			comando.setInt(2, id);
			// Comando executado
			comando.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return notebook;
	}

}
