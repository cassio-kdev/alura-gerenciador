<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="br.com.kdev.gerenciador.servlet.*, java.util.List" %>
    <%@ taglib uri= "http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="logout-parcial.jsp" />
<h1>Seja bem-vindo ${usuarioLogado.login}</h1> <br><br><br>

<br>
<h2>Lista de empresas</h2>
	<ul>
		<c:forEach items="${empresas}" var="emp">
			<li>ID: ${emp.getId()}, Nome: ${emp.nome} 
				Data: <fmt:formatDate value="${emp.dataAbertura }" pattern="dd/MM/yyyy"/>
				<a href="/alura-gerenciador/entrada?acao=MostraEmpresa&id=${emp.id }">Editar</a>	
				<a href="/alura-gerenciador/entrada?acao=RemoveEmpresa&id=${emp.id }">Remover</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>