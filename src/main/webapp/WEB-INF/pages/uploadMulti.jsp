<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Upload/Download/Delete Documents</title>
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<div class="generic-container">
        <div class="panel panel-default">
              <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">Upload a document </span></div>
<form:form method="POST" action="${pageContext.request.contextPath}/multifilesave" enctype="multipart/form-data">
    <table>
        <tr>
            <td>Select a fie to upload</td>
            <td><input type="file" name="file" class="form-control input-sm"></td>
        </tr>
        <tr>
        	<td> Description </td>
        	<td><input type="text" name="description"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Upload" class="btn btn-primary btn-sm" /></td>
        </tr>
    </table>
</form:form>
	</div>
</div>
	
</body>
</html>