<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Liste des Fiches de soin de la consultation numéro ${conId}</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Type de Soin</th>
        <th>Temps de traitement (en minutes)</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${fichessoin}" var="fsn">
        <tr>
            <td>${fsn.type_soin}</td>
            <td>${fsn.duree_fi}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="consultation?id=${patId}">Revenir a la liste des consultations</a>
</body>
</html>
