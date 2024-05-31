<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Liste des Consultation du patient numero ${patId}</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Date de consultation</th>
        <th>Nom du medecin</th>
        <th>fiche de soin</th>
        <th>prescription</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${consultations}" var="con">
        <tr>
            <td>${con.datecons}</td>
            <td>${con.nom_medecin}</td>
            <td>
                <form action="fichesoin" method="get">
                    <input type="hidden" name="patId" value="${patId}"/>
                    <input type="hidden" name="conId" value="${con.id}"/>
                    <button type="submit">Voir les fiches de soin</button>
                </form>
            </td>
            <td>
                <form action="prescription" method="get">
                    <input type="hidden" name="patId" value="${patId}"/>
                    <input type="hidden" name="conId" value="${con.id}"/>
                    <button type="submit">Voir les prescriptions</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="patient">Revenir a la liste des patients.</a>
</body>
</html>
