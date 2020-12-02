package br.com.kdev.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.kdev.gerenciador.modelo.Banco;
import br.com.kdev.gerenciador.modelo.Usuario;

public class Login implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new Banco().validaUsuario(login,senha);
		
		if(usuario != null) {
			System.out.println(usuario.toString());
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", usuario);
			return "redirect:entrada?acao=ListaEmpresas";
		}
		return "redirect:entrada?acao=ListaLogin";
	}

}
