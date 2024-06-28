package com.aelson.todolist.helpers;

import java.time.LocalDateTime;

public class AnotacaoResponse {
    
    private Long id;
    private Long idTarefa;
    private String nomeTarefa;
    private String anotacao;
    private LocalDateTime dataAnotacao;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getIdTarefa() {
        return idTarefa;
    }
    public void setIdTarefa(Long idTarefa) {
        this.idTarefa = idTarefa;
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
    public String getNomeTarefa() {
        return nomeTarefa;
    }
    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

}
