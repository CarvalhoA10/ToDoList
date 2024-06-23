package com.aelson.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aelson.todolist.models.Tarefas;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefas, Long>{
    
}
