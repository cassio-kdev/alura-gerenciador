package br.com.kdev.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.kdev.gerenciador.modelo.Banco;
import br.com.kdev.gerenciador.modelo.Empresa;

public class NovaEmpresa implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String nome = request.getParameter("nome");
		String dataAberturaEmpresa = request.getParameter("data");
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		
		Banco banco = new Banco();
		Empresa empresa = new Empresa();
			try {
				empresa = new Empresa(banco.getGeraId() ,nome,format.parse(dataAberturaEmpresa));
			} catch (ParseException e) {
				throw new IOException(e);
			}
	
		banco.adiciona(empresa);
		request.setAttribute("empresa", empresa.getNome());
		
		return "redirect:entrada?acao=ListaEmpresas";
	}
}
