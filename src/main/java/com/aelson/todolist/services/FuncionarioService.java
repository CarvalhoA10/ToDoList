package com.aelson.todolist.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aelson.todolist.helpers.FuncionarioDto;
import com.aelson.todolist.models.Funcionario;
import com.aelson.todolist.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
    
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario criar(FuncionarioDto dto){        
        try {
            
            Funcionario funcionario = this.encontrarPorEmail(dto.email());

            if(funcionario != null){
                funcionario.setCargo(null);
                funcionario.setEmail("Email já existente");
                return funcionario;
            }

            System.out.println(dto.cargo()+ " | " + dto.email());            

            funcionario = new Funcionario();
            BeanUtils.copyProperties(dto, funcionario);

            System.out.println(funcionario.getCargo()+ " | " + funcionario.getEmail());

            return this.funcionarioRepository.save(funcionario);

        } catch (Exception e) {
            return new Funcionario();
        }

    }

    public Funcionario encontrarPorEmail(String email){
        try {
            
            Funcionario funcionario = this.funcionarioRepository.findByEmail(email);
            if(funcionario == null){
                return null;
            }

            return funcionario;

        } catch (Exception ex) {
            return null;
        }
    }

}
