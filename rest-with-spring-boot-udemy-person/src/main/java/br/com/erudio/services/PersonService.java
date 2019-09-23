package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong();

	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.getAndIncrement());
		person.setFirstName("João");
		person.setLastName("Passos");
		person.setAddress("São Paulo - SP");
		person.setGender("Male");		
		return person;
	}
	
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}

	private Person mockPerson(int id) {
		Person person = new Person();
		person.setId(counter.getAndIncrement());
		person.setFirstName("First name " + id);
		person.setLastName("Last name "+ id);
		person.setAddress("Address "+ id);
		person.setGender("Gender "+ id);		
		return person;
	}

	public Person create(Person person) {
		return person;
	}
	
	public Person update(Person person) {
		return person;
	}
		
	public void delete(String id){
		
	}
}
