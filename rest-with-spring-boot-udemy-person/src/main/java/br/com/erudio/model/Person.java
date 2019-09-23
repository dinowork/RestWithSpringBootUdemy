package br.com.erudio.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Person implements Serializable{
	private static final long serialVersionUID = -7058657769794243611L;

	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private String address;
	
	private String gender;

	
}
