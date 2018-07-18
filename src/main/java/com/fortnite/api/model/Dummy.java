package com.fortnite.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "dummy")
public class Dummy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iddummy;
	
	@NotNull
	private String textdummy;

	public Integer getIddummy() {
		return iddummy;
	}

	public void setIddummy(Integer iddummy) {
		this.iddummy = iddummy;
	}

	public String getTextdummy() {
		return textdummy;
	}

	public void setTextdummy(String textdummy) {
		this.textdummy = textdummy;
	}
	
	
	
}
