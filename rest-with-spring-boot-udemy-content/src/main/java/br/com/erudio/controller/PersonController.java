package br.com.erudio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.data.vo.PersonVO;
import br.com.erudio.services.PersonService;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {
	
	@Autowired 
	private PersonService service;
		
	@GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
	public List<PersonVO> findAll() throws Exception {
		return service.findAll();
	}
	
	@GetMapping(value="/{id}" , produces = {"application/json", "application/xml", "application/x-yaml"})	
	public PersonVO findById(@PathVariable("id") Long id) throws Exception {			
		return service.findById(id);
	}
	
	@PostMapping(consumes = {"application/json", "application/xml", "application/x-yaml"}, produces = {"application/json", "application/xml", "application/x-yaml"})
	public PersonVO create(@RequestBody PersonVO PersonVO) throws Exception {			
		return service.create(PersonVO);
	}

	@PutMapping(consumes = {"application/json", "application/xml", "application/x-yaml"}, produces = {"application/json", "application/xml", "application/x-yaml"})
	public PersonVO update(@RequestBody PersonVO PersonVO) throws Exception {			
		return service.update(PersonVO);
	}
		
	@DeleteMapping("/{id}")	
	public ResponseEntity<?> delete(@PathVariable("id") Long id) throws Exception {			
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
