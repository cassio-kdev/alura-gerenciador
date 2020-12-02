package br.com.kdev.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.kdev.gerenciador.modelo.Banco;
import br.com.kdev.gerenciador.modelo.Empresa;

public class ListaEmpresas implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws  IOException {

		List<Empresa> empresas = new Banco().getEmpresas();
		
		empresas.sort((e1, e2) -> {
			return  e1.getNome().compareTo(e2.getNome());
		});
		
		request.setAttribute("empresas", empresas);
		/*RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
		rd.forward(request, response);*/
		
		return "forward:listaEmpresas.jsp";

	}

}
