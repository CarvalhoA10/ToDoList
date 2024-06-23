package com.aelson.todolist.helpers;

public record FuncionarioDto(
    Long id,
    String nome,
    String cargo,
    String email
) {
    
}
