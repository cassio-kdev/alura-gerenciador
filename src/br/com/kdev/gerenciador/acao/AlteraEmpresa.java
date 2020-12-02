package br.com.kdev.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.kdev.gerenciador.modelo.Banco;
import br.com.kdev.gerenciador.modelo.Empresa;

public class AlteraEmpresa implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {

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
		
//		response.sendRedirect("entrada?acao=ListaEmpresas");		
		return "redirect:entrada?acao=ListaEmpresas";
	}

}
