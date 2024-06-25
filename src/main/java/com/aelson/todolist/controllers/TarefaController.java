package com.aelson.todolist.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aelson.todolist.models.Tarefa;

@Controller
@RequestMapping("tarefas")
public class TarefaController {
    
    @GetMapping("")
    public ResponseEntity<Tarefa> listarTodas(){
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
