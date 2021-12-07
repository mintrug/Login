package Model;

public class User {
	private String username;
	private String password;
	private String firstName;
	public boolean valid;
	
//	public User(String username, String password) {
//		this.username = username;
//		this.password = password;
//	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		if(username != "") {
			this.username = username;
			this.setValid(true);
		}
		else {
			this.setValid(false);
		}
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		if(password != "") {
			this.password = password;
			this.setValid(true);
		}
		else {
			this.setValid(false);
		}
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		if(firstName != "") {
			this.firstName = firstName;
			this.setValid(true);
		}
		else {
			this.setValid(false);
		}
	}
	
	public boolean isValid() {
        return valid;
	}

    public void setValid(boolean newValid) {
        valid = newValid;
	}	
}
