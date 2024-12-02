package med.voll.api.model;

import med.voll.api.model.DB.MedicoDB;

public record DadosDaListagem(	
		String nome,		
		String email,	
		String crm,		
		Especialidade especialidade
		) {
	
	public DadosDaListagem(MedicoDB medico) {
		this(medico.getNome(), medico.getEmail(), medico.getCrm(), 
				medico.getEspecialidade());
	}
		
}
