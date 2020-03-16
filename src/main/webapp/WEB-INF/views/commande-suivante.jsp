<%@page pageEncoding="UTF-8" contentType="text/html"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html id="commande-suivante">
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
  
	<section>
		<h1>Récapitulatif de la commande</h1>
  		<ul>
  			<li>Nom : <c:out value="${commande.nom}"/></li>
  			<li>Téléphone : <c:out value="${commande.telephone}"/></li>
  			<li>Date : <fmt:formatDate type="both" dateStyle="long" value="${commande.dateEmission}"/></li>
  		</ul>
	</section>

	<section>
		<h1>Pizzas à préparer</h1>
		<c:forEach items="${commande.details}" var="d">
			<c:set value="${d.pizza}" var="pizza"/>
			<div>
				<p><c:out value="${pizza.nom}"/></p>
				<p>Ingrédients :
					<c:out value="${pizza.categorie.nom}"/>,
					<c:forEach items="${pizza.ingredients}" var="i" varStatus="loop">
						<c:out value="${i.nom}${loop.last ? '' : ', '}"/>
					</c:forEach>
				</p>
			</div>
		</c:forEach>
	</section>  		

	<form action="<c:url value="/suivante"/>" method="post">
		<input type="hidden" name="id" value="${commande.id}">
		<button type="submit">Commande prête</button>
	</form>
</body>
</html>