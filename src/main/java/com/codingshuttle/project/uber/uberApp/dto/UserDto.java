package com.codingshuttle.project.uber.uberApp.dto;

import java.util.Set;

import com.codingshuttle.project.uber.uberApp.entities.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private String name;
	private String email;
	private Set<Role> roles; 
	private Long id;
}
