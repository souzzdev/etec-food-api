package br.com.etechas.etecfood.controller;

import br.com.etechas.etecfood.entity.Entrega;
import br.com.etechas.etecfood.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entrega")
public class EntregaController {
    @Autowired
    EntregaRepository entregaRepository;

    @GetMapping
    public List<Entrega> findAll() {
        return entregaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrega> findById(@PathVariable Integer id) {
        var entrega = entregaRepository.findById(id);

        if(entrega.isPresent()) return ResponseEntity.ok(entrega.get());
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Entrega> cadastrar(@RequestBody Entrega entrega) {
        Entrega novaEntrega = entregaRepository.save(entrega);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaEntrega);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        var entrega = entregaRepository.findById(id);
        if(entrega.isPresent()) {
            entregaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    
