package util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		//ConexaoComBanco.getInstance().close();
	}

}
