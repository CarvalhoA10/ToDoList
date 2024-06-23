package com.aelson.todolist.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aelson.todolist.models.Tarefas;

@Controller
@RequestMapping("tarefas")
public class TarefaController {
    
    @GetMapping("")
    public ResponseEntity<Tarefas> listarTodas(){

        
    }


}
