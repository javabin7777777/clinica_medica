package draft;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.model.Enderecos;
import med.voll.api.model.Especialidade;
import med.voll.api.model.Medicos;


@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
class Medico {
	private String nome;
	private String email;
	private String crm;
	private Especialidade especialidade;
	private Enderecos  endereco;
	
	public Medico(Medicos medicos) {
		this.nome = medicos.nome();
		this.email = medicos.email();
		this.crm = medicos.crm();
		this.especialidade = medicos.especialidade();
		this.endereco = new Enderecos(medicos.endereco());
		//(this.medicos.nome(),this.medicos.email(),this.medicos.crm(),
		//this.medicos.especialidade().name(),this.medicos.endereco());
	}
}
