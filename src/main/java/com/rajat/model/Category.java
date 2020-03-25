package com.rajat.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Category")
public class Category {
	
	@Id
	private long id;
	
	@NonNull
	private String name;
	
//	@ManyToOne(cascade=CascadeType.PERSIST)
//	private Set<User> user;

}
