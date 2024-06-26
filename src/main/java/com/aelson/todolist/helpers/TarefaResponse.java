package com.aelson.todolist.helpers;

import java.time.LocalDateTime;
import java.util.Date;

public class TarefaResponse {
    
    private Long id;
    private String nomeFuncionario;
    private Long idFuncionario;
    private String nome;
    private String descricao;
    private StatusTarefa status;
    private Date prazoEntrega;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public StatusTarefa getStatus() {
        return status;
    }
    public void setStatus(StatusTarefa status) {
        this.status = status;
    }
    public Date getPrazoEntrega() {
        return prazoEntrega;
    }
    public void setPrazoEntrega(Date prazoEntrega) {
        this.prazoEntrega = prazoEntrega;
    }
    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }
    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
    public String getNomeFuncionario() {
        return nomeFuncionario;
    }
    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }
    public Long getIdFuncionario() {
        return idFuncionario;
    }
    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    



    

}
