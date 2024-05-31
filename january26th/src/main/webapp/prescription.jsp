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
        <th>Type de Medicament</th>
        <th>Temps d'activation du médicament (en minutes)</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${prescriptions}" var="psp">
        <tr>
            <td>${psp.type_medicament}</td>
            <td>${psp.duree_pr}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="consultation?id=${patId}">Revenir a la liste des consultations</a>
</body>
</html>
