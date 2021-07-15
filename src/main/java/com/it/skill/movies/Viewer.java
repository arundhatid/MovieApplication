package com.it.skill.movies;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="viewer")
public class Viewer {

	
	@Id
	@Column(name="viewerid")
	private Integer viewerid;
	@Column(name="mno")
	private Integer mno;
	@Column(name="rating")
	private Integer rating;
	@Column(name="comment")
	private String comment;
	
	public Viewer() {}
	
	public Viewer(Integer viewerid, Integer mno, Integer rating, String comment) {
		super();
		this.viewerid = viewerid;
		this.mno = mno;
		this.rating = rating;
		this.comment = comment;
	}

	public Integer getViewerid() {
		return viewerid;
	}

	public void setViewerid(Integer viewerid) {
		this.viewerid = viewerid;
	}

	public Integer getMno() {
		return mno;
	}

	public void setMno(Integer mno) {
		this.mno = mno;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Viewer [viewerid=" + viewerid + ", mno=" + mno + ", rating=" + rating + ", comment=" + comment + "]";
	}
	
	
}
