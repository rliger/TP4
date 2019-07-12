<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="menu">
    <p><a href="<c:url value="/creationClient"/>">Créer un nouveau client</a></p>
    <p><a href="<c:url value="/creationCommande"/>">Créer une nouvelle commande</a></p>
    <p><a href="<c:url value="/listerClients"/>">Voir les clients existants</a></p>
    <p><a href="<c:url value="/listerCommandes"/>">Voir les commandes existantes</a></p>
</div>