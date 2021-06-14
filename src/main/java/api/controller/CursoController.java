package api.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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

import api.controller.dto.CursoDto;
import api.controller.form.AtualizacaoCursoForm;
import api.model.Curso;
import api.repository.CursoRepository;

@RestController
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	public List<Curso> Listar() {
		
		return cursoRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public Curso adicionar(@RequestBody Curso curso) {
		return cursoRepository.save(curso);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<CursoDto> removeCurso(@PathVariable Integer id) {
		Optional<Curso> optional = cursoRepository.findById(id);
		if(optional.isPresent()) {
			cursoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
		
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<CursoDto> atualizar(@PathVariable Integer id, @RequestBody AtualizacaoCursoForm form) {
		Optional<Curso> optional = cursoRepository.findById(id);
		if(optional.isPresent()) {
			Curso cursos = form.atualizar(id, cursoRepository);
			return ResponseEntity.ok(new CursoDto(cursos));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	

}
