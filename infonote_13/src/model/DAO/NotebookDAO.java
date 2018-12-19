package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


import model.Notebook;
import util.Conexao;

public class NotebookDAO {
		
	public static Notebook inserir(String nome, String email, String mensagem) {
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
			comando.setString(1, nome);
			comando.setString(2, email);
			comando.setString(3, mensagem);
			
			// Comando executado
			comando.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		notebook = new notebook(nome, email, mensagem);
		return notebook;
	}
	
	public static Notebook[] buscarTodos() {
		Notebook[] notebook = null;

		try {

			String sql = "Select * from contato";

			Conexao conex = new Conexao("jdbc:mysql://localhost:3306/18_conexaobd?useTimezone=true&serverTimezone=UTC",
					"com.mysql.jbdc.Driver", "root", "alunolab");

			Connection con = conex.obterConexao();

			Statement comando = con.createStatement();

			ResultSet rs = comando.executeQuery(sql);

			notebook = new Notebook[10];

			int i = 0;

			while (rs.next()) {
				notebook[i++] = new Notebook(rs.getInt("Id"), rs.getString("nome"), rs.getString("email"),
						rs.getString("mensagem"));
			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return notebook;
	}
	
	public static Notebook excluir(String nome, String email, String mensagem) {
		Notebook notebook = null;
		try {

			String sql = "delete from contato where id = ?";

			Conexao conex = new Conexao("jdbc:mysql://localhost:3306/18_conexaobd?useTimezone=true&serverTimezone=UTC",
					"com.mysql.jbdc.Driver", "root", "alunolab");

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, nome);
			comando.setString(2, email);
			comando.setString(3, mensagem);

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
