package br.com.kdev.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.kdev.gerenciador.modelo.Banco;
import br.com.kdev.gerenciador.modelo.Empresa;

/**
 * Servlet implementation class ListaEmpresasServlet
 */
//@WebServlet("/lista-empresas")
public class ListaEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ListaEmpresasServlet() {
		System.out.println("Criando servlet ListaEmpresasServlet");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamando doGEt ListaEmpresasServlet");
		List<Empresa> empresas = new Banco().getEmpresas();		
		request.setAttribute("empresas", empresas);
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
		rd.forward(request, response);
	}

}
