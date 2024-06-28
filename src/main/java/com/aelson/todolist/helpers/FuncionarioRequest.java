package com.aelson.todolist.helpers;

public record FuncionarioRequest(
    Long id,
    String nome,
    String cargo,
    String email
) {
    
}
