package com.aelson.todolist.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aelson.todolist.helpers.StatusTarefa;
import com.aelson.todolist.helpers.TarefaRequest;
import com.aelson.todolist.helpers.TarefaResponse;
import com.aelson.todolist.models.Funcionario;
import com.aelson.todolist.models.Tarefa;
import com.aelson.todolist.repositories.TarefaRepository;

@Service
public class TarefaService {
    
    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private FuncionarioService funcionarioService;

    public TarefaResponse makeResponse(Tarefa tarefa){
        TarefaResponse response = new TarefaResponse();
        BeanUtils.copyProperties(tarefa, response);
        response.setIdFuncionario(tarefa.getFuncionario().getId());
        response.setNomeFuncionario(tarefa.getFuncionario().getNome());

        return response;
    }

    public TarefaResponse criar(TarefaRequest request){

        Tarefa tarefa = new Tarefa();
        Funcionario funcionario = this.funcionarioService.encontrarPorId(request.idFuncionario());

        BeanUtils.copyProperties(request, tarefa);
        tarefa.setFuncionario(funcionario);
        tarefa.setDataCriacao(LocalDateTime.now());
        tarefa.setDataAtualizacao(LocalDateTime.now());

        tarefa = this.tarefaRepository.save(tarefa);
        TarefaResponse response = this.makeResponse(tarefa);

        return response;

    }

    public List<TarefaResponse> buscarTodas(){
        List<Tarefa> tarefas = this.tarefaRepository.findAll();
        List<TarefaResponse> responses = new ArrayList<>();

        for (Tarefa tarefa : tarefas) {
            TarefaResponse response = makeResponse(tarefa);
            responses.add(response);
        }

        return responses;
    }

    public TarefaResponse buscarPorId(Long id){

        Tarefa tarefa = this.tarefaRepository.findById(id).get();
        TarefaResponse response = makeResponse(tarefa);

        return response;

    }

    public TarefaResponse atualizar(TarefaRequest request){

        Tarefa tarefa = this.tarefaRepository.findById(request.id()).get();
        tarefa.setStatus(StatusTarefa.valueOf(request.status()));
        tarefa.setDataAtualizacao(LocalDateTime.now());
        tarefa = this.tarefaRepository.save(tarefa);
        TarefaResponse response = this.makeResponse(tarefa);

        return response;

    }

    public TarefaResponse deletar(Long id){

        Tarefa tarefa = this.tarefaRepository.findById(id).get();
        this.tarefaRepository.delete(tarefa);
        TarefaResponse response = this.makeResponse(tarefa);
        return response;

    }

}
