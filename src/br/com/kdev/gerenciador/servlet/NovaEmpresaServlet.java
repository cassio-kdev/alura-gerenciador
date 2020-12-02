package br.com.kdev.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.kdev.gerenciador.modelo.Banco;
import br.com.kdev.gerenciador.modelo.Empresa;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
//@WebServlet("/nova-empresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String dataAberturaEmpresa = request.getParameter("data");
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		
		Banco banco = new Banco();
		Empresa empresa = new Empresa();
		try {
			empresa = new Empresa(banco.getGeraId() ,nome,format.parse(dataAberturaEmpresa));
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		banco.adiciona(empresa);
		
		response.sendRedirect("lista-empresas");
		
		//chama pagina JSP
//		RequestDispatcher rd = request.getRequestDispatcher("/lista-empresas");
//		request.setAttribute("empresa", empresa.getNome());
//		rd.forward(request, response);
	}

}
