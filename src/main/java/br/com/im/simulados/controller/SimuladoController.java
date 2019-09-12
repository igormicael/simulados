package br.com.im.simulados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.im.simulados.model.Alternativa;
import br.com.im.simulados.model.Simulado;
import br.com.im.simulados.service.SimuladoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/simulados")
public class SimuladoController {

  @Autowired
  private SimuladoService service;

  @GetMapping()
  @ApiOperation(value = "Lista todos os Simulados", notes = "Lista todos os Simulados", response = Simulado.class, responseContainer = "List")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Simulados listados com sucesso"),
      @ApiResponse(code = 401, message = "Você não tem autorização para visualizar esse recurso"),
      @ApiResponse(code = 403, message = "Acessar o recurso que você estava tentando acessar é proibido"),
      @ApiResponse(code = 404, message = "O recurso que você está tentando acessar não foi encontrado") })
  // RN-01
  public List<Simulado> findAll() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  public Simulado findById(@PathVariable("id") Long id) {
    return service.findById(id);
  }

  // RN-04
  @GetMapping("/{id}/ranking")
  public List<Simulado> ranking(@PathVariable("id") Long id) {
    return service.ranking(id);
  }

  // RN-03-1
  @GetMapping("/{idSimulado}/provas/{idProva}/questoes/{idQuestao}")
  public List<Alternativa> responder(@PathVariable("idSimulado") Long idSimulado, @PathVariable("idProva") Long idProva,
      @PathVariable("idQuestao") Long idQuestao) {
    return null; // service.ranking(id);
  }

}