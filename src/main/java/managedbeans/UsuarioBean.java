package managedbeans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import controller.UsuarioController;
import model.Telefone;
import model.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioBean {
	
	private String nome;
	private String email;
	private String senha;
	private List<Telefone> telefones;
	private List<Usuario> usuarios;
	private Usuario usuario;
	private int dddCelular;
	private int dddFixo;
	private String numeroCelular;
	private String numeroFixo;
	
	private UsuarioController usuarioController = null;
	
	
	public UsuarioBean() {
		super();
		usuarioController = new UsuarioController();
		listar();
	}


	public UsuarioBean(String nome, String email, String senha, ArrayList<Telefone> telefones) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefones = telefones;
	}
	
	
	public void salvar() {
		telefones = new ArrayList<Telefone>();
		Telefone telefoneFixo = new Telefone(dddFixo,numeroFixo,"Fixo");
		Telefone tefoneCelular = new Telefone(dddCelular,numeroCelular,"Celular");
		telefones.add(tefoneCelular);
		telefones.add(telefoneFixo);
		Usuario usuario = new Usuario(nome,email,senha,telefones);
		usuarioController.salvar(usuario);
		listar();
	}
	
	public void listar() {
			usuarios = usuarioController.listar();
	}
	
	public void deletar(Usuario usuario) {
		usuarioController.deletar(usuario);
		listar();
	}
	
	public void atualizar() {
		usuario = new Usuario(nome,email,senha,telefones);
		usuarioController.atualizar(usuario);
		listar();
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public List<Telefone> getTelefones() {
		return telefones;
	}


	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}


	public List<Usuario> getUsuarios() {
		return usuarios;
	}


	public UsuarioController getUsuarioController() {
		return usuarioController;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public int getDddCelular() {
		return dddCelular;
	}


	public void setDddCelular(int dddCelular) {
		this.dddCelular = dddCelular;
	}


	public int getDddFixo() {
		return dddFixo;
	}


	public void setDddFixo(int dddFixo) {
		this.dddFixo = dddFixo;
	}


	public String getNumeroCelular() {
		return numeroCelular;
	}


	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}


	public String getNumeroFixo() {
		return numeroFixo;
	}


	public void setNumeroFixo(String numeroFixo) {
		this.numeroFixo = numeroFixo;
	}


	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}


	public void setUsuarioController(UsuarioController usuarioController) {
		this.usuarioController = usuarioController;
	}
	
	
	
	
	

}
