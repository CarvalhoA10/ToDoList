package com.aelson.todolist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aelson.todolist.helpers.FuncionarioDto;
import com.aelson.todolist.models.Funcionario;
import com.aelson.todolist.services.FuncionarioService;

@Controller
@RequestMapping("funcionarios")
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("criar")
    public ResponseEntity<Funcionario> criarFuncionario(@RequestBody FuncionarioDto dto){

        Funcionario funcionario = this.funcionarioService.criar(dto);

        if(funcionario.getCargo() == null){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(funcionario);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(funcionario);
    }
}
