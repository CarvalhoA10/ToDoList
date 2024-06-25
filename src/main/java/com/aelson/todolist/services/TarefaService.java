package com.aelson.todolist.services;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aelson.todolist.helpers.StatusTarefa;
import com.aelson.todolist.helpers.TarefaDto;
import com.aelson.todolist.models.Funcionario;
import com.aelson.todolist.models.Tarefa;
import com.aelson.todolist.repositories.TarefaRepository;

@Service
public class TarefaService {
    
    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private FuncionarioService funcionarioService;

    public Tarefa criar(TarefaDto dto){

        Tarefa tarefa = new Tarefa();
        Funcionario funcionario = this.funcionarioService.encontrarPorId(dto.idFuncionario());

        BeanUtils.copyProperties(dto, tarefa);
        tarefa.setFuncionario(funcionario);
        tarefa.setDataCriacao(LocalDateTime.now());
        tarefa.setDataAtualizacao(LocalDateTime.now());

        return this.tarefaRepository.save(tarefa);

    }

    public Tarefa buscarPorId(Long id){
        
        Tarefa tarefa = this.tarefaRepository.findById(id).get();
        return tarefa;

    }

    public Tarefa atualizar(TarefaDto dto){

        Tarefa tarefa = this.buscarPorId(dto.id());
        tarefa.setStatus(StatusTarefa.valueOf(dto.status()));
        tarefa.setDataAtualizacao(LocalDateTime.now());

        return this.tarefaRepository.save(tarefa);

    }

    public Tarefa deletar(Long id){

        Tarefa tarefa = this.buscarPorId(id);
        this.tarefaRepository.delete(tarefa);
        return tarefa;

    }


}
