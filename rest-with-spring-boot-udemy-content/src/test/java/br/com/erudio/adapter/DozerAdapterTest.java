package br.com.erudio.adapter;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.erudio.adapter.DozerAdapter;
import br.com.erudio.adapter.mocks.MockPerson;
import br.com.erudio.data.model.Person;
import br.com.erudio.data.vo.PersonVO;

public class DozerAdapterTest {

	MockPerson inputObject;
	
	@Before
	public void serUp() {
		inputObject = new MockPerson();
	}
	
	@Test
	public void parseEntityToVOTest() {
		PersonVO output = DozerAdapter.parseObject(inputObject.mockEntity(), PersonVO.class);		
		assertEquals(Long.valueOf(0L), output.getId());
		assertEquals("Entity First Name Test0", output.getFirstName());
		assertEquals("Entity Last Name Test0", output.getLastName());
		assertEquals("Entity Address Test0", output.getAddress());
		assertEquals("Male", output.getGender());				
	}
	
	@Test
	public void parseEntityListToVOListTest() {
		List<PersonVO> outputList = DozerAdapter.parseObject(inputObject.mockEntityList(), PersonVO.class);
		
		PersonVO output = outputList.get(0);				
		assertEquals("Entity First Name Test"+output.getId(), output.getFirstName());
		assertEquals("Entity Last Name Test"+output.getId(), output.getLastName());
		assertEquals("Entity Address Test"+output.getId(), output.getAddress());
		assertEquals(output.getId() % 2 == 0 ? "Male" : "Female", output.getGender());
		
		output = outputList.get(7);		
		assertEquals("Entity First Name Test"+output.getId(), output.getFirstName());
		assertEquals("Entity Last Name Test"+output.getId(), output.getLastName());
		assertEquals("Entity Address Test"+output.getId(), output.getAddress());
		assertEquals(output.getId() % 2 == 0 ? "Male" : "Female", output.getGender());
		
		output = outputList.get(12);		
		assertEquals("Entity First Name Test"+output.getId(), output.getFirstName());
		assertEquals("Entity Last Name Test"+output.getId(), output.getLastName());
		assertEquals("Entity Address Test"+output.getId(), output.getAddress());
		assertEquals(output.getId() % 2 == 0 ? "Male" : "Female", output.getGender());
		
	}
	
	@Test
	public void parseVOToEntityTest() {
		Person output = DozerAdapter.parseObject(inputObject.mockVO(), Person.class);		
		assertEquals(Long.valueOf(0L), output.getId());
		assertEquals("VO First Name Test0", output.getFirstName());
		assertEquals("VO Last Name Test0", output.getLastName());
		assertEquals("VO Address Test0", output.getAddress());
		assertEquals("Male", output.getGender());				
	}
	
	@Test
	public void parseVOListToEntityListTest() {
		List<Person> outputList = DozerAdapter.parseObject(inputObject.mockVOList(), Person.class);
		
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
	
}
