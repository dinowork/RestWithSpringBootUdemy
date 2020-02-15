package br.com.erudio.data.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Entity
public class Book implements Serializable {
	private static final long serialVersionUID = 196349390271419639L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 180)
	private String author;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "launch_date", nullable = false)
	private Date launchDate;
	
	@Column(nullable = false)
	private double price;
	
	@Column(nullable = false, length = 250)
	private String title;
	

}
