package br.org.serratec.backend.h2banco.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.backend.h2banco.domain.Veiculo;
import br.org.serratec.backend.h2banco.repository.VeiculoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

	//injestao do veiculorepository no controller
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@GetMapping
	public ResponseEntity<List<Veiculo>> listar() {
		return ResponseEntity.ok(veiculoRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Veiculo> buscar(@PathVariable Long id){
		Optional<Veiculo> veiculoOpt = veiculoRepository.findById(id);
		if(veiculoOpt.isPresent()) {
			return ResponseEntity.ok(veiculoOpt.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo inserir(@Valid @RequestBody Veiculo veiculo) {
		veiculo = veiculoRepository.save(veiculo);
		return veiculo;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Veiculo> atualizar(@PathVariable Long id, @Valid @RequestBody Veiculo veiculo) {
		if(!veiculoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		//seta um id para n criar um novo
		veiculo.setId(id);
		//salva pq no caso de o id ja existir ele salva
		veiculo = veiculoRepository.save(veiculo);
		return ResponseEntity.ok(veiculo);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		if(!veiculoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}   
		veiculoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
