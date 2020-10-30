<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Add New Tour</h1>
<form:form method="post" action="save">
    <table >
        <tr>
            <td>TourName : </td>
            <td><form:input path="tourName"/></td>
        </tr>
        <tr>
            <td>Description :</td>
            <td><form:input path="description"/></td>
        </tr>
        <tr>
            <td>Country :</td>
            <td><form:input path="country"/></td>
        </tr>
        <tr>
            <td>Price :</td>
            <td><form:input path="price"/></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Save"/></td>
        </tr>
    </table>
</form:form>