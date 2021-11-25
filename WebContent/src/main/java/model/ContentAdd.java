package model;

public class ContentAdd {
	protected String AuthorId;
    protected String title;
    protected String brief;
    protected String content;

    public ContentAdd() {}

   public ContentAdd (String title, String brief, String content) {
		super();
		this.title = title;
        this.brief = brief;
		this.content = content;
	}

    public ContentAdd (String id, String title, String brief, String content) {
		super();
		this.AuthorId = id;
		this.title = title;
		this.brief = brief;
		this.content = content;
	}

	public String getAuthorId() {
		return AuthorId;
	}

	public void setAuthorId(String authorId) {
		AuthorId = authorId;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	

}
