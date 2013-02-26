<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Expense Tracking</title>
</head>
<body>
<h1>Expense Types</h1>
 
<c:url var="addUrl" value="/main/expensetypes/add" />
<table style="border: 1px solid; width: 500px; text-align:center">
 <thead style="background:#fcf">
  <tr>
   <th>Name</th>
   <th>Description</th>
   <th>Status</th>
   
   <th colspan="3"></th>
  </tr>
 </thead>
 <tbody>
 <c:forEach items="${expensetypes}" var="expensetypes">
   <c:url var="editUrl" value="/main/expensetypes/edit?id=${expensetypes.id}" />
   <c:url var="deleteUrl" value="/main/expensetypes/delete?id=${expensetypes.id}" /> 
  <tr>
   <td><c:out value="${expensetypes.name}" /></td>
   <td><c:out value="${expensetypes.description}" /></td>
   <td><c:out value="${expensetypes.status}" /></td>
   
    <td><a href="${editUrl}">Edit</a></td>
   <td><a href="${deleteUrl}">Delete</a></td>
   <td><a href="${addUrl}">Add</a></td> 
  </tr>
 </c:forEach>
 </tbody>
</table>
 
  <c:if test="${empty expensetypes}">
 There are currently no expense types in the list. <a href="${addUrl}">Add</a> an Expense Type.
</c:if>
 
</body>
</html>