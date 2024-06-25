package com.aelson.todolist.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

            funcionario = new Funcionario();
            BeanUtils.copyProperties(dto, funcionario);

            funcionario.setDataRegistro(LocalDateTime.now());
            funcionario.setDataAtualizacao(LocalDateTime.now());

            return this.funcionarioRepository.save(funcionario);

        } catch (Exception e) {

            return new Funcionario();

        }

    }

    public List<Funcionario> listarTodos(){
        return this.funcionarioRepository.findAll();
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

    public Funcionario encontrarPorId(Long id){
        try{

            Optional<Funcionario> funcionario = this.funcionarioRepository.findById(id);
            if(funcionario.isEmpty()){
                return null;
            }

            return funcionario.get();

        }catch(Exception ex){

            return null;

        }
    }

    public Funcionario atualizar(FuncionarioDto dto){

        try {
            Funcionario funcionario = this.encontrarPorId(dto.id());

            if(funcionario == null){
                return null;
            }

            funcionario.setCargo(dto.cargo());
            funcionario.setEmail(dto.email());
            funcionario.setNome(dto.nome());

            funcionario.setDataAtualizacao(LocalDateTime.now());

            return this.funcionarioRepository.save(funcionario);

        } catch (Exception ex) {
            return null;
        }

    }

    public Funcionario deletar(Long id){

        try {
            
            Funcionario funcionario = this.encontrarPorId(id);
            this.funcionarioRepository.delete(funcionario);

            return funcionario;

        } catch (Exception ex) {

            return null;
            
        }

    }

}
