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
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente){
        Cliente novoCliente = clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        var cliente = clienteRepository.findById(id);
        if(cliente.isPresent()) {
            clienteRepository.delete(cliente.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente clienteAtualizado){
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);

        if(clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();

            cliente.setNome(clienteAtualizado.getNome());
            cliente.setEmail(clienteAtualizado.getEmail());
            cliente.setTelefone(clienteAtualizado.getTelefone());

            clienteRepository.save(cliente);
            return ResponseEntity.ok(cliente);
        }
        else return ResponseEntity.notFound().build();
    }
}
