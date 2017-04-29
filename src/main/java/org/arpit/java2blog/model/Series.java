package org.arpit.java2blog.model;

import javax.persistence.*;
import java.util.Date;

/*
 * This is our model class and it corresponds to Country table in database
 */
@Entity
@Table(name="series")
public class Series {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;

	@Column(name="name")
	String name;

	@Column(name="description")
	String description;

	@Column(name="modifiedDate")
	Date modifiedDate;

	@Column(name="createdDate")
	Date createdDate;

	public Series() {
		super();
	}

	public Series(Integer id, String name, String description, Date modifiedDate, Date createdDate) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.modifiedDate = modifiedDate;
		this.createdDate = createdDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}