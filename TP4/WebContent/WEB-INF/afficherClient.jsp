<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Affichage d'un client</title>
<link type="text/css" rel="stylesheet" href="<c:url value = "inc/style.css"/>"/>
</head>
<body>
	<c:import url="../inc/menu.jsp" />
			<p class="info">Client créé avec succès !</p>


			<%-- Puis affichage des données enregistrées dans le bean "client" transmis par la servlet --%>
			<p>
				Nom :
				<c:out value="${ client.nom }" />
			</p>
			<p>
				Prénom :
				<c:out value="${ client.prenom }" />
			</p>
			<p>
				Adresse :
				<c:out value="${ client.adresse }" />
			</p>
			<p>
				Numéro de téléphone :
				<c:out value="${ client.telephone }" />
			</p>
			<p>
				Email :
				<c:out value="${ client.email }" />
			</p>
</body>
</html>