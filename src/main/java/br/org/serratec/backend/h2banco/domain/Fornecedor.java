package br.org.serratec.backend.h2banco.domain;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

//diz que a classe é pai e vai ser herdada
///MappedSuperclass

//cria uma tabela fornecedor juntando as que herdam de fornecedor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//cria uma coluna que diz de qual classe veio o dado (PF/ PJ)
@DiscriminatorColumn(name = "DTYPE")
@Entity
public class Fornecedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50)
	@NotBlank(message = "Nome da pessoa deve ser preenchido")
	@Size(min = 2, max = 50, message = "Nome da pessoa deve ter entre {min} e {max} letras")
	private String nome;
	
	@Column
	private String email;

	@Column
	private String telefone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
