package util;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoComBanco {
	
	private static EntityManagerFactory factory;
	
	private ConexaoComBanco() {
	}
	
	public static EntityManagerFactory getInstance() {
		if(factory == null) {
			factory = Persistence.createEntityManagerFactory("usuarios");
			return factory;
		}
			return factory;
	}

}
