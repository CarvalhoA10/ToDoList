package com.aelson.todolist.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "anotacoes")
public class Anotacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 1000)
    private String anotacao;
    @Column
    private LocalDateTime dataAnotacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tarefa_id")
    private Tarefas tarefa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(String anotacao) {
        this.anotacao = anotacao;
    }

    public LocalDateTime getDataAnotacao() {
        return dataAnotacao;
    }

    public void setDataAnotacao(LocalDateTime dataAnotacao) {
        this.dataAnotacao = dataAnotacao;
    }

    public Tarefas getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefas tarefa) {
        this.tarefa = tarefa;
    }

    
}
