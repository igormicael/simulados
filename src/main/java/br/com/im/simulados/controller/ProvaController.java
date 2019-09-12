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

import br.com.im.simulados.model.Prova;
import br.com.im.simulados.service.ProvaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/provas")
public class ProvaController {

  @Autowired
  private ProvaService service;

  @GetMapping()
  @ApiOperation(value = "Lista todos os Provas", notes = "Lista todos os Provas", response = Prova.class, responseContainer = "List")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Provas listados com sucesso"),
      @ApiResponse(code = 401, message = "Você não tem autorização para visualizar esse recurso"),
      @ApiResponse(code = 403, message = "Acessar o recurso que você estava tentando acessar é proibido"),
      @ApiResponse(code = 404, message = "O recurso que você está tentando acessar não foi encontrado") })
  public List<Prova> findAll() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  public Prova findById(@PathVariable("id") Long id) {
    return service.findById(id);
  }

  // RN-02
  @GetMapping("/{id}/gabarito")
  public Prova findGabaritoBy(@PathVariable("id") Long id) {
    return service.findGabaritoById(id);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{id}")
  @ApiOperation(value = "Exclui um Prova", notes = "Exclui um Prova")
  @ApiResponses({ @ApiResponse(code = 204, message = "Exclusão com sucesso de um Prova") })
  public void deleteById(@PathVariable("id") Long id) {
    service.deleteById(id);
  }

  @PostMapping
  public void save(@RequestBody Prova Prova) {
    service.save(Prova);
  }

  @PutMapping
  public void update(@RequestBody Prova Prova) {
    service.update(Prova);
  }

}
