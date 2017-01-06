<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 style="color: blue" align="center">${requestScope.Msg }</h2><br/>
<form action="BookAppointment" method="post">

Enter Appointment Date:<input type="date" name="date"><br/>
Enter Time(Appointment will be for 1 hour):<input type="time" name="time"><br/>
<input type="submit" name="submit">
<input type="reset" name="cancel">
</form>
<sql:query dataSource="${cybage}" var="appointment">
        SELECT * from appointment where id="${sessionScope.user.id}";
    </sql:query>
    <table border="1">
        <c:forEach var="row" items="${appointment.rows}">
            <tr><form action="#">
                <td><c:out value="${row.id}" /></td>
                <td><c:out value="${row.date}" /></td>
                <td><c:out value="${row.time}" /></td>
                <td><c:out value="${row.status}" /></td>
            </tr>
        </c:forEach>
    </table> 
</body>
</html>