<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Expense Tracking</title>
</head>
<body>
 
<h1>Edit Expense</h1>
 
<c:url var="saveUrl" value="/main/expenses/edit?id=${expenseAttribute.id}" />
<form:form modelAttribute="expenseAttribute" method="POST" action="${saveUrl}">
 <table>
  <tr>
   <td><form:label path="id">Id:</form:label></td>
   <td><form:input path="id" disabled="true"/></td>
  </tr>
  
 <tr>
   <td><form:label path="title">Title:</form:label></td>
   <td><form:input path="title"/></td>
  </tr>
 
  <tr>
   <td><form:label path="reimbursable">Reimbursable</form:label></td>
   <td><form:radiobutton path="reimbursable" value="true"/>True 
   <form:radiobutton path="reimbursable" value="false"/>False </td>
  </tr>
   
  <tr>
   <td><form:label path="Paid">Paid</form:label></td>
   <td><form:radiobutton path="paid" value="true"/>True 
   <form:radiobutton path="paid" value="false"/>False </td>
  </tr>
 
  <tr>
   <td><form:label path="total">Total:</form:label></td>
   <td><form:input path="total"/></td>
  </tr>
 
  <tr>
   <td><form:label path="date">Date</form:label></td>
   <td><form:input path="date"/></td>
  </tr>
   
  <tr>
   <td><form:label path="status">Status</form:label></td>
   <td><form:input path="status"/></td>
  </tr>
  
  <tr>
   <td><form:label path="expenseTypeId">Expense Type</form:label></td>
  <td><form:select path="expenseTypeId">
    <c:forEach items="${expenseTypeAttribute}" var="expenseType">
        <form:option value="${expenseType.id}"><c:out value="${expenseType.name}" /></form:option>
    </c:forEach>
    
</form:select></td>
</tr>

 </table>
  
 <input type="submit" value="Save" />
</form:form>
 
</body>
</html>