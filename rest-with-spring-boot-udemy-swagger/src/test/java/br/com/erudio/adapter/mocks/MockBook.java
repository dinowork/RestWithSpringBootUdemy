package br.com.erudio.adapter.mocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.erudio.data.model.Book;
import br.com.erudio.data.vo.BookVO;

public class MockBook {

	//VO
	private BookVO createVO(Long number) {
		BookVO vo = new BookVO();
		vo.setKey(number);
		vo.setAuthor("VO Author"+number);
		vo.setLaunchDate(new Date());
		vo.setPrice(100L+number);
		vo.setTitle("VO Title"+number);
		return vo;
	}
	
	public BookVO createVO() {
		return createVO(0L);
	}
	
	
	public List<BookVO> listVO(){
		List<BookVO> lista = new ArrayList<>(); 
		for (Long i = 0L; i <= 10L; i++) {
			lista.add(createVO(i));
		}
		return lista;
	}
	
	// ENTITY
	private Book createEntity(Long number) {
		Book entity = new Book();
		entity.setId(number);
		entity.setAuthor("Entity Author"+number);
		entity.setLaunchDate(new Date());
		entity.setPrice(200L+number);
		entity.setTitle("Entity Title"+number);
		return entity;
	}
	
	public Book createEntity() {
		return createEntity(0L);
	}		

	public List<Book> listEntity(){
		List<Book> lista = new ArrayList<>(); 
		for (Long i = 0L; i <= 10L; i++) {
			lista.add(createEntity(i));
		}
		return lista;		
	}

 

}
