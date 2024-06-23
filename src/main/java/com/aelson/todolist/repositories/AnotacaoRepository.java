package com.aelson.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aelson.todolist.models.Anotacao;

@Repository
public interface AnotacaoRepository extends JpaRepository<Anotacao, Long> {
    
}
