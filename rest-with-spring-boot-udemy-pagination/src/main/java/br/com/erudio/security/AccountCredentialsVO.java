package br.com.erudio.security;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class AccountCredentialsVO implements Serializable {
	private static final long serialVersionUID = -5362763062677668807L;
	
	private String username;	
	private String password;

}
