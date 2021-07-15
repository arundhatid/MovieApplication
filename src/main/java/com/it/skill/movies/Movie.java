package com.it.skill.movies;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movie")
public class Movie {

	@Id
	@Column(name="mno")
	private Integer mno;
	@Column(name="mname")
	private String mname;
	@Column(name="rating")
	private Integer rating;
	@Column(name="genre")
	private String genre;
	
	public Movie() {}

	
	
	public Movie(Integer mno, String mname, Integer rating, String genre) {
		super();
		this.mno = mno;
		this.mname = mname;
		this.rating = rating;
		this.genre = genre;
	}



	public Integer getMno() {
		return mno;
	}

	public void setMno(Integer mno) {
		this.mno = mno;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Movie [mno=" + mno + ", mname=" + mname + ", rating=" + rating + ", genre=" + genre + "]";
	}

	
		
		
}
