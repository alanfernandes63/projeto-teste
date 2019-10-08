package dao;

import model.Usuario;

public class UsuarioDao extends GenericDaoHibernate<Usuario, Long>{

	public UsuarioDao() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
	}	
}
