package med.voll.api.Domain.EntitesJPA.Medico;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.Domain.Core.DadosEndereco;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EntiteEndereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public EntiteEndereco(DadosEndereco endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
    }

    public void atualizarEndereco(DadosEndereco request) {
        if(request.logradouro() != null){
            this.logradouro = request.logradouro();
        }
        if(request.bairro() != null){
            this.bairro = request.bairro();
        }
        if(request.cep() != null){
            this.cep = request.cep();
        }
        if(request.numero() != null){
            this.numero = request.numero();
        }
        if(request.complemento() != null){
            this.complemento = request.complemento();
        }
        if(request.cidade() != null){
            this.cidade = request.cidade();
        }
        if(request.uf() != null){
            this.uf = request.uf();
        }
    }
}
