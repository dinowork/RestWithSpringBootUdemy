package br.com.erudio.adapter.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.erudio.data.model.Person;
import br.com.erudio.data.vo.PersonVO;

public class MockPerson {
	
	//GET
	public Person mockEntity() {
		return mockEntity(0L);
	}
	
	public PersonVO mockVO(){
		return mockVO(0L);
	}
	
	// LIST
	public List<Person> mockEntityList(){
		List<Person> persons = new ArrayList<Person>();
		for (long i = 0; i < 14; i++) {
			persons.add(mockEntity(i));
		}		
		return persons;
	}
	
	public List<PersonVO> mockVOList(){
		List<PersonVO> vos = new ArrayList<PersonVO>();
		for (long i = 0; i < 14; i++) {
			vos.add(mockVO(i));
		}		
		return vos;
	}

	// UNITY
	private Person mockEntity(Long number) {
		Person entity = new Person();
		entity.setId(number);
		entity.setFirstName("Entity First Name Test" + number);
		entity.setLastName("Entity Last Name Test" + number);
		entity.setAddress("Entity Address Test" + number);
		entity.setGender( (number % 2) == 0? "Male" : "Female");		
		return entity;
	} 
	
	private PersonVO mockVO(Long number) {
		PersonVO vo = new PersonVO();
		vo.setId(number);
		vo.setFirstName("VO First Name Test" + number);
		vo.setLastName("VO Last Name Test" + number);
		vo.setAddress("VO Address Test"+ number);
		vo.setGender( (number % 2) == 0? "Male" : "Female");		
		return vo;
	} 
	
}
 