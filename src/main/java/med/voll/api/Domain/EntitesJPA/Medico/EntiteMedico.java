package med.voll.api.Domain.EntitesJPA.Medico;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.Domain.Core.RequestAtualizarCadastroMedico;
import med.voll.api.Domain.Core.RequestCadastroMedico;
import med.voll.api.Domain.Enums.EnumEspecialidade;
@Table(name = "Medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class EntiteMedico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private EnumEspecialidade especialidade;
    @Embedded
    private EntiteEndereco endereco;

    public EntiteMedico(RequestCadastroMedico request) {
        this.nome = request.nome();
        this.email = request.email();
        this.telefone = request.telefone();
        this.crm = request.crm();
        this.especialidade = request.especialidade();
        this.endereco = new EntiteEndereco(request.endereco());
    }

    public void atualizaDadosCadastrais(RequestAtualizarCadastroMedico request) {
            if(request.nome() != null){
                this.nome = request.nome();
            }
        if(request.telefone() != null){
            this.telefone = request.telefone();
        }
        if(request.endereco() != null){
            this.endereco.atualizarEndereco(request.endereco());
        }
    }
}
