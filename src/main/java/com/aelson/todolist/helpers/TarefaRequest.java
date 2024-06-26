package com.aelson.todolist.helpers;

import java.util.Date;

public record TarefaRequest(
    Long id,
    String nome,
    Long idFuncionario,
    String descricao,
    Date prazoEntrega,
    String status
) {
    
}
