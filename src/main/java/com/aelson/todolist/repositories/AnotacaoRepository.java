package com.aelson.todolist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aelson.todolist.models.Anotacao;
import com.aelson.todolist.models.Tarefa;

@Repository
public interface AnotacaoRepository extends JpaRepository<Anotacao, Long> {
    
    List<Anotacao> findByTarefa(Tarefa tarefa);

}
