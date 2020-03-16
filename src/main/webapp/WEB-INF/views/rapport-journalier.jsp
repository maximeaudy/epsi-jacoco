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
		<caption>Rapport journalier</caption>
		<thead>
			<tr>
				<th>Categorie</th>
				<th>Nombre de pizzas</th>
				<th>Montants encaissés</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${rapport}" var="r">
				<tr>
					<td><c:out value="${r.categorie.nom}" /></td>
					<td><fmt:formatNumber value="${r.nbPizzas}"/></td>
					<td><fmt:formatNumber value="${r.montantEncaisse / 100}" type="currency" currencyCode="EUR"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
