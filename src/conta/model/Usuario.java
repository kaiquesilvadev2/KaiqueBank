package conta.model;

import java.util.ArrayList;

public class Usuario {

	private Long id;
	private String nomeCompleto;
	private String emailLogin;
	private String cpf;
	private String senha;
	private ArrayList<Cargo> cargosd = new ArrayList<>();

	public Usuario() {
	}

	public Usuario(Long id, String nomeCompleto, String emailLogin, String cpf, String senha,
			ArrayList<Cargo> cargosd) {
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.emailLogin = emailLogin;
		this.cpf = cpf;
		this.senha = senha;
		this.cargosd = cargosd;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmailLogin() {
		return emailLogin;
	}

	public void setEmailLogin(String emailLogin) {
		this.emailLogin = emailLogin;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public ArrayList<Cargo> getCargosd() {
		return cargosd;
	}

	public void setCargosd(ArrayList<Cargo> cargosd) {
		this.cargosd = cargosd;
	}
}
