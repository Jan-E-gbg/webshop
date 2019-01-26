<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style type="text/css">

table.gridtable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
}
table.gridtable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
}
table.gridtable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffffff;
}
</style>

<title>Insert title here</title>
</head>
<body ng-app="myApp">
		<div ng-controller="CostomerController"  >	
		
			<div id="content">
				{{images.lengt}}
				
				<table boder=1 >
				
				<tbody data-ng-repeat="image in images" ng-model="image" $index >
				
					<tr>
					
					<td data-ng-repeat="img in image" ng-model="img" $index>
						<img ng-src="{{img.jspPath}}\img\{{img.imgName}}" ng-click="getImgInfo(img)"/>{{$parent.$index}}
					</td>	
				</tr>
				
				</tbody>
				</table>
				
				
				
			
			</div>
		
		
		</div>

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
  		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-resource.js"></script>
  		<script type="text/javascript" src="<c:url value='/static/js/app.js' />"></script>
  		<script type="text/javascript"  src="<c:url value='/static/js/controller/controller.js' />"></script>
  		<script type="text/javascript" src="<c:url value='/static/js/service/service.js' />"></script> 

</body>
</html>