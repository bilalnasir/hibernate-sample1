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
<h1>Expenses</h1>
 
<c:url var="addUrl" value="/main/expenses/add" />
<table style="border: 1px solid; width: 500px; text-align:center">
 <thead style="background:#fcf">
  <tr>
   <th>Title</th>
   <th>Reimbursable</th>
   <th>Paid</th>
   <th>Total</th>
   <th>Date</th>
   <th>Status</th>
   <th colspan="3"></th>
  </tr>
 </thead>
 <tbody>
 <c:forEach items="${expenses}" var="expenses">
   <c:url var="editUrl" value="/main/expenses/edit?id=${expenses.id}" />
   <c:url var="deleteUrl" value="/main/expenses/delete?id=${expenses.id}" /> 
  <tr>
   <td><c:out value="${expenses.title}" /></td>
   <td><c:out value="${expenses.reimbursable}" /></td>
   <td><c:out value="${expenses.paid}" /></td>
    <td><c:out value="${expenses.total}" /></td>
   <td><c:out value="${expenses.date}" /></td>
   <td><c:out value="${expenses.status}" /></td>
    <td><a href="${editUrl}">Edit</a></td>
   <td><a href="${deleteUrl}">Delete</a></td>
   <td><a href="${addUrl}">Add</a></td> 
  </tr>
 </c:forEach>
 </tbody>
</table>
 
  <c:if test="${empty expenses}">
 There are currently no expenses in the list. <a href="${addUrl}">Add</a> an Expense.
</c:if>
 
</body>
</html>