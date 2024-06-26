package com.aelson.todolist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aelson.todolist.helpers.TarefaRequest;
import com.aelson.todolist.helpers.TarefaResponse;
import com.aelson.todolist.services.TarefaService;

@Controller
@RequestMapping("tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;
    
    @GetMapping("")
    public ResponseEntity<List<TarefaResponse>> listarTodas(){

        List<TarefaResponse> responses = this.tarefaService.buscarTodas();
        return ResponseEntity.status(HttpStatus.OK).body(responses);

    }

    @GetMapping("{id}")
    public ResponseEntity<TarefaResponse> listarPorId(@PathVariable(value = "id") Long id){
        TarefaResponse response = this.tarefaService.buscarPorId(id);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("criar")
    public ResponseEntity<TarefaResponse> criarTarefa(@RequestBody TarefaRequest dto){

        TarefaResponse response = this.tarefaService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @PutMapping("atualizar")
    public ResponseEntity<TarefaResponse> atualizarTarefa(@RequestBody TarefaRequest request){

        TarefaResponse response = this.tarefaService.atualizar(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<TarefaResponse> deletarTarefa(@PathVariable(value = "id") Long id){

        TarefaResponse response = this.tarefaService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

}
