 package med.voll.api.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Enderecos {
	private String logradouro;
	private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String numero;
    private String complemento;
    
   
    // Utilizado para inserção ou atualização de endereço.
	public Enderecos(Endereco endereco) {	
		super();		
		this.logradouro = endereco.logradouro();		
		this.bairro = endereco.bairro();	
		this.cep = endereco.cep();
		this.cidade= endereco.uf();
		this.uf = endereco.uf();
		this.numero = endereco.numero();
		this.complemento = endereco.complemento();		
	}

	@Override
	public String toString() {
		return "Enderecos [logradouro=" + logradouro + ", bairro=" + bairro + ", cep=" + cep + ", cidade=" + cidade
				+ ", uf=" + uf + ", numero=" + numero + ", complemento=" + complemento + "]";
	}	
	
	
}

/*
private Enderecos AtualizarEndereco(Endereco endereco) {
	if(endereco.logradouro() != null & endereco.bairro() != null)
		if(endereco.cep() != null & endereco.cidade() != null)
			if(endereco.uf() != null & endereco.numero() != null)
				if(endereco.complemento() != null) return new Enderecos(endereco);
	
	return null;
}
*/

/*
  		if(endereco.logradouro() != null) this.logradouro = endereco.logradouro();
		if(endereco.bairro() != null) this.bairro = endereco.bairro();
		if(endereco.cep() != null) this.cep = endereco.cep();
		if(endereco.cidade() != null) this.cidade= endereco.uf();
		if(endereco.uf() != null) this.uf = endereco.uf();
		if(endereco.numero() != null) this.numero = endereco.numero();
		if(endereco.complemento() != null) this.complemento = endereco.complemento();
		
		this.logradouro = endereco.logradouro();
		this.bairro = endereco.bairro();
		this.cep = endereco.cep();
		this.cidade = endereco.cidade();
		this.uf = endereco.uf();
		this.numero = endereco.numero();
		this.complemento = endereco.complemento();
 */
