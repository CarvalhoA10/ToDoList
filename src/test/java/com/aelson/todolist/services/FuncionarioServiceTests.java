package com.aelson.todolist.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.aelson.todolist.repositories.FuncionarioRepository;

@ExtendWith(MockitoExtension.class)
public class FuncionarioServiceTests {
    
    @InjectMocks
    private FuncionarioService funcionarioService;

    @Mock
    private FuncionarioRepository funcionarioRepository;

    @BeforeEach
    public void setup(){

    }

    @Test
    public void deve_retornar_um_funcionarioResponse_ao_criar_um_novo_funcionario(){

    }

}
