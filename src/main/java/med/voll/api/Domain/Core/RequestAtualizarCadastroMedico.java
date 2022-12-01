package med.voll.api.Domain.Core;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.Domain.Enums.EnumEspecialidade;

public record RequestAtualizarCadastroMedico (

    @NotNull
        long id,
    String nome,
        String email,
        String telefone,
        DadosEndereco endereco
) {
}
