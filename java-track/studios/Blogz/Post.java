package Blogz;

import java.util.Date;

public class Post {
	
	private String title;
	private String body;
	private String author;
	private final Date created;
	private Date modified;
	
	public Post(String t, String b, String a){
		this.title = t;
		this.body = b;
		this.author = a;
		this.created = new Date();
		this.modified = new Date();
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public String getBody(){
		return this.body;
	}
	
	public String getAuthor(){
		return this.author;
	}
	
	public Date getCreatedDate(){
		return this.created;
	}
	
	public Date getModifiedDate(){
		return this.modified;
	}
	
	public void setTitle(String newTitle){
		this.title = newTitle;
		this.modified = new Date();
	}
	
	public void setBody(String newBody){
		this.body = newBody;
		this.modified = new Date();
	}

}
