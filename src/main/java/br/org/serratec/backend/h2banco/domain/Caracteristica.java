package br.org.serratec.backend.h2banco.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

//diz que essa classe pode ser integrada a outra
@Embeddable
public class Caracteristica {
	
	private String renavan;
	
	private String chassi;
	
	private Long ano;
	
	//cria um enum que recebe o tipo string
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	@Enumerated(EnumType.ORDINAL)
	private Combustivel combustivel;

	public String getRenavan() {
		return renavan;
	}

	public void setRenavan(String renavan) {
		this.renavan = renavan;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public Long getAno() {
		return ano;
	}

	public void setAno(Long ano) {
		this.ano = ano;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}
	
	
}
