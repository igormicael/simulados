package br.com.im.simulados.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.im.simulados.dto.RespostaDTO;
import br.com.im.simulados.dto.parser.RespostaParser;
import br.com.im.simulados.model.Alternativa;
import br.com.im.simulados.model.Questao;
import br.com.im.simulados.service.AlunoRespostaService;
import br.com.im.simulados.service.QuestaoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/questoes")
public class QuestaoController {

  @Autowired
  private QuestaoService service;

  @Autowired
  private AlunoRespostaService alunoRespostaService;

  @GetMapping()
  public List<Questao> findAll() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  public Questao findById(@PathVariable("id") Long id) {
    return service.findById(id);
  }

  @GetMapping("/{id}/alternativas")
  public List<Alternativa> findAlternativasById(@PathVariable("id") Long id) {
    return service.findAlternativasById(id);
  }

  @PostMapping("/{id}/responder")
  public ResponseEntity<Questao> responderQuestao(@PathVariable("id") Long id, @Valid @RequestBody RespostaDTO resposta) {
	  
    alunoRespostaService.save((new RespostaParser()).getFromDTO(resposta));

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{id}")
  @ApiOperation(value = "Exclui uma questão", notes = "Exclui uma questão")
  @ApiResponses({ @ApiResponse(code = 204, message = "Exclusão com sucesso de uma questão") })
  public void deleteById(@PathVariable("id") Long id) {
    service.deleteById(id);
  }

}
