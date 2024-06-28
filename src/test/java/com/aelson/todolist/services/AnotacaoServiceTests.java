package com.aelson.todolist.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.aelson.todolist.helpers.AnotacaoRequest;
import com.aelson.todolist.helpers.AnotacaoResponse;
import com.aelson.todolist.helpers.StatusTarefa;
import com.aelson.todolist.models.Anotacao;
import com.aelson.todolist.models.Funcionario;
import com.aelson.todolist.models.Tarefa;
import com.aelson.todolist.repositories.AnotacaoRepository;
import com.aelson.todolist.repositories.TarefaRepository;

@ExtendWith(MockitoExtension.class)
public class AnotacaoServiceTests {
    
    @InjectMocks
    private AnotacaoService anotacaoService;

    @Mock
    private AnotacaoRepository anotacaoRepository;

    @Mock
    private TarefaRepository tarefaRepository;

    Anotacao anotacao;
    AnotacaoRequest anotacaoRequest;
    List<Anotacao> anotacoes;
    Tarefa tarefa;

    @BeforeEach
    public void setup(){
        this.tarefa = new Tarefa();
        this.tarefa.setId(1L);
        this.tarefa.setFuncionario(new Funcionario());
        this.tarefa.setAnotacoes(new ArrayList<>());
        this.tarefa.setNome("Tarefa");
        this.tarefa.setDescricao("Uma descrição");
        this.tarefa.setStatus(StatusTarefa.valueOf("iniciada"));

        this.anotacao = new Anotacao();
        this.anotacao.setAnotacao("Uma anotacao qualquer");
        this.anotacao.setDataAnotacao(LocalDateTime.now());
        this.anotacao.setId(1L);
        this.anotacao.setTarefa(this.tarefa);

        anotacaoRequest = new AnotacaoRequest(this.anotacao.getId(), this.anotacao.getAnotacao());

        anotacoes = new ArrayList<>();
    }

    @Test
    public void deve_retornar_anotacaoResponse_ao_criar(){
        when(this.anotacaoRepository.save(ArgumentMatchers.any(Anotacao.class))).thenReturn(this.anotacao);
        when(this.tarefaRepository.findById(this.tarefa.getId())).thenReturn(Optional.of(this.tarefa));
        AnotacaoResponse response = this.anotacaoService.criar(this.anotacaoRequest);

        assertNotNull(response);
        assertEquals(this.anotacao.getTarefa().getId(), response.getIdTarefa());

    }

    @Test
    public void deve_retornar_lista_anotacaoResponse_ao_buscar_anotacoes_da_tarefa(){
        when(this.anotacaoRepository.findByTarefa(ArgumentMatchers.any(Tarefa.class))).thenReturn(anotacoes);
        when(this.tarefaRepository.findById(this.tarefa.getId())).thenReturn(Optional.of(this.tarefa));

        List<AnotacaoResponse> responses = new ArrayList<>();

        assertNotNull(this.anotacaoService.buscarPorTarefa(this.tarefa.getId()));
        assertEquals(responses, this.anotacaoService.buscarPorTarefa(this.tarefa.getId()));
    }


}
