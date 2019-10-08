package managedbeans;

import java.nio.file.attribute.UserPrincipalLookupService;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import controller.UsuarioController;
import filter.CodificaSenha;
import model.Usuario;

@ApplicationScoped
@ManagedBean(name="loginBean")
public class LoginBean {
	
	private String nomeUsuario;
	private String senha;
	private UsuarioController usuarioController = null;
	private boolean usuarioLogado;
	
	private FacesContext cfg = null;
	private HttpSession sessao;
	
	public LoginBean() {
		super();
		usuarioController = new UsuarioController();
		cfg = FacesContext.getCurrentInstance();
		sessao = (HttpSession) cfg.getExternalContext().getSession(false);
		usuarioLogado = false;
		sessao.setAttribute("logado", usuarioLogado);
	}
	
	public void autenticar() {
		Usuario user =  usuarioController.buscarPorEmail(nomeUsuario);
		BCryptPasswordEncoder encript = new BCryptPasswordEncoder();
		if(user != null) {
			if (user.getSenha().equals(encript.encode(senha)))
			System.out.println("senha:" + senha);
			System.out.println("senha:banco" + user.getSenha() + "senha:" + CodificaSenha.encrypt.encode(senha));
			
			if(encript.matches(user.getSenha(), CodificaSenha.encrypt.encode(senha))) {
				usuarioLogado = true;
				sessao.setAttribute("logado", usuarioLogado);
				
			}
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

	public UsuarioController getUsuarioController() {
		return usuarioController;
	}

	public void setUsuarioController(UsuarioController usuarioController) {
		this.usuarioController = usuarioController;
	}

	public boolean isUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(boolean usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	

}
