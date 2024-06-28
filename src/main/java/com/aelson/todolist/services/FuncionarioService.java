package com.aelson.todolist.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aelson.todolist.helpers.FuncionarioRequest;
import com.aelson.todolist.helpers.FuncionarioResponse;
import com.aelson.todolist.models.Funcionario;
import com.aelson.todolist.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
    
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioResponse makeResponse(Funcionario funcionario){
        FuncionarioResponse response = new FuncionarioResponse();
        BeanUtils.copyProperties(funcionario, response);

        return response;
    }

    public Funcionario makeFuncionario(FuncionarioResponse response){
        Funcionario funcionario = new Funcionario();
        BeanUtils.copyProperties(response, funcionario);
        return funcionario;
    }

    public FuncionarioResponse criar(FuncionarioRequest request){        
            
        Funcionario funcionario = this.encontrarPorEmail(request.email());

        if(funcionario != null){
            funcionario.setCargo(null);
            funcionario.setEmail("Email já existente");
            return this.makeResponse(funcionario);
        }         

        funcionario = new Funcionario();
        BeanUtils.copyProperties(request, funcionario);

        funcionario.setDataRegistro(LocalDateTime.now());
        funcionario.setDataAtualizacao(LocalDateTime.now());

        funcionario = this.funcionarioRepository.save(funcionario);

        return this.makeResponse(funcionario);

    }

    public List<FuncionarioResponse> listarTodos(){
        List<Funcionario> funcionarios = this.funcionarioRepository.findAll();
        List<FuncionarioResponse> responses = new ArrayList<>();

        for (Funcionario funcionario : funcionarios) {
            responses.add(this.makeResponse(funcionario));
        }

        return responses;
    }

    public Funcionario encontrarPorEmail(String email){
            
        Funcionario funcionario = this.funcionarioRepository.findByEmail(email);
        if(funcionario == null){
            return null;
        }

        return funcionario;

    }

    public FuncionarioResponse encontrarPorId(Long id){

        Optional<Funcionario> funcionario = this.funcionarioRepository.findById(id);
        if(funcionario.isEmpty()){
            return new FuncionarioResponse();
        }

        return this.makeResponse(funcionario.get());

    }

    public FuncionarioResponse atualizar(FuncionarioRequest request){

        Funcionario funcionario = this.makeFuncionario(this.encontrarPorId(request.id()));

        if(funcionario == null){
            return new FuncionarioResponse();
        }

        funcionario.setCargo(request.cargo());
        funcionario.setEmail(request.email());
        funcionario.setNome(request.nome());

        funcionario.setDataAtualizacao(LocalDateTime.now());

        funcionario = this.funcionarioRepository.save(funcionario);

        return this.makeResponse(funcionario);
    }

    public FuncionarioResponse deletar(Long id){

        Funcionario funcionario = this.makeFuncionario(this.encontrarPorId(id));
        this.funcionarioRepository.delete(funcionario);

        return this.makeResponse(funcionario);

    }

}
