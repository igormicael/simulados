package br.com.im.simulados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.im.simulados.model.Simulado;
import br.com.im.simulados.service.SimuladoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/simuladores")
public class SimuladoController {

  @Autowired
  private SimuladoService service;

  @GetMapping()
  @ApiOperation(value = "Lista todos os Simulados", notes = "Lista todos os Simulados", response = Simulado.class, responseContainer = "List")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Simulados listados com sucesso"),
      @ApiResponse(code = 401, message = "Você não tem autorização para visualizar esse recurso"),
      @ApiResponse(code = 403, message = "Acessar o recurso que você estava tentando acessar é proibido"),
      @ApiResponse(code = 404, message = "O recurso que você está tentando acessar não foi encontrado") })
  public List<Simulado> findAll() {
    System.out.println("aqui");
    return service.findAll();
  }

  @GetMapping("/{id}")
  public Simulado findById(@PathVariable("id") Long id) {
    return service.findById(id);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{id}")
  @ApiOperation(value = "Exclui um Simulado", notes = "Exclui um Simulado")
  @ApiResponses({ @ApiResponse(code = 204, message = "Exclusão com sucesso de um Simulado") })
  public void deleteById(@PathVariable("id") Long id) {
    service.deleteById(id);
  }

  @PostMapping
  public void save(@RequestBody Simulado Simulado) {
    service.save(Simulado);
  }

  @PutMapping
  public void update(@RequestBody Simulado Simulado) {
    service.update(Simulado);
  }

}
