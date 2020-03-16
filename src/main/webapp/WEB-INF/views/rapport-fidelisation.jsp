<%@page pageEncoding="UTF-8" isErrorPage="true" contentType="text/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html id="liste-commandes">
<head>
<meta charset="UTF-8">
<title>Pizza Spring</title>
<link rel="stylesheet" href="<c:url value="/style.css"/>">
</head>
<body>
	<nav id="menu">
		<ul>
			<li><a href="<c:url value="/commande"/>">Commander</a></li>
			<li><a href="<c:url value="/preparation"/>">Préparer</a></li>
			<li><a href="<c:url value="/fidelisation"/>">Fidélisation</a></li>
			<li><a href="<c:url value="/rapport"/>">Rapport journalier</a></li>
		</ul>
	</nav>

	<table>
		<caption>Fidélisation</caption>
		<thead>
			<tr>
				<th>Nom</th>
				<th>Nombre de commandes</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${fidelisation}" var="f">
				<tr>
					<td><c:out value="${f.nomClient}" /></td>
					<td><fmt:formatNumber value="${f.nbCommandes}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
