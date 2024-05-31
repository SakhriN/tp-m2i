<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Liste des patients</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Nom du patient</th>
        <th>Prenom du patient</th>
        <th>Photo du patient</th>
        <th>Date de Naissance du patient</th>
        <th>Informations supplémentaires</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${patients}" var="pat">
    <tr>
            <td>${pat.nom}</td>
            <td>${pat.prenom}</td>
            <td><img src="${pat.photo}" height="200" width="200"/></td>
        <td>${pat.dateNais}</td>
        <td>
            <form action="consultation" method="get">
                <input type="hidden" name="id" value="${pat.id}"/>
                <button type="submit">Voir ses consultations</button>
            </form>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>



</body>
</html>
