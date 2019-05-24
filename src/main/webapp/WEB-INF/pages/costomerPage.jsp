<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.js"></script>
  		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular-resource.js"></script>
  		<script type="text/javascript" src="<c:url value='/static/js/app.js' />"></script>
  		<script type="text/javascript"  src="<c:url value='/static/js/controller/controller.js' />"></script>
  		<script type="text/javascript" src="<c:url value='/static/js/service/service.js' />"></script> 
  		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular-animate.js"></script>
		<script src="https://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.13.0.js"></script>
    <link href="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<style type="text/css">

table.gridtable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #666666
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

/* The popup form - hidden by default */
.form-popup {
  display: none;
  position: absolute;
  bottom: 0;
  right: 15px;
  border: 3px solid #f1f1f1;
  z-index: 1;
}

/* Add styles to the form container */
.form-container {
  max-width: 700px;
  padding: 10px;
  background-color: white;
}

/* Full-width table */
.form-container table {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
  resize: none;
  min-height: 200px;
}

/* Set a style for the submit/send button */
.form-container .btn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  margin-bottom:10px;
  opacity: 0.8;
}

/* Add a red background color to the cancel button */
.form-container .cancel {
  background-color: red;
}

/* Add some hover effects to buttons */
.form-container .btn:hover, .open-button:hover {
  opacity: 1;
}

img{
    width: 200px;
    height: auto;
    object-fit: contain; /* Fit logo in the image size */
        -o-object-fit: contain; /* Fit logo fro opera browser */
    object-position: top; /* Set logo position */
        -o-object-position: top; /* Logo position for opera browser */
    }
.content{
   position:fixed;
 left:50%;  
}
.content .wrapper{
  position:relative; 
  left:-50%;
} 


/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 50%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.0); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
    position: relative;
    background-color: #fefefe;
    margin: auto;
    padding: 0;
    border: 1px solid #888;
    width: 80%;
    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19);
    -webkit-animation-name: animatetop;
    -webkit-animation-duration: 0.4s;
    animation-name: animatetop;
    animation-duration: 0.4s
}

/* Add Animation */
@-webkit-keyframes animatetop {
    from {top:-500px; opacity:0} 
    to {top:0; opacity:1}
}

@keyframes animatetop {
    from {top:-500px; opacity:0}
    to {top:0; opacity:1}
}

/* The Close Button */
.close {
    color: white;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}

.modal-header {
    padding: 2px 16px;
    background-color: #5cb85c;
    color: white;
}

.modal-body {padding: 2px 16px;}

.modal-footer {
    padding: 2px 16px;
    background-color: #5cb85c;
    color: white;
}

div.ex1 {
  position: absolute;
  width: 20px;
  height:auto;
  margin: auto;
  border: 3px solid #73AD21;
}

.a {
  position: relative;
  width: auto;
  height: 100%;
}

.b {
  position: absolute;
  left: auto;
  width: 100px;
  height: 100%;
  border: 3px solid blue;
  background-color: blue;
} 

.c {
  position: absolute;
  left: +200px;
  width: auto;
  height: auto;
} 

* {
  box-sizing: border-box;
}
.sidenav {
  height: 100%;
  width: 200px;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: #111;
  overflow-x: hidden;
}

.sidenavright {
  height: 100vh;
  width: 200px; 
  z-index: 1;
  float: right;
  background-color: #111;
  overflow-x: hidden;
}

    html, body {

        height: 100%;

        margin: 0px;
        
        overflow: auto;

    }

</style>

<title>Insert title here</title>
</head>
<body ng-app="myApp">
		<div ng-controller="CostomerController"  >	
			
			
			
			<div id="content" class="a">
			
			
			
					<div class="form-popup" id="myForm">
					<form info-popup class="form-container">
					<table>
						<tr> 
							<td>topp </td>
						</tr>
					
					</table>
					<button type="button" class="btn cancel" ng-click="closePopupInfo()">Close</button>
					
					</form>
				</div>
				
				<div class="sidenav">
				</div>
					<div class="c">
				
						<table id="theTable" border=0 >
						
						<tbody data-ng-repeat="image in images" ng-model="image" $index >
						
							<tr>
							
							<td  data-ng-repeat="img in image" item-image ng-model="img" colspan='{{img.colSpan}}' $index>
								<img ng-src="{{img.jspPath}}\img\{{img.imgName}}" class="w3-round" ng-click="getImgInfo(img)" />					
			
							</td>	
							
						</tr>
						
						</tbody>
						</table>
					</div>
				
		<div id="myModal" class="modal">

		  <div class="modal-content">
		    <div class="modal-header">
		    	<span class="close">&times;</span>
		      <button type="button" class="close" ng-click="closePopupInfo()">Close</button>
		      <h2>{{theProduct.productName}}</h2>
		    </div>
		    <div class="modal-body">
		    <table>
		    	<tr>
		    		<td colspan="2">
		      <img ng-src="{{theProduct.jspPath}}\img\{{theProduct.imgName}}" />
		      		</td>
		      	</tr>
		      	<tr>
		      		<td>
		      {{theProduct.productInfo}}
		      		</td>
		      		<td>
		      		Pris: {{theProduct.prise}}
		      		</td>
		      	</tr>
		    </table>
		    </div>
		    <div class="modal-footer">
		    </div>
		  </div>
		</div>
	
	</div>	

	</div>		
  

</body>
</html>