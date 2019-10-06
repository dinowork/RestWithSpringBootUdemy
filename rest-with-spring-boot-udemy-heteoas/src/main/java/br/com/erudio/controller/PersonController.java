package br.com.erudio.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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
	public List<PersonVO> findAll(){
		List<PersonVO> people = service.findAll();
		people.stream().forEach(p -> 
			p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel())			
		);
		return people;
	}
	
	@GetMapping(value="/{id}" , produces = {"application/json", "application/xml", "application/x-yaml"})	
	public PersonVO findById(@PathVariable("id") Long id){
		PersonVO personVO = service.findById(id);
		personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());		
		return personVO;
	}
	
	@PostMapping(consumes = {"application/json", "application/xml", "application/x-yaml"}, produces = {"application/json", "application/xml", "application/x-yaml"})
	public PersonVO create(@RequestBody PersonVO PersonVO){			
		PersonVO personVO = service.create(PersonVO);
		personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());
		return personVO;
	}

	@PutMapping(consumes = {"application/json", "application/xml", "application/x-yaml"}, produces = {"application/json", "application/xml", "application/x-yaml"})
	public PersonVO update(@RequestBody PersonVO PersonVO){		
		PersonVO personVO = service.update(PersonVO);
		personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());
		return personVO;
	}
		
	@DeleteMapping("/{id}")	
	public ResponseEntity<?> delete(@PathVariable("id") Long id){			
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
