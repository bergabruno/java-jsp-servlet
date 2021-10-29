<%@page import="br.fiap.entidade.Paciente"%>
<%@page import="br.fiap.dao.PacienteDAO"%>
<%@page import="br.fiap.entidade.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style>
#customers {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#customers td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #04AA6D;
	color: white;
}
</style>



<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Pacientes:</h1>
	<table id="customers">
		<tr style="border: solid black 1px">
			<th>Nome:</th>
			<th>Email:</th>
			<th>Peso:</th>
			<th>Altura:</th>
			<th>Genero:</th>
			<th>IMC:</th>
			<th>Situacao:</th>
			<th>Peso Ideal:</th>
		</tr>


		<%
		List<Usuario> lista = (List<Usuario>) request.getAttribute("lista");
		PacienteDAO dao = new PacienteDAO();
		List<Paciente> pacientes = dao.obterTodos();
		double imc;
		Paciente paciente = null;
		for (int i = 0; i < lista.size(); i++) {

		  if (lista.get(i).getTipoUsuario().equalsIgnoreCase("administrador")) {
		  } else {
		    paciente = dao.buscarPorEmail(lista.get(i).getEmail());
		%>
		<div>
			<%
			//calculo do imc
			imc = Math.round(paciente.getPeso() / (Math.pow(paciente.getAltura(), 2)));
			String imcIdeal = "";

			if (imc < 20) {
			  imcIdeal = "Abaixo do peso";
			} else if (imc >= 20 && imc < 25) {
			  imcIdeal = "Normal";
			} else if (imc >= 25 && imc < 30) {
			  imcIdeal = "Excesso de peso";
			} else {
			  imcIdeal = "Obesidade";
			}

			//calculo do pesoIdeal
			double pesoIdeal;
			if (!lista.get(i).getTipoUsuario().equalsIgnoreCase("mulher")) {
			  pesoIdeal = Math.round(72.7 * paciente.getAltura() - 58);
			} else {
			  pesoIdeal = Math.round(62.1 * paciente.getAltura() - 44.7);
			}
			%>

			<tr>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getEmail()%></td>
				<td><%=paciente.getPeso()%></td>
				<td><%=paciente.getAltura()%></td>
				<td><%=paciente.getGenero()%></td>
				<td><%=imc%></td>
				<td><%=imcIdeal%></td>
				<td><%=pesoIdeal%></td>
			</tr>

		</div>
		<%
		}
		}
		%>
	</table>

</body>
</html>