package br.com.etechas.etecfood.controller;

import br.com.etechas.etecfood.entity.Cliente;
import br.com.etechas.etecfood.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
        var cliente = clienteRepository.findById(id);
        if(cliente.isPresent()) return ResponseEntity.ok(cliente.get());
        return ResponseEntity.notFound().build();
    }

    
