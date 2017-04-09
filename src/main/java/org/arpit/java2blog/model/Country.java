package org.arpit.java2blog.model;

import javax.persistence.*;
import java.util.List;

/*
 * This is our model class and it corresponds to Country table in database
 */
@Entity
@Table(name="COUNTRY")
public class Country{
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	
	@Column(name="countryName")
	String countryName;	
	
	@Column(name="population")
	Long population;


	
	public Country() {
		super();
	}

	public Country(Integer id, String countryName, Long population) {
		this.id = id;
		this.countryName = countryName;
		this.population = population;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}


}