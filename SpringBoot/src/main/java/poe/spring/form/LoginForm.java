package poe.spring.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginForm {

	@NotNull
	@Size(min=2, max=20)
	private String login;
	@NotNull
	@Size(min=1)
	private String password;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}
