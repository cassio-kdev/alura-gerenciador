package br.com.kdev.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sessao = request.getSession();
//		sessao.removeAttribute("usuarioLogado");
		sessao.invalidate();
		return "redirect:entrada?acao=LoginForm";
	}

}
