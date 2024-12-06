package med.voll.api.model.DB;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.model.DadosAtualizarMedico;
import med.voll.api.model.Endereco;
import med.voll.api.model.Enderecos;
import med.voll.api.model.Especialidade;
import med.voll.api.model.Medicos;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of ="id")
@Entity
@Table(name="medicos")
@Getter
public class MedicoDB {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Setter
	private Boolean ativado;
	@Column(unique = true)
	private String nome;
	@Column(unique = true)
	private String email;	
	private String telefone;
	@Column(unique = true)
	private String crm;
	@Enumerated(EnumType.STRING)
	private Especialidade especialidade;
	@Embedded
	private Enderecos endereco;		
	
	public MedicoDB(Medicos medico) {
		super();		
		this.nome = medico.nome();
		this.email = medico.email();
		this.telefone = medico.telefone();
		this.crm = medico.crm();
		this.especialidade = medico.especialidade();
		this.endereco = new Enderecos(medico.endereco());
		this.ativado = true;
	}

	
	public void atualizarMedico(DadosAtualizarMedico dados) {
		if(dados.nome() != null) this.nome = dados.nome();
		if(dados.telefone() != null) this.telefone = dados.telefone();
		
		if(dados.endereco() != null) {
			if(dados.endereco().logradouro() != null) this.endereco.setLogradouro(dados.endereco().logradouro());
			if(dados.endereco().bairro() != null) this.endereco.setBairro(dados.endereco().bairro());
			if(dados.endereco().cep() != null) this.endereco.setCep(dados.endereco().cep());
			if(dados.endereco().cidade() != null) this.endereco.setCidade(dados.endereco().cidade());
			if(dados.endereco().uf() != null) this.endereco.setUf(dados.endereco().uf());
			if(dados.endereco().numero() != null) this.endereco.setNumero(dados.endereco().numero());
			if(dados.endereco().complemento() != null) this.endereco.setComplemento(dados.endereco().complemento());
				
			/*	
			if(endereco.cep() != null) this.cep = endereco.cep();
			if(endereco.cidade() != null) this.cidade= endereco.uf();
			if(endereco.uf() != null) this.uf = endereco.uf();
			this.numero = endereco.numero();
			this.complemento = endereco.complemento();
			this.endereco = new Enderecos(dados.endereco());
			System.out.println("\n"+this.endereco+"\n");
			*/
		}
	}


	@Override
	public String toString() {
		return "MedicoDB [id=" + id + ", ativado=" + ativado + ", nome=" + nome + ", email=" + email + ", telefone="
				+ telefone + ", crm=" + crm + ", especialidade=" + especialidade + ", endereco=" + endereco + "]";
	}	
	
}


