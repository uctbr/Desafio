package com.rh.recursoHumanos.controller;


import com.rh.recursoHumanos.funcionario.Funcionario;
import com.rh.recursoHumanos.funcionario.FuncionarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @PostMapping
    public void adicionarFuncionario(@RequestBody Funcionario funcionario){
        funcionarioRepository.saveAndFlush(funcionario);
    }

    @GetMapping
    public List<Funcionario> listarTodosFuncionarios(){
        return funcionarioRepository.findAllByAtivoTrue();
    }

    @PutMapping
    @Transactional
    public void alterarDadosFuncionario(@RequestBody Funcionario funcionario){
        var funcionarioResgatado = funcionarioRepository.getReferenceById(funcionario.getId());

        funcionarioResgatado.atualizar(funcionario);
    }

    @GetMapping("/{id}")
    public Optional<Funcionario> listarFuncionarioPeloId (@PathVariable("id") Integer id){
        return funcionarioRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarFuncionario(@PathVariable("id") Integer id){
        var funcionarioResgatado = funcionarioRepository.getReferenceById(id);
        funcionarioResgatado.excluir();
    }
}
