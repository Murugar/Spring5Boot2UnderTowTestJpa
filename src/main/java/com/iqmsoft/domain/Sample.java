package com.iqmsoft.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sample {
	
	@Override
	public String toString() {
		return "Sample [id=" + id + ", text=" + text + ", completed=" + completed + ", value=" + value + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@ManyToOne
	private SampleType type;

	public SampleType getType() {
		return type;
	}

	public void setType(SampleType type) {
		this.type = type;
	}

	private String text;
	private boolean completed;

	private int value;
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Sample() {
	}

	
	
	
	public Sample(Long id, String text, boolean completed, int value) {
		super();
		this.id = id;
		this.text = text;
		this.completed = completed;
		this.value = value;
	}
	
	public Sample(String text, boolean completed, int value) {
	
		this.text = text;
		this.completed = completed;
		this.value = value;
	}
	
    public Sample(Long id, String text, boolean completed, int value, SampleType type) {
		
    	this.id = id;
		this.text = text;
		this.completed = completed;
		this.value = value;
		this.type = type;
	}
	
	public Sample(String text, boolean completed, int value, SampleType type) {
		
		this.text = text;
		this.completed = completed;
		this.value = value;
		this.type = type;
	}
	
	
	public Sample(Long id, String text, boolean completed) {
		super();
		this.id = id;
		this.text = text;
		this.completed = completed;
	}

	public Sample(String text, boolean completed) {
		super();
		this.text = text;
		this.completed = completed;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

}
