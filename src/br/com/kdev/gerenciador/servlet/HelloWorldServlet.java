package br.com.kdev.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/hello")
public class HelloWorldServlet  extends HttpServlet{
	
	public HelloWorldServlet() {
		System.out.println("Criando servlet HelloWorldServlet");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("Hello Servlet");
		out.println("</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hello World</h1>");
		out.println("</body >");
		out.println("</html>");
		
		System.out.println("bla bla");
	}
}
