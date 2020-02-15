package br.com.erudio.adapter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.erudio.adapter.mocks.MockBook;
import br.com.erudio.adapter.mocks.MockPerson;
import br.com.erudio.data.model.Book;
import br.com.erudio.data.model.Person;
import br.com.erudio.data.vo.BookVO;
import br.com.erudio.data.vo.PersonVO;

public class DozerAdapterTest {

	MockPerson inputObjectPerson;	
	MockBook inputObjectBooks;
	
	@Before
	public void serUp() {
		inputObjectPerson = new MockPerson();
		inputObjectBooks = new MockBook();
	}
	
	// PERSON ENTITY TO VO
	
	@Test
	public void personParseEntityToVOTest() {
		PersonVO output = DozerAdapter.parseObject(inputObjectPerson.mockEntity(), PersonVO.class);		
		assertEquals(Long.valueOf(0L), output.getKey());
		assertEquals("Entity First Name Test0", output.getFirstName());
		assertEquals("Entity Last Name Test0", output.getLastName());
		assertEquals("Entity Address Test0", output.getAddress());
		assertEquals("Male", output.getGender());				
	}
	
	@Test
	public void personParseEntityListToVOListTest() {
		List<PersonVO> outputList = DozerAdapter.parseObject(inputObjectPerson.mockEntityList(), PersonVO.class);
		
		PersonVO output = outputList.get(0);				
		assertEquals("Entity First Name Test"+output.getKey(), output.getFirstName());
		assertEquals("Entity Last Name Test"+output.getKey(), output.getLastName());
		assertEquals("Entity Address Test"+output.getKey(), output.getAddress());
		assertEquals(output.getKey() % 2 == 0 ? "Male" : "Female", output.getGender());
		
		output = outputList.get(7);		
		assertEquals("Entity First Name Test"+output.getKey(), output.getFirstName());
		assertEquals("Entity Last Name Test"+output.getKey(), output.getLastName());
		assertEquals("Entity Address Test"+output.getKey(), output.getAddress());
		assertEquals(output.getKey() % 2 == 0 ? "Male" : "Female", output.getGender());
		
		output = outputList.get(12);		
		assertEquals("Entity First Name Test"+output.getKey(), output.getFirstName());
		assertEquals("Entity Last Name Test"+output.getKey(), output.getLastName());
		assertEquals("Entity Address Test"+output.getKey(), output.getAddress());
		assertEquals(output.getKey() % 2 == 0 ? "Male" : "Female", output.getGender());
		
	}

   // PERSON VO TO ENTITY 	
	
	@Test
	public void personParseVOToEntityTest() {
		Person output = DozerAdapter.parseObject(inputObjectPerson.mockVO(), Person.class);		
		assertEquals(Long.valueOf(0L), output.getId());
		assertEquals("VO First Name Test0", output.getFirstName());
		assertEquals("VO Last Name Test0", output.getLastName());
		assertEquals("VO Address Test0", output.getAddress());
		assertEquals("Male", output.getGender());				
	}
	
	@Test
	public void personParseVOListToEntityListTest() {
		List<Person> outputList = DozerAdapter.parseObject(inputObjectPerson.mockVOList(), Person.class);
		
		Person output = outputList.get(0);				
		assertEquals("VO First Name Test"+output.getId(), output.getFirstName());
		assertEquals("VO Last Name Test"+output.getId(), output.getLastName());
		assertEquals("VO Address Test"+output.getId(), output.getAddress());
		assertEquals(output.getId() % 2 == 0 ? "Male" : "Female", output.getGender());
		
		output = outputList.get(7);		
		assertEquals("VO First Name Test"+output.getId(), output.getFirstName());
		assertEquals("VO Last Name Test"+output.getId(), output.getLastName());
		assertEquals("VO Address Test"+output.getId(), output.getAddress());
		assertEquals(output.getId() % 2 == 0 ? "Male" : "Female", output.getGender());
		
		output = outputList.get(12);		
		assertEquals("VO First Name Test"+output.getId(), output.getFirstName());
		assertEquals("VO Last Name Test"+output.getId(), output.getLastName());
		assertEquals("VO Address Test"+output.getId(), output.getAddress());
		assertEquals(output.getId() % 2 == 0 ? "Male" : "Female", output.getGender());
		
	}
	
	// BOOKS ENTITY TO VO
	@Test
	public void bookParseEntityToVOTest() {
		BookVO vo = DozerAdapter.parseObject(inputObjectBooks.createEntity(), BookVO.class);
		assertEquals("Entity Author0", vo.getAuthor());
		assertEquals("Entity Title0", vo.getTitle());
		assertTrue(200L == vo.getPrice());
		assertTrue(0L == vo.getKey());
		//test data 
	}
	
	@Test
	public void bookParseListEntityToListVOTest() {
		List<BookVO> lista = DozerAdapter.parseObject(inputObjectBooks.listEntity(), BookVO.class);
		
		Integer number = 1;
		BookVO vo = lista.get(number);
		assertEquals("Entity Author"+number, vo.getAuthor());
		assertEquals("Entity Title"+number, vo.getTitle());
		assertTrue((200L+number) == vo.getPrice());
		assertTrue(number == vo.getKey().intValue());
		
		number = 8;
		vo = lista.get(number);
		assertEquals("Entity Author"+number, vo.getAuthor());
		assertEquals("Entity Title"+number, vo.getTitle());
		assertTrue((200L+number) == vo.getPrice());
		assertTrue(number == vo.getKey().intValue());
		
		number = 10;
		vo = lista.get(number);
		assertEquals("Entity Author"+number, vo.getAuthor());
		assertEquals("Entity Title"+number, vo.getTitle());
		assertTrue((200L+number) == vo.getPrice());
		assertTrue(number == vo.getKey().intValue());

		
	}
			
	// BOOKS VO TO ENTITY
	@Test
	public void bookParseVOToEntityTest() {
		Book vo = DozerAdapter.parseObject(inputObjectBooks.createVO(), Book.class);
		assertEquals("VO Author0", vo.getAuthor());
		assertEquals("VO Title0", vo.getTitle());
		assertTrue(100L == vo.getPrice());
		assertTrue(0L == vo.getId());
		//test data
	}
	
	@Test
	public void bookParseListVOToListEntityTest() {
		List<Book> lista = DozerAdapter.parseObject(inputObjectBooks.listVO(), Book.class);
		
		Integer number = 1;
		Book entity = lista.get(number);
		assertEquals("VO Author"+number, entity.getAuthor());
		assertEquals("VO Title"+number, entity.getTitle());
		assertTrue((100L+number) == entity.getPrice());
		assertTrue(number == entity.getId().intValue());
		
		number = 8;
		entity = lista.get(number);
		assertEquals("VO Author"+number, entity.getAuthor());
		assertEquals("VO Title"+number, entity.getTitle());
		assertTrue((100L+number) == entity.getPrice());
		assertTrue(number == entity.getId().intValue());
		
		number = 10;
		entity = lista.get(number);
		assertEquals("VO Author"+number, entity.getAuthor());
		assertEquals("VO Title"+number, entity.getTitle());
		assertTrue((100L+number) == entity.getPrice());
		assertTrue(number == entity.getId().intValue());
		
	}
	

}
