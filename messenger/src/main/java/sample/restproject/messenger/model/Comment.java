package sample.restproject.messenger.model;

import java.util.Date;

public class Comment {

	private long id;
	private String messege;
	private Date created;
	private String author;
	
	public Comment(){
		
	}

	public Comment(long id, String messege, Date created, String author) {
		super();
		this.id = id;
		this.messege = messege;
		this.author = author;
		this.created = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessege() {
		return messege;
	}

	public void setMessege(String messege) {
		this.messege = messege;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
	
}
