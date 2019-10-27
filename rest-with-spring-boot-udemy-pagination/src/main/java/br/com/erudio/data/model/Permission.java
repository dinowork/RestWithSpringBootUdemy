package br.com.erudio.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="permission")
@Getter
@Setter
@EqualsAndHashCode
public class Permission implements GrantedAuthority, Serializable{
	private static final long serialVersionUID = -2422475231926880647L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name =  "id")
	private Long id;
	
	@Column(name =  "description")
	private String description;
	
	
	@Override	
	public String getAuthority() {
		return description;
	}
	
	

}
