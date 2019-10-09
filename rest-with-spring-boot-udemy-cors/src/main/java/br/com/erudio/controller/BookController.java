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

import br.com.erudio.data.vo.BookVO;
import br.com.erudio.services.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Book EndPoint", description = "Description for book", tags = {"BookEndPoint"})
@RestController
@RequestMapping("/api/v1/book")
public class BookController {
	
	@Autowired
	BookService service;
	
	@ApiOperation(value = "find All book recorded")
	@GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
	public List<BookVO> findAll() {
		List<BookVO> books = service.findAll();
		books.stream().forEach(b -> 
			b.add(linkTo(methodOn(BookController.class).findById(b.getKey())).withSelfRel())
		);		
		return books;
	}
	
	@ApiOperation(value = "find book by id")
	@GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
	public BookVO findById(@PathVariable("id") Long id) {
		BookVO booksVO = service.findById(id);
		booksVO.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
		return booksVO;
	} 
	
	@ApiOperation(value = "create book")
	@PostMapping(consumes = {"application/json", "application/xml", "application/x-yaml"}, produces = {"application/json", "application/xml", "application/x-yaml"})
	public BookVO create(@RequestBody BookVO book) {
		BookVO booksVO = service.create(book);
		book.add(linkTo(methodOn(BookController.class).findById(booksVO.getKey())).withSelfRel());
		return booksVO;
	}
		
	@ApiOperation(value = "update book recorded")
	@PutMapping(consumes = {"application/json", "application/xml", "application/x-yaml"}, produces = {"application/json", "application/xml", "application/x-yaml"})
	public BookVO update(@RequestBody BookVO book) {
		BookVO booksVO = service.update(book);
		book.add(linkTo(methodOn(BookController.class).findById(booksVO.getKey())).withSelfRel());
		return booksVO;
	}
	
	@ApiOperation(value = "delete book recorded")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
