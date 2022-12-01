package med.voll.api.Domain.Core;

import lombok.NoArgsConstructor;
import med.voll.api.Domain.EntitesJPA.Medico.EntiteMedico;
import med.voll.api.Domain.Enums.EnumEspecialidade;
import org.jetbrains.annotations.NotNull;


public record DadosListagemMedico(long id,String nome, String email, String crm, EnumEspecialidade especialidade) {

    public DadosListagemMedico(@NotNull EntiteMedico medico){
        this(medico.getId(), medico.getNome(),medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
