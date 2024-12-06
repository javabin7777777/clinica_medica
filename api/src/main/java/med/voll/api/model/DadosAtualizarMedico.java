package med.voll.api.model;

import jakarta.validation.constraints.NotNull;

/*
 Dados para serem atualizados(Enviados pelo cliente),
   conforme o id encontrado no banco de dados.  
 */
public record DadosAtualizarMedico(
		@NotNull Long id, String nome, String telefone, Endereco endereco) {}
