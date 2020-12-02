<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="logout-parcial.jsp" />
<h1>Empresa: <c:if test="${not empty empresa ? empresa : 'Teset'}"> ${empresa } </c:if> cadastrada com sucesso!</h1>
<c:forEach var="i" begin="1" end="10" step="2">
       ${i} <br />
     </c:forEach>
</body>
</html>