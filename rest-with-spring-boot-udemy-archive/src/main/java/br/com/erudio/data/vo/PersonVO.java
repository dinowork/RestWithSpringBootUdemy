package br.com.erudio.data.vo;

import java.io.Serializable;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@JsonPropertyOrder({"id","firstName","lastName","address","gender","enabled"})
public class PersonVO extends ResourceSupport implements Serializable {
	private static final long serialVersionUID = -7058657769794243611L;
	
	@Mapping("id")
	@JsonProperty("id")
	private Long key;
	
	private String firstName;
	
	private String lastName;	

	private String address;
	
	private String gender;
	
	private boolean enabled;

	
}
