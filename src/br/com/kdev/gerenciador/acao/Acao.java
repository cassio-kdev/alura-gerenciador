package br.com.kdev.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
