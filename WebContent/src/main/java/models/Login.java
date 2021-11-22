package models;

public class Login {

	private  String id ;
	private  String FisrtName ;
	private  String LastName ;
	private  String UserName ;
	private  String Email ;
	private  String Password ;
	private  String Phone ;
	private  String Description;
	public Login()
	{
		
	}
	public Login(String id ,String FistName, String LastName , String Email, String Phone , String Description)
	{	
		this.id=id;
		this.FisrtName=FistName;
		this.LastName=LastName;
		this.Email=Email;
		this.Phone=Phone;
		this.Description=Description;
	}
	public Login(String FistName, String LastName , String Email, String Phone , String Description)
	{	
		
		this.FisrtName=FistName;
		this.LastName=LastName;
		this.Email=Email;
		this.Phone=Phone;
		this.Description=Description;
	}
	public String getDescription()
	{
		return Description;
	}
	public void setDescription(String a)
	{
		this.Description=a;
	}
	public String getID()
	{
		return id;
	}
	public void  setID(String a)
	{
		this.id=a;
	}
	public  String getFirstName ()
	{
		return FisrtName;
	}
	public void setFirstName(String a)
	{
		this.FisrtName=a;
	}
	public String getLastName()
	{
		return LastName;
	}
	public void setLastName(String a)
	{
		this.LastName=a;
	}
	public  String getUserName()
	{
		return UserName;
	}
	public void setUserName(String a)
	{
		this.UserName=a;
	}
	public String getEmail()
	{
		return Email;
	}
	public void setEmail(String a)
	{
		this.Email=a;
	}
	public String getPhone()
	{
		return Phone;
	}
	public void setPhone(String a)
	{
		this.Phone=a;
	}
}
