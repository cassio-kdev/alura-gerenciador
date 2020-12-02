<%@ taglib uri= "http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:url value="/entrada" var="linkNovaEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nova empresa</title>
</head>
<body>
<c:import url="logout-parcial.jsp" />
	<form method="post" action="${linkNovaEmpresa }">
	<input type="hidden" name="acao" value="NovaEmpresa">
		Nome:<input type="text" name="nome"><br>
		Data abertura:<input type="text" name="data"><br>
		
		<input type="submit" />
	</form>
</body>
</html>