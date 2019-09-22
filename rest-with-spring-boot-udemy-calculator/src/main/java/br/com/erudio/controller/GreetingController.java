package br.com.erudio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.service.GreetingService;

@RestController
public class GreetingController {
	
	@Autowired 
	private GreetingService service;
	 	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}",method = RequestMethod.GET)
	public Double soma(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {			
		return service.sum(numberOne , numberTwo);		
	}
	
	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}",method = RequestMethod.GET)
	public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {		
		return service.subtraction(numberOne , numberTwo);			
	}

	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}",method = RequestMethod.GET)
	public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {	
		return service.multiplication(numberOne , numberTwo);
	}

	@RequestMapping(value = "/division/{numberOne}/{numberTwo}",method = RequestMethod.GET)
	public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {			
		return service.division(numberOne , numberTwo);
	}
	
	@RequestMapping(value = "/power/{numberOne}/{numberTwo}",method = RequestMethod.GET)
	public Double power(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		return service.power(numberOne , numberTwo);
	}
	
	@RequestMapping(value = "/media/{numberOne}/{numberTwo}",method = RequestMethod.GET)
	public Double media(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		return service.media(numberOne , numberTwo);		
	}
	
	@RequestMapping(value = "/rootSquare/{number}",method = RequestMethod.GET)
	public Double rootSquare(@PathVariable("number") String number) throws Exception {
		return service.rootSquare(number);		
	}	

	
}
