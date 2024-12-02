package med.voll.api.model;

import jakarta.validation.Valid;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record Medicos(
		@NotBlank
		String nome,
		@NotBlank
		@Email
		String email,
		@NotBlank
		@Pattern(regexp="\\d{4,6}")
		String crm,
		@NotNull
		Especialidade  especialidade,
		@NotNull
		@Valid
		Endereco endereco) {}

/*
  As strings não podem serem vazias.
  email terá que ter formato padrão de email.
  @Pattern(regexp="\\d{4,6}") indica somente números e quantidade de 4 a 6.
  Os objetos não podem serem nulos.
  @valid indica que é necessário aplicar validação dentro do objeto.
 */
