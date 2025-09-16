package conta.model;

public class Cargo {

	private Long id;
	private String nomeCargo;

	public Cargo() {
	}

	public Cargo(Long id, String nomeCargo) {
		this.id = id;
		this.nomeCargo = nomeCargo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

}
