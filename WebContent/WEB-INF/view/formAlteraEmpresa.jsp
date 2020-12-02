<%@ taglib uri= "http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:url value="/entrada" var="linkEntrada" />
<%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nova empresa</title>
</head>
<body>
<c:import url="logout-parcial.jsp" />
	<form method="post" action="${linkEntrada }">
	<input type="hidden" name="id" value="${empresa.id }">
	<input type="hidden" name="acao" value="AlteraEmpresa">
		Nome:<input type="text" name="nome" value="${empresa.nome}"><br>
		Data abertura:<input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/>"><br>
		
		<input type="submit" />
	</form>
</body>
</html>