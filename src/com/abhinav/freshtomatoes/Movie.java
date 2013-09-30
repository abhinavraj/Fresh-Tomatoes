package com.abhinav.freshtomatoes;

import java.io.Serializable;

public class Movie implements Serializable{
	String title;
	String thumnailUrl;
	String userrating;
	String criticrating;
	String mpaarating;
	String runtime;
	String releasedate;
	String profilepicUrl;
	String synopsis;
	
	public Movie(String title) {
		this.title = title;
	}
}
