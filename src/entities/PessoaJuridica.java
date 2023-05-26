package entities;

public class PessoaJuridica extends Pessoa {

	private Integer numFuncionarios;

	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String nome, Double rendaAnual, Integer numFuncionarios) {
		super(nome, rendaAnual);
		this.numFuncionarios = numFuncionarios;
	}

	public Integer getNumFuncionarios() {
		return numFuncionarios;
	}

	public void setNumFuncionarios(Integer numFuncionarios) {
		this.numFuncionarios = numFuncionarios;
	}

	@Override
	public Double calcImposto() {
		if (getNumFuncionarios() > 10) {
			return 0.14 * getRendaAnual();
		} else {
			return 0.16 * getRendaAnual();
		}
	}

}
