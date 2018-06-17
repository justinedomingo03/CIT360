package com.hibernate.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "class")
public class Class implements Serializable {
	@Id
	@Column(name = "class_id", unique = true)
	private int id;

	@Column(name = "class_name", nullable = false)
	private String name;

	@Column(name = "class_abv", nullable = false)
	private String abv;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbv() {
		return abv;
	}

	public void setAbv(String abv) {
		this.abv = abv;
	}

	@Override
	public String toString() {
		return id + "\t" + name + "\t" + abv;
	}
}