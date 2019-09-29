package br.com.erudio.data.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

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
@JsonPropertyOrder({"id","address","gender","nome","sobrenome"})
public class PersonVO implements Serializable{
	private static final long serialVersionUID = -7058657769794243611L;
	
	private Long id;
	
	@JsonProperty("nome")
	private String firstName;
	
	@JsonProperty("sobrenome")
	private String lastName;	

	private String address;
	
	@JsonIgnore
	private String gender;

	
}
