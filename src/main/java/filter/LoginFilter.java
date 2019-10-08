package filter;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginFilter implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		FacesContext fct = FacesContext.getCurrentInstance();
		HttpSession sessao = (HttpSession) req.getSession();
		boolean logado =  (Boolean) sessao.getAttribute("logado");
		//boolean logado = (Boolean) fct.getExternalContext().getApplicationMap().get("logado");
		System.out.println(logado);
		String url = req.getRequestURL().toString();
		//if(url.contains("/restrito") && logado == true) { 
			System.out.println("logado pode passar");
			//res.sendRedirect(req.getSession().getServletContext().getContextPath() + "/restrito/listarUsuario.xhtml");
		//req.getRequestDispatcher(req.getSession().getServletContext().getContextPath() + "/restrito/listarUsuario.xhtml);
			//}
		//else System.out.println("deslogado");
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
