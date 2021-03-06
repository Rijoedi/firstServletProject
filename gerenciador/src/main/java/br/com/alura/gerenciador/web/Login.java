package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;


@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();
		
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
//		HttpSession session = req.getSession();
//		session.setAttribute("usuarioLogado", usuario);
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/login.jsp");
//		dispatcher.forward(req, resp);
		
		
		if(usuario == null) {
			writer.println("<html><body> Usuario ou senha invalida</body></html>");
		}else {
			HttpSession session = req.getSession();
			session.setAttribute("usuarioLogado", usuario);
			writer.println("<html><body> Usuario logado: " + email + "</body></html>");
		}
		
	//	EXEMPLO DE CODIGO USANDO COOKIE //
//		if(usuario == null) {
//			writer.println("<html><body>Usuario ou senha invalida</body></html>");
//		} else {
//			Cookie cookie = new Cookie("usuario.logado", email);
//			resp.addCookie(cookie);
//			writer.println("<html><body>Usuario logado: " + email + "</body></html>");
		}
}

