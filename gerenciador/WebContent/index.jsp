<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	Bem vindo ao nosso gerenciador de empresas!
	<br />
	<c:if test="${not empty usuarioLogado}">
		Voce esta logado como ${usuarioLogado.email}<br />
	</c:if>
	<br />

	<form action="executa?tarefa=NovaEmpresa" method="post">
		Nome: <input type="text" name="nome"><br /> <input
			type="submit" value="Enviar"> <br />
	</form>

	<form action="login" method="post">
		Email:<input type="text" name="email"><br /> Senha: <input
			type="password" name="senha"><br /> <input type="submit"
			value="Login"> <br />
	</form>

	<form action="executa?tarefa=Logout" method="POST">
		<input type="submit" value="Deslogar">
	</form>

</body>
</html>