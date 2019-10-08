package managedbeans;

import javax.faces.bean.ManagedBean;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import controller.UsuarioController;
import filter.CodificaSenha;
import model.Usuario;

@ManagedBean
public class LoginBean {
	
	private String nomeUsuario;
	private String senha;
	private UsuarioController usuarioController = null;
	
	
	
	public LoginBean() {
		super();
		usuarioController = new UsuarioController();
	}
	
	public void autenticar() {
		Usuario user =  usuarioController.buscarPorEmail(nomeUsuario);
		BCryptPasswordEncoder encript = new BCryptPasswordEncoder();
		if(user != null) {
			//if (user.getSenha().equals(encript.encode(senha)))
			System.out.println("senha:" + senha);
			System.out.println("senha:banco" + user.getSenha() + "senha:" + CodificaSenha.encrypt.encode(senha));
			
			if(encript.matches(user.getSenha(), CodificaSenha.encrypt.encode(senha)))
				System.out.println("logado");
			else 
				System.out.println("senha incorreta!");
		}
		else
			System.out.println("usuario não encontrado!");
	}
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
