package br.com.erudio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.adapter.DozerAdapter;
import br.com.erudio.data.model.Book;
import br.com.erudio.data.vo.BookVO;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository repository;
	
	public BookVO create(BookVO books) {
		var entity = repository.save(DozerAdapter.parseObject(books, Book.class));
		var vo = DozerAdapter.parseObject(entity, BookVO.class);
		return vo;
	}

	public List<BookVO> findAll() {
		return DozerAdapter.parseObject(repository.findAll(),BookVO.class);			
	}

	public BookVO findById(Long id) {			
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		var vo = DozerAdapter.parseObject(entity,BookVO.class); 
		return vo;
	}
		
	public BookVO update(BookVO books) {
		var entity = repository.findById(books.getKey()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));			
		entity.setAuthor(books.getAuthor());
		entity.setLaunchDate(books.getLaunchDate());
		entity.setPrice(books.getPrice());
		entity.setTitle(books.getTitle());
		var vo = DozerAdapter.parseObject(repository.save(entity),BookVO.class);
		return vo;
	}
		
	public void delete(Long id){
		Book entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));			
		repository.delete(entity);		
	}
}
