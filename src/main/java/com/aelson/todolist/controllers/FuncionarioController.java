package com.aelson.todolist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aelson.todolist.helpers.FuncionarioDto;
import com.aelson.todolist.models.Funcionario;
import com.aelson.todolist.services.FuncionarioService;

@Controller
@RequestMapping("funcionarios")
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("")
    public ResponseEntity<List<Funcionario>> listarTodos(){

        List<Funcionario> funcionarios = this.funcionarioService.listarTodos();
        
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(funcionarios);
    }

    @GetMapping("{id}")
    public ResponseEntity<Funcionario> listarPorId(@RequestParam(name = "id") Long id){
        Funcionario funcionario = this.funcionarioService.encontrarPorId(id);

        if(funcionario == null){
            funcionario = new Funcionario();
            funcionario.setCargo("Funcionario não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(funcionario);
    }

    @PostMapping("criar")
    public ResponseEntity<Funcionario> criarFuncionario(@RequestBody FuncionarioDto dto){

        Funcionario funcionario = this.funcionarioService.criar(dto);

        if(funcionario.getCargo() == null){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(funcionario);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(funcionario);
    }

    @PutMapping("atualizar")
    public ResponseEntity<?> atualizarFuncionario(@RequestBody FuncionarioDto dto){

        Funcionario funcionario = this.funcionarioService.atualizar(dto);

        if(funcionario == null){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Funcionário não pode ser encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(funcionario);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletarFuncionario(@RequestParam(name = "id") Long id){

        Funcionario funcionario = this.funcionarioService.deletar(id);

        if(funcionario == null){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Funcionário com este id não pode ser encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Funcionário deletado com sucesso");

    }
}
