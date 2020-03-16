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
		<caption>Commandes en attente</caption>
		<thead>
			<tr>
				<th>Nom</th>
				<th>Date</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${commandes}" var="commande">
				<tr>
					<td><c:out value="${commande.nom}" /></td>
					<td>
						<fmt:formatDate type="date" dateStyle="long" value="${commande.dateEmission}" /> 
						<fmt:formatDate type="time" dateStyle="long" value="${commande.dateEmission}" />
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<c:if test="${empty commandes}">
			<tfoot>
				<tr>
					<td colspan="2">Aucune commande en attente pour l'instant</td>
				</tr>
			</tfoot>
		</c:if>
	</table>

	<c:if test="${not empty commandes}">
		<form action="<c:url value="/suivante"/>" method="get">
			<button type="submit">Commande suivante</button>
		</form>
	</c:if>

</body>
</html>
