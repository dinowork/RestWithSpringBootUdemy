package br.com.erudio.data.vo;

import java.io.Serializable;
import java.util.Date;

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
@JsonPropertyOrder({"id","author","launchDate","price","title"})
public class BookVO extends ResourceSupport implements Serializable {
	private static final long serialVersionUID = -2259848167000220224L;

	@Mapping("id")
	@JsonProperty("id")
	private Long key;
		
	private String author;
		
	private Date launchDate;	
	
	private double price;	
	
	private String title;
	
}
