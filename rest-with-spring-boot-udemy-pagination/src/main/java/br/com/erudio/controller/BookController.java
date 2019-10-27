package br.com.erudio.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@Autowired
	private PagedResourcesAssembler<BookVO> assembler;
	
	@ApiOperation(value = "find All book recorded")
	@GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
	public List<BookVO> findAll() {
		List<BookVO> books = service.findAll();
		books.stream().forEach(b -> 
			b.add(linkTo(methodOn(BookController.class).findById(b.getKey())).withSelfRel())
		);		
		return books;
	}
	
	@GetMapping(value = "/pagination",  produces = {"application/json", "application/xml", "application/x-yaml"})
	public ResponseEntity<?> findAllPage(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam(value = "direction", defaultValue = "asc") String direction
			){ 
		var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.by("author").descending() : Sort.by("author").ascending();		  
		PageRequest pageable = PageRequest.of(page, limit, sortDirection);		
		Page<BookVO> books = service.findAllPage(pageable);		
		books.stream().forEach(b -> 
			b.add(linkTo(methodOn(BookController.class).findById(b.getKey())).withSelfRel())				            			
		);				
		PagedResources<?> resources = assembler.toResource(books);		
		return new ResponseEntity<>(resources, HttpStatus.OK);
	}
	
	@GetMapping(value = "/pagination/{parametro}",  produces = {"application/json", "application/xml", "application/x-yaml"})
	public ResponseEntity<?> findAllPageFilter(
			@PathVariable("parametro") String parametro,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam(value = "direction", defaultValue = "asc") String direction
			){	 
		var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.by("author").descending().and(Sort.by("title").descending()) : Sort.by("author").ascending().and(Sort.by("title").ascending());		  		
		PageRequest pageable = PageRequest.of(page, limit, sortDirection);		
		Page<BookVO> books = service.findBookByAuthorOrTitle(parametro, pageable);		
		books.stream().forEach(b -> 
			b.add(linkTo(methodOn(BookController.class).findById(b.getKey())).withSelfRel())				            			
		);				
		PagedResources<?> resources = assembler.toResource(books);		
		return new ResponseEntity<>(resources, HttpStatus.OK);
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
