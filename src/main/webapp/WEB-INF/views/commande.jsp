<%@page pageEncoding="UTF-8" contentType="text/html"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html id="commande">
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

	<form:form servletRelativeAction="/commande" modelAttribute="commandeDto" acceptCharset="utf-8">
		<div>
			<label>Pizza : </label>
			<form:select path="pizzaId" multiple="true">
				<form:options items="${pizzas}" itemLabel="nom" itemValue="id"/>				
			</form:select>
			<form:errors cssClass="error" path="pizzaId" />
		</div>
		<div>
			<label>Nom : </label>
			<form:input path="nom" />
			<form:errors cssClass="error" path="nom" />
		</div>
		<div>
			<label>Téléphone : </label>
			<form:input path="telephone" />
			<form:errors cssClass="error" path="telephone" />
		</div>
		<button type="submit">Commander</button>
	</form:form>
  </body>
</html>