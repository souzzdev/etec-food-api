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

    @PutMapping("/{id}")
    public ResponseEntity<Entrega> atualizar(@PathVariable Integer id, @RequestBody Entrega entregaAtualizada) {
        Optional<Entrega> entregaOptional = entregaRepository.findById(id);

        if(entregaOptional.isPresent()) {
            Entrega entrega = entregaOptional.get();

            entrega.setCep(entregaAtualizada.getCep());
            entrega.setComplemento(entregaAtualizada.getComplemento());
            entrega.setEndereco(entregaAtualizada.getEndereco());

            entregaRepository.save(entrega);
            return ResponseEntity.ok(entrega);
        }
        else return ResponseEntity.notFound().build();
    }
}
    
