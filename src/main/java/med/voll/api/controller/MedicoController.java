package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.Domain.Application.IMedicoRepository;
import med.voll.api.Domain.Core.RequestAtualizarCadastroMedico;
import med.voll.api.Domain.Core.RequestCadastroMedico;
import med.voll.api.Domain.Core.DadosListagemMedico;
import med.voll.api.Domain.EntitesJPA.Medico.EntiteMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {
    @Autowired
    private IMedicoRepository _repository;


    @PostMapping
    @Transactional
    @RequestMapping("/cadastro")
    public String CadastroMedico(@RequestHeader String ChaveIdepotencia, @RequestBody @Valid RequestCadastroMedico request){

        _repository.save(new EntiteMedico(request));
        return "Cadastrado com Sucesso";

    }
    @GetMapping
    @RequestMapping("/consulta")
    public Page<DadosListagemMedico> ConsultaMedico(@PageableDefault(sort = {"id"}) Pageable paginacao){
        return _repository.findAll(paginacao).map(DadosListagemMedico::new);
    }

    @PostMapping
    @Transactional
    @RequestMapping("/atualizar")
    public String Atualizarcadastro(@RequestBody @Valid RequestAtualizarCadastroMedico request){
        var medico = _repository.getReferenceById(request.id());
        medico.atualizaDadosCadastrais(request);
        return "Lista Atualizada com suecsso";
    }

}
