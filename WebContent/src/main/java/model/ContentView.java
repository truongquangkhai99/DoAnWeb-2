package model;

import java.sql.Date;
import java.sql.Timestamp;

public class ContentView {

	private int id;
	private String title;
	private String brief;
	private String datecreate;
	

	public ContentView(String title, String brief, String datecreate) {
		super();
		this.title = title;
		this.brief = brief;
		this.datecreate = datecreate;
	}
	public ContentView(int id, String title, String brief, String date) {
		super();
		this.id = id;
		this.title = title;
		this.brief = brief;
		this.datecreate = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String  getDatecreate() {
		return datecreate;
	}
	public void setDatecreate(String  datecreate) {
		this.datecreate = datecreate;
	}
}
