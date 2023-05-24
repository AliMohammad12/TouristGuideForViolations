package Model;

public class User {
	private int Id;
	private Account account;
	private Role role;
	
	public User() {}
	
	public User(int id, Account account, Role role) {
		super();
		Id = id;
		this.account = account;
		this.role = role;
	}
	
	public int getId() {
		return Id;
	}
	
	public void setId(int id) {
		Id = id;
	}
	
	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
}
