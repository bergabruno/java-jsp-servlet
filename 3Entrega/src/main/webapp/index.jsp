<%@page import="br.fiap.dao.UsuarioDAO"%>
<%@page import="br.fiap.dao.PacienteDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="style.css">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <div class="container">

        <form class="forms" action="entrar" method="post">
        
       
            <label class="data" for="email"> Email: </label> <br>
            <input type="text" name="email" class="texto" > <br>

            <label class="data" for="senha"> Senha: </label><br>
			<input type="password" name="senha" placeholder="Digite sua Senha" class="texto">	
            <br>

            <input class="bottom" type="submit" value="Logar">
        </form>
        
        <a href="cadastro.html" > <button class="botao" >Ainda não sou cadastrado</button></a>

    </div>

</body>
</html>