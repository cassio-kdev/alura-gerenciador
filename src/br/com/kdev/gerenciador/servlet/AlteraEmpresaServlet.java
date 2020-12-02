package br.com.kdev.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.kdev.gerenciador.modelo.Banco;
import br.com.kdev.gerenciador.modelo.Empresa;

/**
 * Servlet implementation class AlteraEmpresaServlet
 */
//@WebServlet("/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AlteraEmpresaServlet");
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String dataAberturaEmpresa = request.getParameter("data");
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		Date data = null;
		try {
			data = format.parse(dataAberturaEmpresa);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Banco banco = new Banco();
		Empresa empresa = new Empresa(Integer.valueOf(id), nome,data);
		banco.editar(empresa);
		
		response.sendRedirect("lista-empresas");
	}

}
