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

import com.aelson.todolist.helpers.FuncionarioRequest;
import com.aelson.todolist.helpers.FuncionarioResponse;
import com.aelson.todolist.services.FuncionarioService;

@Controller
@RequestMapping("funcionarios")
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("")
    public ResponseEntity<List<FuncionarioResponse>> listarTodos(){

        List<FuncionarioResponse> responses = this.funcionarioService.listarTodos();
        
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responses);
    }

    @GetMapping("{id}")
    public ResponseEntity<FuncionarioResponse> listarPorId(@RequestParam(name = "id") Long id){
        FuncionarioResponse response = this.funcionarioService.encontrarPorId(id);

        if(response == null){
            response = new FuncionarioResponse();
            response.setCargo("Funcionario não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("criar")
    public ResponseEntity<FuncionarioResponse> criarFuncionario(@RequestBody FuncionarioRequest request){

        FuncionarioResponse response = this.funcionarioService.criar(request);

        if(response.getCargo() == null){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("atualizar")
    public ResponseEntity<FuncionarioResponse> atualizarFuncionario(@RequestBody FuncionarioRequest request){

        FuncionarioResponse response = this.funcionarioService.atualizar(request);

        if(response == null){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new FuncionarioResponse());
        }

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<FuncionarioResponse> deletarFuncionario(@RequestParam(name = "id") Long id){

        FuncionarioResponse response = this.funcionarioService.deletar(id);

        if(response == null){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new FuncionarioResponse());
        }

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
}
