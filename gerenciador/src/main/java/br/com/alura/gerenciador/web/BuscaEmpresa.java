package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

//@WebServlet(urlPatterns="/busca")
public class BuscaEmpresa implements Tarefa {

	
	//Exemplo de Servlet para destruir e inicializar uma servlet, util para saber qtas vezes instanciamos uma servlet e qdo a destruimos
//	public void ini() throws ServletException {
//		super.init();
//		System.out.println("Inicializando a Servlet" + this);
//	}
	
//	public void destroy() {
//		super.destroy();
//		System.out.println("Destruindo a Servlet" + this);
//	}
	
	public BuscaEmpresa () {
		System.out.println("instanciando uma Servlet do tipo BuscaEmpresa" + this);
	}

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		
		String filtro = request.getParameter("filtro");
		Collection<Empresa> empresas = new EmpresaDAO()
				.buscaPorSimilaridade(filtro);
		
		request.setAttribute("empresas", empresas);
		
		return "/WEB-INF/paginas/buscaEmpresa.jsp";
	}
}
	
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
//			throws ServletException, IOException {
		
//		PrintWriter writer = resp.getWriter();
//		writer.println("<html>");
//		writer.println("<body>");
//		writer.println("Resultado da busca:<br/>");
		
//		String filtro = req.getParameter("filtro");
//		Collection<Empresa> empresas = new EmpresaDAO()
//				.buscaPorSimilaridade(filtro);
//		
//		req.setAttribute("empresas", empresas);
//		
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/buscaEmpresa.jsp");
//		dispatcher.forward(req, resp);
		
//		writer.println("<ul>");
//		for (Empresa empresa : empresas) {
//			writer.println("<li>" + empresa.getId() + ":" + empresa.getNome() + "</li>");
//		}
		
		
//		writer.println("</body>");
//		writer.println("</html>");
		