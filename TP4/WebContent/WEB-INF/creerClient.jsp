<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'un client</title>
        <link type="text/css" rel="stylesheet" href="<c:url value = "/inc/style.css"/>"/>
    </head>
    <body>
    <c:import url="/inc/menu.jsp"/>
        <div>
            <form method="post" action="creationClient">
                <c:import url="/inc/inc_client_form.jsp"/>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
                <p class="erreur">${formClient.resultat}</p>
            </form>
        </div>
    </body>
</html>