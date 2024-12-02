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
	@Column(unique = true)
	private String nome;
	@Column(unique = true)
	private String email;
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
		this.crm = medico.crm();
		this.especialidade = medico.especialidade();
		this.endereco = new Enderecos(medico.endereco());
	}
}


