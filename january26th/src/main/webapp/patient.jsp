<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Liste des patients</title>
</head>
<body>
<c:forEach items="${patients}" var="pat">
    <div>${pat.getNom}</div>
    <div>${pat.getPrenom}</div>
    <img src="${pat.getPhoto}"/>
</c:forEach>


</body>
</html>
