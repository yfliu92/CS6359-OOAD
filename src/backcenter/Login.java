package backcenter;

/**
 * 
 * @author mehra
 * This is the Customer before the validation.
 */
public class Login {
	private String id;
	private String password;
	
	public Login(String id, String pass){
		this.id = id;
		this.password = pass;
	}
	public String getId() {
		return id;
	}
	public void setUsername(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
