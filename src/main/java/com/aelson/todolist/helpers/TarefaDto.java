package com.aelson.todolist.helpers;

public record TarefaDto(
    Long id,
    String nome,
    Long idFuncionario,
    String descricao,
    String status
) {
    
}
