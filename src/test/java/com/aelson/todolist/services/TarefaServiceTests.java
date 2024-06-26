package com.aelson.todolist.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;

import com.aelson.todolist.helpers.TarefaResponse;
import com.aelson.todolist.models.Funcionario;
import com.aelson.todolist.models.Tarefa;
import com.aelson.todolist.repositories.TarefaRepository;

@ExtendWith(MockitoExtension.class)
public class TarefaServiceTests {
    
    @InjectMocks
    TarefaService tarefaService;

    @Mock
    TarefaRepository tarefaRepository;

    Tarefa tarefa;
    List<Tarefa> tarefas;

    TarefaResponse tarefaResponse;

    @BeforeEach
    public void setup(){

        tarefa = new Tarefa();
        tarefa.setId(1L);
        tarefa.setFuncionario(new Funcionario());
        tarefa.setAnotacoes(new ArrayList<>());
        tarefa.setNome("Tarefa");
        tarefa.setDescricao("Uma descrição");

        tarefaResponse = new TarefaResponse();

        BeanUtils.copyProperties(tarefa, tarefaResponse);
        tarefaResponse.setIdFuncionario(tarefa.getId());
        tarefaResponse.setNomeFuncionario(tarefa.getNome());

        tarefas = new ArrayList<>();
    }

    @Test
    public void deve_converter_uma_tarefa_em_uma_tarefaResponse(){
        TarefaResponse response = this.tarefaService.makeResponse(tarefa);

        assertEquals(tarefa.getId(), response.getId());
        assertEquals(tarefa.getNome(), response.getNome());
        assertEquals(tarefa.getFuncionario().getId(), response.getIdFuncionario());
        assertEquals(tarefa.getPrazoEntrega(), response.getPrazoEntrega());
    }

    @Test
    public void deve_retornar_uma_tarefaResponse_quando_buscar_pelo_id(){

        when(tarefaRepository.findById(this.tarefa.getId())).thenReturn(Optional.of(this.tarefa));
        TarefaResponse response = this.tarefaService.buscarPorId(this.tarefa.getId());
        assertEquals(tarefa.getId(), response.getId());

    }

    @Test
    public void deve_retornar_lista_tarefaResponse(){
        when(tarefaRepository.findAll()).thenReturn(this.tarefas);

        List<TarefaResponse> expected = new ArrayList<>();
        List<TarefaResponse> responses = this.tarefaService.buscarTodas();

        assertEquals(expected, responses);

    }

}
