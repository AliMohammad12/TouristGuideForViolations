package Model;

public class Account {
	private long Id;
	private String userName;
	private String password;
	
	public Account() {}
	
	public Account(long id, String userName, String password) {
		super();
		Id = id;
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
