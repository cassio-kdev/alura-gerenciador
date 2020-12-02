<%@ taglib uri= "http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:url value="/entrada" var="linkLogin" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nova empresa</title>
</head>
<body>
	<form method="post" action="${linkLogin }">
	
					<input type="hidden" name="acao" value="Login">
	
		Login:<input type="text" name="login"><br>
		Senha:<input type="password" name="senha"><br><br>
		
		<input type="submit" />
	</form>
</body>
</html>