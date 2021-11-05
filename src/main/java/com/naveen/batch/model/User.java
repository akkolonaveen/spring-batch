package com.naveen.batch.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	private Integer id;
	
	private String name;
	
	private String dept;
	
	private Integer salary;
	
	
}
