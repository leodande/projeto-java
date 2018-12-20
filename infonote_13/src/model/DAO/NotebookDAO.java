package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


import model.Notebook;
import util.Conexao;

public class NotebookDAO {
		
	public static Notebook inserir(String serialNote, String modelo, String descricao, String estoque, String precoUnitario, String figura, String dataCadastro) {
		Notebook notebook = null;
		try {
			
			// Criação do insert
			String sql = "insert into contato (nome, email, mensagem) values (?,?,?)";
			
			//comando.setString(1,mensagem);
			//comando.setInt(2,id);
			
			// Obter a conexão com o banco de dados
			Conexao conex = new Conexao("jdbc:mysql://localhost:3306/18_conexaobd", "com.mysql.jdbc.Driver", "root",
					"alunolab");
			
			// Abrir a conexão
			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, serialNote);
			comando.setString(2, modelo);
			comando.setString(3, descricao);
			comando.setString(4, estoque);
			comando.setString(5, precoUnitario);
			comando.setString(6, figura);
			comando.setString(7, dataCadastro);
			
			// Comando executado
			comando.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		notebook = new notebook(serialNote, modelo, descricao, estoque, precoUnitario, figura, dataCadastro);
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
				notebook[i++] = new Notebooks(rs.setInt("serialNote"), rs.setString("modelo"), rs.setString("descricao"),
						rs.setString("estoque"), rs.setString("precoUnitario"), rs.setString("figura"), rs.setString("dataCadastro"));
			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return notebook;
	}
	
	public static Notebook excluir(String serialNote, String modelo, String descricao, String estoque, String precoUnitario, String figura, String dataCadastro) {
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
			comando.setString(4, estoque);
			comando.setString(5, precoUnitario);
			comando.setString(6, figura);
			comando.setString(7, dataCadastro);
			comando.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return notebook;

	}
	
	public static Notebook atualizar(String mensagem, int id){
		Notebook notebook = null;
		try {
			// Criação do insert
			String sql = "update contato set mensagem = ? where id = ? ";
			// Obter a conexão com o banco de dados
			Conexao conex = new Conexao("jdbc:mysql://localhost:3306/conexaobd?useTimezone=true&serverTimezone=UTC", "com.mysql.jdbc.Driver", "jeffrey","password");			
			// Abrir a conexão
			Connection con = conex.obterConexao();
			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1,mensagem);
			comando.setInt(2,id);
			// Comando executado
			comando.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return notebook;
	}	

	
}
