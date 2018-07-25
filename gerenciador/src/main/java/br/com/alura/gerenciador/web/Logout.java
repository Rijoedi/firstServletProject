package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet(urlPatterns="/logout")
public class Logout implements Tarefa {

	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
//		HttpSession session = req.getSession();
		
//		session.removeAttribute("usuarioLogado");
//		 
				
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/logout.html");
//		dispatcher.forward(req, resp);

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		
		return "/WEB-INF/paginas/logout.html";
	}

}

//Metodo antigo de fazer o HTML aqui no proprio servlet		
//PrintWriter writer = resp.getWriter();
//writer.println("<html><body> Logout efetuado</body></html>");


//	EXEMPLO de cookie no cliente para manter o usuario logado.//
//	Cookie cookie = new Cookies(req.getCookies()).getUsuarioLogado();
//	
//	if(cookie != null) {
//		cookie.setMaxAge(0);
//		resp.addCookie(cookie);
//	}
//	
//	PrintWriter writer = resp.getWriter();
//	writer.println("<html><body>Logout efetuado </bnody></html>");
//}