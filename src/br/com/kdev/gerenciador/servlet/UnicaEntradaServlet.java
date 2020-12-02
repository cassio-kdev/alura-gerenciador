package br.com.kdev.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.kdev.gerenciador.acao.Acao;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");
		HttpSession sessao = request.getSession();
		
		boolean isUsuarioLogado = sessao.getAttribute("usuarioLogado") == null;
		boolean isAcaoProtegida = paramAcao.equals("Login") || paramAcao.equals("LoginForm");
		
		if(!isAcaoProtegida && isUsuarioLogado) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}


		String nomeDaClasse = "br.com.kdev.gerenciador.acao." + paramAcao;
		String nome = null;
		try {
			Class classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String[] tipoDeRota = nome.split(":");
		if (tipoDeRota[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoDeRota[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect("entrada?acao=ListaEmpresas");
		}

		/*
		 * if(paramAcao.equals("ListaEmpresas")) { ListaEmpresas lista = new
		 * ListaEmpresas(); nome = lista.executa(request,response); }else
		 * if(paramAcao.equals("MostraEmpresa")) { MostraEmpresa mostra = new
		 * MostraEmpresa(); nome = mostra.executa(request,response); }else
		 * if(paramAcao.equals("RemoveEmpresa")) { RemoveEmpresa remove = new
		 * RemoveEmpresa(); nome = remove.executa(request,response); }else
		 * if(paramAcao.equals("AlteraEmpresa")) { AlteraEmpresa altera = new
		 * AlteraEmpresa(); nome = altera.executa(request,response); }else
		 * if(paramAcao.equals("NovaEmpresa")) { NovaEmpresa remove = new NovaEmpresa();
		 * nome = remove.executa(request,response); }else
		 * if(paramAcao.equals("NovaEmpresaForm")) { NovaEmpresaForm nova = new
		 * NovaEmpresaForm(); nome = nova.executa(request,response); }
		 */

//		String[] tipoDeRota = nome.split(":");
//		if(tipoDeRota[0].equals("forward")) {
//		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+tipoDeRota[1]);
//		rd.forward(request, response);
//		}else {
//			response.sendRedirect("entrada?acao=ListaEmpresas");
//		}
	}

}
