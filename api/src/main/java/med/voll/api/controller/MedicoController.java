package med.voll.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.Getter;
import med.voll.api.model.DadosAtualizarMedico;
import med.voll.api.model.DadosDaListagem;
import med.voll.api.model.Medicos;
import med.voll.api.model.DB.IMedicoDBRepository;
import med.voll.api.model.DB.MedicoDB;

@RestController
@RequestMapping("/medico")
@Getter
public class MedicoController {
	
	@Autowired  
	private IMedicoDBRepository repository;
	
	@PostMapping
	@Transactional
	public void InserirDados(@RequestBody @Valid Medicos dadosRecebidos){
				repository.save(new MedicoDB(dadosRecebidos));
	}	
	
	@GetMapping("/listagem")
	public List<DadosDaListagem> listar(){
		return repository.findAll().stream().map(e -> new DadosDaListagem(e)).toList();
	}
	
	@GetMapping("/lista_paginada")  // Mostrar de 10 em 10 páginas e ordena pelo nome.
	public Page<DadosDaListagem> 
	listaPaginada( @PageableDefault(size=10, sort= {"nome"}) Pageable paginacao ) {		
		return repository.findAll(paginacao).map(DadosDaListagem::new);		
	}	

	@PutMapping(value="/atualizar")	
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizarMedico dados,
			@RequestParam(value="recuperar/id",defaultValue = "0") Long id) {
		
		if(id == 0) {
			MedicoDB medico = repository.getReferenceById(dados.id());
			medico.atualizarMedico(dados);		
		} else {
			MedicoDB medico = repository.getReferenceById(id);
			medico.setAtivado(true);
		}		
	}
	
	@DeleteMapping("/apagar/{id}")
	@Transactional
	public void apagar(@PathVariable Long id) {
		MedicoDB medico = repository.getReferenceById(id);
		medico.setAtivado(false);
	}
	
	@PutMapping(value="/recuperar/{id}")
	@Transactional
	public void recuperar(@PathVariable Long id) {
		MedicoDB medico = repository.getReferenceById(id);
		medico.setAtivado(true);
	}
}

/*
System.out.println();
System.out.println(dadosRecebidos);
System.out.println();
System.out.println(new MedicoDB(dadosRecebidos));
System.out.println("\n");
*/
// repository.findAll().stream().map(DadosDaListagem::new).toList();
/*
@PostMapping
public void InserirDados(@RequestBody String dadosRecebidos){
	System.out.println(dadosRecebidos);
	//repository.save(dadosRecebidos);
}
*/
