package com.aelson.todolist.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aelson.todolist.helpers.AnotacaoRequest;
import com.aelson.todolist.helpers.AnotacaoResponse;
import com.aelson.todolist.models.Anotacao;
import com.aelson.todolist.models.Tarefa;
import com.aelson.todolist.repositories.AnotacaoRepository;
import com.aelson.todolist.repositories.TarefaRepository;

@Service
public class AnotacaoService {
    
    @Autowired
    private AnotacaoRepository AnotacaoRepository;

    @Autowired
    private TarefaRepository tarefaRepository;

    public AnotacaoResponse makeResponse(Anotacao anotacao){
        AnotacaoResponse response = new AnotacaoResponse();
        BeanUtils.copyProperties(anotacao, response);
        response.setIdTarefa(anotacao.getTarefa().getId());
        response.setNomeTarefa(anotacao.getTarefa().getNome());

        return response;
    }

    public AnotacaoResponse criar(AnotacaoRequest request){
        Anotacao anotacao = new Anotacao();
        BeanUtils.copyProperties(request, anotacao);
        anotacao.setTarefa(this.tarefaRepository.findById(request.tarefaId()).get());
        anotacao.setDataAnotacao(LocalDateTime.now());

        anotacao = this.AnotacaoRepository.save(anotacao);

        return this.makeResponse(anotacao);
    }

    public List<AnotacaoResponse> buscarPorTarefa(Long idTarefa){
        
        Tarefa tarefaResponse = this.tarefaRepository.findById(idTarefa).get();
        List<Anotacao> anotacoes = this.AnotacaoRepository.findByTarefa(tarefaResponse);
        List<AnotacaoResponse> responses = new ArrayList<>();

        for (Anotacao anotacao : anotacoes) {
            AnotacaoResponse response = this.makeResponse(anotacao);
            responses.add(response);
        }

        return responses;

    }
}
