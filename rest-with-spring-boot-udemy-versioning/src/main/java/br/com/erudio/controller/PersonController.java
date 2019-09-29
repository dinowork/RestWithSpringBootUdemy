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
import br.com.erudio.data.vo.PersonVOV2;
import br.com.erudio.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired 
	private PersonService service;
		
	@GetMapping
	public List<PersonVO> findAll() throws Exception {
		return service.findAll();
	}
	
	@GetMapping("/{id}")	
	public PersonVO findById(@PathVariable("id") Long id) throws Exception {			
		return service.findById(id);
	}
	
	@PostMapping
	public PersonVO create(@RequestBody PersonVO PersonVO) throws Exception {			
		return service.create(PersonVO);
	}
	
	@PostMapping("/v2")
	public PersonVOV2 createV2(@RequestBody PersonVOV2 PersonVOV2) throws Exception {			
		return service.createV2(PersonVOV2);
	}

	@PutMapping
	public PersonVO update(@RequestBody PersonVO PersonVO) throws Exception {			
		return service.update(PersonVO);
	}
		
	@DeleteMapping("/{id}")	
	public ResponseEntity<?> delete(@PathVariable("id") Long id) throws Exception {			
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
