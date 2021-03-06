package br.com.erudio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.erudio.adapter.DozerAdapter;
import br.com.erudio.data.model.Person;
import br.com.erudio.data.vo.PersonVO;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository repository;
	
	public PersonVO create(PersonVO person) {
		var entity = repository.save(DozerAdapter.parseObject(person, Person.class));
		var vo = DozerAdapter.parseObject(entity, PersonVO.class);
		return vo;
	}

	public List<PersonVO> findAll() {
		return DozerAdapter.parseObject(repository.findAll(),PersonVO.class);			
	}

	public Page<PersonVO> findAllPage(PageRequest pageable) {
		var page = repository.findAll(pageable);
		return page.map(this::converterToPersonVO);	
	}

	public Page<PersonVO> findPersonByName(String firstName, PageRequest pageable) {		
		var page = repository.findPersonByName(firstName, pageable);				
		return page.map(this::converterToPersonVO);	
	}
	
	private PersonVO converterToPersonVO(Person entity){
		return DozerAdapter.parseObject(entity,PersonVO.class);	
	}
 	
	public PersonVO findById(Long id) {			
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		var vo = DozerAdapter.parseObject(entity,PersonVO.class); 
		return vo;
	}
		
	public PersonVO update(PersonVO person) {
		var entity = repository.findById(person.getKey()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));			
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		var vo = DozerAdapter.parseObject(repository.save(entity),PersonVO.class);
		return vo;
	}
		
	public void delete(Long id){
		Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));			
		repository.delete(entity);		
	}
	
	@Transactional
	public PersonVO disable(Long id){				
		repository.disablePerson(id);		
		Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));			
		var vo = DozerAdapter.parseObject(entity,PersonVO.class);
		return vo;
	}

	

}
