package med.voll.api.Domain.Application;

import med.voll.api.Domain.EntitesJPA.Medico.EntiteMedico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicoRepository extends JpaRepository<EntiteMedico,Long> {
}
