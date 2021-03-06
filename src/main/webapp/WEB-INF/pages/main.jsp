<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	
  	
  	
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function() {
    //this first function inide the hover method
    //is for when the mouse enters the element
    $('div#hoverDiv').hover(function() {
    	//set multiple CSS properties at once
        $(this).css({
            'background-color': 'blue',
            'color': 'pink'
        });
    }, function() {
    	//set multiple CSS properties at once
        $(this).css({
            'background-color': 'red',
            'color': 'white'
        });
    });
});


</script>
<meta charset="utf-8">
<style type="text/css">
#ViewerContainer {
	overfolw: visible;
	overfolw-y: visible;
	overfolw-x: visible;
	position: relative;	
	margin-left: auto;
	margin-right: auto; 
}
table, th, td {
border: 1px solid black;
}
.right{
 text-align:right; 
}
img{
    width: 200px;
    height: auto;
    object-fit: contain; /* Fit logo in the image size */
        -o-object-fit: contain; /* Fit logo fro opera browser */
    object-position: top; /* Set logo position */
        -o-object-position: top; /* Logo position for opera browser */
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
   

</style>
</head>
<body ng-app="myApp">
<div class="generic-container">
	<div class="panel panel-default">
		<div ng-controller="UserController" >	
		<div class="panel-heading"><span class="lead">Maintenance customer products</span>
		<table class = "table">
		<thead>
      <tr>
         <th>User</th>
      </tr>
   </thead>
   <tbody>
      <tr>
         <td>{{currnetUser[0].user}}</td>
      </tr>
  </tbody>

		</table>
		 </div>
		 
		 </div>
		 
		<div class="formcontainer">	
			<div ng-controller="SourcesFormController"  >	
					<form name="frmsource" >
			<div ng-controller="CompanyController">
				<table border=0 class="table table-hover">
			        <thead>
			           	<tr>
			                 <th class="right">Manufactures</th>
			                 <th>Categories</th>
			             </tr>
			         </thead>
			         <tbody>
			         	<tr>
			         		<td class="right">
								<select size="5" ng-model="selectedCompany" ng-change="changedValue(selectedCompany)">
						       		<option ng-selected= "{{companylist.companyId == selectedCompany}}" data-ng-repeat="companylist in companys" value="{{companylist.companyId}}">{{companylist.companyName}}</option>
						        </select>  
							</td>
							<td>
								<select ng-model="selectedCategories" ng-change="changeValueCategories(selectedCategories)" size="5">
						       		<option data-ng-repeat="categoriesList in categories" value="{{categoriesList.categoriesId}}">{{categoriesList.categoriesName}}</option>
						        </select>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			</form>
			<div class="check-element animate-show-hide" ng-show="showAndHideList(models)">
			  <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of  </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ProductId.</th>
                               <th>Name</th>
                              <th>Info</th>
                              <th>Pris</th>
                              <th>Inch</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in models" ng-model="models">
                              <td><span ng-bind="u.productId"></span></td>
                              <td><span ng-bind="u.modellName"></span></td>
                              <td><span ng-bind="u.infoOfModell"></span></td>
                              <td><span ng-bind="u.modellPris"></span></td>
                              <td><span ng-bind="u.modell_size_name"></span></td>
                              <td>
                              <button type="button" ng-click="edit(u.productId)" class="btn btn-xs custom-width">Edit</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
      		</div>  
          </div> 
       </div>  
              <div class="check-element animate-show-hide" ng-show="isChoiceEmpty(models)">
      		Ingen tr�ff    
      	</div>
      	<div class="check-element animate-show-hide" ng-show="ShowAndHideProduct(HideProduct)">
      			<div class="panel panel-default">
                <!-- Default panel contents -->
              	<div class="panel-heading"><span class="lead">Edit </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ProductId.</th>
                               <th>Name</th>
                              <th>Info</th>
                              <th>Inches</th>
                              <th>Product names </th>
                              <th>Pris</th>
                              <th>Visible</th>
                          </tr>
                      </thead>
                      <tbody>
                      	<tr>
                      		<td><span ng-bind="product.productId"></span></td>
                      		<td><span> <input  ng-model="product.modellName"></span></td>
                      		<td><span> <textarea ng-model="product.modell_info" ></textarea> </span></td>
                      		<td><span> <select ng-model="product.modell_size_id" >
					        		<option ng-selected="{{sizeslist.screenSizeId == product.modell_size_id}}"data-ng-repeat="sizeslist in screenSizes" value="{{sizeslist.screenSizeId}}">{{sizeslist.screenSizeName}}</option>
					        </select></span> </td>
					        <td><span><select ng-model="product.modell_type_id" >
					        		<option ng-selected= "{{equipmentslist.typeId == product.modell_type_id}}"data-ng-repeat="equipmentslist in equipmentsTypes" value="{{equipmentslist.typeId}}">{{equipmentslist.typeName}}</option>
					        	</select></span> </td>
					        <td><span> <input ng-model="product.modellPris"></span></td>
					        <td> 
					        <label>
    						<input type="radio"  name="visible" ng-change="RadioChangeVisible(visibleSelected)" ng-model="visibleSelected" ng-value="1">
    							Show product on search	  						
    						</label><br/>
    						<label>
    						<input type="radio" name="visible" ng-change="RadioChangeVisible(visibleSelected)" ng-model="visibleSelected" ng-value="0">
   								Show not 
  							</label><br/>
					        </td>
                      	</tr>
                      	<tr>
                      		<td colspan="7">
                      			<button type="button" ng-click="saveProduct(product.productId)" class="btn btn-xs custom-width">Save</button>
                      		</td>
                      	</tr>
                      </tbody>
                  </table>
                  		
                  	<table>
                  		<tr> 
                  			<td>
	                  			
	                  		<table id="theTable" border=0 >
						
								<tbody data-ng-repeat="image in images" ng-model="image" $index >
									<tr>
										<td  data-ng-repeat="img in image" item-image ng-model="img" colspan='{{img.colSpan}}' $index>
										<img ng-src="{{img.jspPath}}\img\{{img.name}}" class="w3-round" ng-click="getImgInfo(img)" /></td>	
									</tr>
								</tbody>
							</table>
	                  				
	           				</td>
	           				<td>
	           				<div class="check-element animate-show-hide" ng-show="ShowAndHideImage()">
	           					<table>
	           						<thead>
								         <tr>
								            <th colspan="3">{{copyImage.name}}</th>
								         </tr>
								        </thead>
								         <tr>
								             <td rowspan="3"><img ng-src="{{copyImage.jspPath}}\img\{{copyImage.name}}"/></td>
								            <td colspan="2">
												<label>
    						<input type="radio"  name="visibleimg" ng-change="RadioChangeImage(copyImage.isVisible)"  ng-model="copyImage.isVisible" ng-value="1">
    							Show picture on search 	  						
    						</label><br/>
    						<label>
    						<input type="radio" name="visibleimg" ng-change="RadioChangeImage(copyImage.isVisible)" ng-model="copyImage.isVisible" ng-value="0">
   								Show not picture
  							</label><br/>
					        {{copyImage.isVisible}}
					        {{ServerResponse}}
											
											
											</td>
								         </tr>
								         <tr>
								            <td colspan="2">Prio</td>
								         </tr>
								         <tr>
								            <td></td>
								            <td></td>
								         </tr>	
	           					</table>
	           			</div>
	           				</td>
           				</tr>
           			</table>
      			</div>
	      			<div class="row">
	 					<div class="col-lg-12">
	 					<input type="file" class="thumb" accept="image/*" image="image" onchange="angular.element(this).scope().setFile(this)" style="width:400px"/>
	 					<img ng-src="{{img}}" style="width:200px;">
	 					<label class="col-md-3 control-lable" for="imageName">Name on image</label>
	 					<input type="text" ng-model="imageName"/>
	 					<button type="button" ng-click="saveImage()" class="btn btn-xs custom-width">Spara</button>
	 				</div>
	 				</div>
      				</div>
		 		</div>
			</div>
			<div ng-controller="ImageCropperCtrl as ctrl">
				        <input type="file" img-cropper-fileread image="cropper.sourceImage" />
				        <div>
				             <canvas width="500" height="300" id="canvas" image-cropper image="cropper.sourceImage" cropped-image="cropper.croppedImage" crop-width="400" crop-height="200" keep-aspect="true" touch-radius="30" crop-area-bounds="bounds"></canvas>
				        </div>
				        <div>Cropped Image (Left: {{bounds.left}} Right: {{bounds.right}} Top: {{bounds.top}} Bottom: {{bounds.bottom}})</div>
				        <div ng-show="cropper.croppedImage!=null"><img ng-src="{{cropper.croppedImage}}" /></div>
				    </div>
		</div>
	</div>
</div> 

			
			
			<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.20/angular.js"></script>
  			<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.20/angular-resource.js"></script>
  			<script type="text/javascript" src="<c:url value='/static/js/app.js' />"></script>
  			<script type="text/javascript"  src="<c:url value='/static/js/controller/controller.js' />"></script>
  			<script type="text/javascript" src="<c:url value='/static/js/service/service.js' />"></script> 
  			<script type="text/javascript" src="<c:url value='/static/js/angular-img-cropper.js' />"></script>                


	
</body>
</html>