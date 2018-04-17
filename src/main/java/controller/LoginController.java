package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class LoginController implements Serializable{

	private static final long serialVersionUID = 1L;
	private String login;
	private String senha;
	
	
	public String logar() {
		if(login.equals("admin") && senha.equals("123")) {
			return "aluno";
		}
		return "erro";
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
