package com.example.wizpanda.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
	
	private static final Long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull(message="Name can't be null")
	private String name;
	
	@NotNull(message="Email can't be null")
	private String email;
	
	@Size(max=10, message="Number can't be greater than 10")
	@NotNull(message="Mobile Number can't be null")
	private String number;
	
	@NotNull(message="Password can't be null")
	private String password;

}
