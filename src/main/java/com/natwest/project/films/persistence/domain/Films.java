package com.natwest.project.films.persistence.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Films {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String title;
	private String type;
	private int duration;

	public Films() {
		super();

	}

	public Films(Long id, String title, String type, int duration) {
		super();
		Id = id;
		this.title = title;
		this.type = type;
		this.duration = duration;
	}

	public Films(String title, String type, int duration) {
		super();
		this.title = title;
		this.type = type;
		this.duration = duration;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	@Override
	public String toString() {
		return "Films [Id=" + Id + ", title=" + title + ", type=" + type + ", duration=" + duration + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, duration, title, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Films other = (Films) obj;
		return Objects.equals(Id, other.Id) && duration == other.duration && Objects.equals(title, other.title)
				&& Objects.equals(type, other.type);
	}
	
	
	
}
