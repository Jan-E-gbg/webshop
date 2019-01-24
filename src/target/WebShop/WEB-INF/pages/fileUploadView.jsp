<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Spring MVC File Upload</title>
    </head>
    <body>
        <h2>Submitted Files</h2>
        <table>
     			 
                <tr>
                    <td>OriginalFileName:</td>
                    <td>${fileName}</td>
                </tr>
                <tr>
                    <td>Type:</td>
                    <td>${files.contentType}</td>
                </tr>
                <tr>
                	<td> Description </td>
                	<td> ${description} </td>
                </tr>
                <tr>
                	<td><img alt="" src="${filePath}/img/${fileName}"/></td>
              </tr>
        </table>
    </body>
</html> 