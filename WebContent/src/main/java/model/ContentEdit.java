package model;

import java.util.Date;

public class ContentEdit {
	private int id;
	private String title;
	private String brief;
	private Date datecreate;
	

	public ContentEdit(String title, String brief, Date datecreate) {
		super();
		this.title = title;
		this.brief = brief;
		this.datecreate = datecreate;
	}
	public ContentEdit(int id, String title, String brief, Date date) {
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
	public Date  getDatecreate() {
		return datecreate;
	}
	public void setDatecreate(Date  datecreate) {
		this.datecreate = datecreate;
	}
}
