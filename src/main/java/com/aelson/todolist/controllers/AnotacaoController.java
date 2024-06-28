package com.aelson.todolist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aelson.todolist.helpers.AnotacaoRequest;
import com.aelson.todolist.helpers.AnotacaoResponse;
import com.aelson.todolist.services.AnotacaoService;

@Controller
@RequestMapping("anotacoes")
public class AnotacaoController {
    

    @Autowired
    private AnotacaoService anotacaoService;

    @GetMapping("criar")
    public ResponseEntity<AnotacaoResponse> criarAnotacao(AnotacaoRequest request){
        AnotacaoResponse response = this.anotacaoService.criar(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("{tarefaid}")
    public ResponseEntity<List<AnotacaoResponse>> pegarResponse(@PathVariable(value = "tarefa") Long id){
        
        List<AnotacaoResponse> responses = this.anotacaoService.buscarPorTarefa(id);

        return ResponseEntity.status(HttpStatus.OK).body(responses);


    }
}
