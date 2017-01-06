<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<c:if test="${sessionScope.user eq null }">
	
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<sql:query dataSource="${cybage}" var="appointment">
        SELECT * from appointment;
    </sql:query>
    <table border="1">
        <c:forEach var="row" items="${appointment.rows}">
            <tr><form action="#">
                <td><c:out value="${row.id}" name="id" /></td>
                <td><c:out value="${row.date}" /></td>
                <td><c:out value="${row.time}" /></td>
                <td><c:out value="${row.status}" /></td>
                <input type="button"  name="accept">
                <input type="button"  name="reject">
            </tr>
        </c:forEach>
        <c:if test="button eq accept" >
       	<% int a=(Integer)request.getAttribute("id");%>
	<sql:query dataSource="${cybage}" var="appointment">
        update appointment set status='accept' where id=a;
    </sql:query>
     </c:if>
      <c:if test="button eq reject" >
       	<% int a=(Integer)request.getAttribute("id");%>
	<sql:query dataSource="${cybage}" var="appointment">
        update appointment set status='reject' where id=a;
    </sql:query>
     </c:if>
    </table>  
</body>
</html>