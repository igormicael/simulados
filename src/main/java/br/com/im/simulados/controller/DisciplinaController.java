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

import br.com.im.simulados.model.Disciplina;
import br.com.im.simulados.service.DisciplinaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

  @Autowired
  private DisciplinaService service;

  @GetMapping()
  @ApiOperation(value = "Lista todos os Disciplinas", notes = "Lista todos os Disciplinas", response = Disciplina.class, responseContainer = "List")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Disciplinas listados com sucesso"),
      @ApiResponse(code = 401, message = "Você não tem autorização para visualizar esse recurso"),
      @ApiResponse(code = 403, message = "Acessar o recurso que você estava tentando acessar é proibido"),
      @ApiResponse(code = 404, message = "O recurso que você está tentando acessar não foi encontrado") })
  public List<Disciplina> findAll() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  public Disciplina findById(@PathVariable("id") Long id) {
    return service.findById(id);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{id}")
  @ApiOperation(value = "Exclui um Disciplina", notes = "Exclui um Disciplina")
  @ApiResponses({ @ApiResponse(code = 204, message = "Exclusão com sucesso de um Disciplina") })
  public void deleteById(@PathVariable("id") Long id) {
    service.deleteById(id);
  }

  @PostMapping
  public void save(@RequestBody Disciplina disciplina) {
    service.save(disciplina);
  }

  @PutMapping
  public void update(@RequestBody Disciplina disciplina) {
    service.update(disciplina);
  }
}
