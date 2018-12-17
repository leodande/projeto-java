package model;

public class Funcionario extends Usuario implements IUsuario {

	@Override
	public boolean validarLogin(String login, String senha) {
		if(getLogin().equals(login) && getSenha().equals(senha)) {
			return true;
		}
		return false;
	}

	private String matricula;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Funcionario() {
		super();
	}

	public Funcionario(String login, String senha, int tipo, String matricula) {
		super(login, senha, tipo);
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Funcionario [matricula=" + matricula + ", login=" + login + ", senha=" + senha + ", tipo=" + tipo
				+ ", getMatricula()=" + getMatricula() + ", getLogin()=" + getLogin() + ", getSenha()=" + getSenha()
				+ ", getTipo()=" + getTipo() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
}
