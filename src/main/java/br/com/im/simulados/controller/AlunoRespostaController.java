package br.com.im.simulados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.im.simulados.model.AlunoResposta;
import br.com.im.simulados.service.AlunoRespostaService;

@RestController
@RequestMapping("/respostas-aluno")
public class AlunoRespostaController {

  @Autowired
  private AlunoRespostaService service;

  // RN-03-2
  @PostMapping()
  public void responder(@RequestBody AlunoResposta alunoResposta) {
    service.save(alunoResposta);
    /*
     * { "id": null, "aluno": 1, "simulado": 1, "prova": 1, "questao": 1
     * "alternativa": "1" }
     */
  }

}