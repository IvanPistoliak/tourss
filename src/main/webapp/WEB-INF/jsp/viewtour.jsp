<!doctype html>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
    <c:url value="/css/mainn.css" var="jstlCss" />
    <link href="${jstlCss}" rel="stylesheet" />
    <title>Document</title>
</head>
<body>
    <h1>Tour List</h1>
    <table border="2" width="70%" cellpadding="2">
        <tr><th>Id</th><th>TourName</th><th>Description</th><th>Country</th><th>Price</th><th>Edit</th><th>Delete</th></tr>
        <c:forEach var="tourFirma" items="${list}">
            <tr>
                <td>${tourFirma.id}</td>
                <td>${tourFirma.tourName}</td>
                <td>${tourFirma.description}</td>
                <td>${tourFirma.country}</td>
                <td>${tourFirma.price}</td>
                <td><a href="edittour/${tourFirma.id}">Edit</a></td>
                <td><a href="deletetour/${tourFirma.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="tourform">Add New Tour</a>
</body>
</html>
