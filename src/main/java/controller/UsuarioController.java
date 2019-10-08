package controller;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import dao.UsuarioDao;
import filter.CodificaSenha;
import model.Usuario;

public class UsuarioController {
	
	UsuarioDao usuarioDao = null;

	public UsuarioController() {
		super();
		usuarioDao = new UsuarioDao();
	}
	
	
	public Usuario salvar(Usuario usuario) {
		String senha = usuario.getSenha();
		CodificaSenha.encrypt.encode(senha);
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
	
	public Usuario buscarPorEmail(String email) {
		return usuarioDao.findByUserName(email);
	}
	

}
