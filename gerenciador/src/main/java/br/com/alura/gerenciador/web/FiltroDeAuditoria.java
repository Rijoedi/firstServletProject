package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpSession session = req.getSession();
		Usuario usuariologado = (Usuario) session.getAttribute("usuarioLogado");
		
		String usuario = "<deslogado>";
		
		if (usuariologado != null) {
			usuario = usuariologado.getEmail();

		}

		System.out.println("Usuario " + usuario + " acessando a URI " + req.getRequestURI());

		chain.doFilter(request, response);

	}
}

// EXEMPLO USANDO COOKIE//
//HttpServletResponse resp = (HttpServletResponse) response;
//
//Cookie cookie = new Cookies(req.getCookies()).getUsuarioLogado();
//String usuario = "<deslogado>";
//
//if (cookie != null) {
//	usuario = cookie.getValue();
//	cookie.setMaxAge(10);
//	resp.addCookie(cookie);
//
