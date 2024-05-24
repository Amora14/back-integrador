package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "campo vazio")
	private String nome;

	//@NotBlank(message = "campo vazio")
	private String entrada;
	
	private Long cpf;
	
	private Long rg;
	
	private Long telefone;
	
	private String profissao;
	
	private String email;
	
	private String nascimento;

	@OneToMany(mappedBy = "cliente")	
	@JsonIgnoreProperties("cliente")
	private List<Contrato> contratos;
	
	@OneToOne
	@JsonIgnoreProperties("cliente") 
	private Apartamento ap;
	
	//getters e setters
//--------------------------------------------------------------------
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEntrada() {
		return entrada;
	}
	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}
	
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
	    if(cpf < 0){
	      throw new IllegalArgumentException("cpf não pode ser número negativo");
	    }
		this.cpf = cpf;
	}
	
	public Long getRg() {
		return rg;
	}
	public void setRg(long rg) { 
	    if(rg < 0){
	      throw new IllegalArgumentException("rg não pode ser número negativo");
	    }
			this.rg = rg;
		}
	
	public Long getTelefone() {
		return telefone;
	}
	public void setTelefone(long telefone) {
	    if(telefone < 0){
	      throw new IllegalArgumentException("telefone não pode ser número negativo");
	    }
			this.telefone = telefone;
		}
	
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Apartamento getAp() {
		return ap;
	}
	public void setAp(Apartamento ap) {
		this.ap = ap;
	}
	
	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	
	public List<Contrato> getContratos() {
		return contratos;
	}
	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}
	
}

