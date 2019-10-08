package controller;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import dao.UsuarioDao;
import model.Usuario;

public class UsuarioController {
	
	UsuarioDao usuarioDao = null;

	public UsuarioController() {
		super();
		usuarioDao = new UsuarioDao();
	}
	
	
	public Usuario salvar(Usuario usuario) {
		String senha = usuario.getSenha();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		usuario.setSenha(encoder.encode(senha));
		return usuarioDao.save(usuario);
	}
	
	public List<Usuario> listar(){
		return usuarioDao.findAll();
	}
	
	public Usuario atualizar(Usuario usuario) {
		return usuarioDao.update(usuario);
	}
	
	public Usuario deletar(Usuario usuario) {
		return usuarioDao.delete(usuario);
	}
	

}
