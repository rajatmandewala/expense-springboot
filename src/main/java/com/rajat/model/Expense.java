package com.rajat.model;

import lombok.NoArgsConstructor;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="expense")
public class Expense {
	
	@Id
	private long id;
	
	private Instant expenseDate;
	
	private String desc;
	
	private String location;
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private User user;

}
