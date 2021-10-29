<%@page import="br.fiap.entidade.Usuario"%>
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

        <form class="forms" action="enviar" method="post">

                <h1>Paciente</h1>
                <p>
                 <% Usuario user = (Usuario)request.getAttribute("usuario"); %> 
                 Seja bem vindo(a), Sr.(a) <%= user.getNome() %> 
                </p>
                
                 <input type="hidden" name="user" value= <%=user.getEmail()%>>

                <label class="data" for="altura"> Altura(metros): </label> <br>
                <input type="text" name="altura" class="texto"> <br>

                <label class="data" for="peso"> Peso(quilo): </label> <br>
                <input type="text" name="peso" class="texto"> <br>


                <input type="radio" id="male" name="sex" value="homem">
                <label for="male" class="teste">Homem</label>
                
                <input type="radio" id="female" name="sex" value="mulher">
                <label for="female" class="teste">Mulher</label><br>

                <input class="bottom" type="submit" value="Enviar Dados">

        </form>
        <form class="forms" action="listarDados" method="post">
        <input type="hidden" name="user" value= <%=user.getEmail()%>>
        <input class="bottom" type="submit" value="Listar Dados">
        </form>

    </div>
</body>
</html>