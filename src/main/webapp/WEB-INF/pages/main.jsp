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
					<table border=0 class="table table-hover">
			        	<thead>
			           		<tr>
			                 <th>Manufactures</th></tr>
			         	</thead>
			         	<tbody>
			         		<tr>
			         			<td>
								<div ng-controller="CompanyController">
								<select ng-model="selectedCompany" ng-change="changedValue(selectedCompany)">
						       		<option ng-selected= "{{companylist.companyId == selectedCompany}}" data-ng-repeat="companylist in companys" value="{{companylist.companyId}}">{{companylist.companyName}}</option>
						        </select>
						 	     </div>
								</td>
						</tr>
					</tbody>
				</table>
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
                              <th>InfoO</th>
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
                              <button type="button" ng-click="edit(u.productId)" class="btn btn-success custom-width">Edit</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
      		</div>  
          </div> 
       </div>  
              <div class="check-element animate-show-hide" ng-show="isChoiceEmpty(models)">
      		Ingen träff    
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
                              <th>InfoO</th>
                              <th>Inches</th>
                              <th>Product names </th>
                              <th>Pris</th>
                              <th>Visible</th>
                              <th width="20%"></th>
                          </tr>
                          <tr>
                          	<th colspan="7">Pictures </th>
                          </tr>
                      </thead>
                      <tbody>
                      	<tr>
                      		<td><span ng-bind="product.productId"></span></td>
                      		<td><span> <input  ng-model="product.modellName"></span></td>
                      		<td><span> <textarea ng-model="product.modell_info" ></textarea> </span></td>
                      		<td><span> <select ng-model="product.modell_size_id" >
					        		<option ng-selected= "{{sizeslist.screenSizeId == product.modell_size_id}}"data-ng-repeat="sizeslist in screenSizes" value="{{sizeslist.screenSizeId}}">{{sizeslist.screenSizeName}}</option>
					        </select></span> </td>
					        <td><span><select ng-model"product.modell_type_id" >
					        		<option ng-selected= "{{equipmentslist.typeId == product.modell_type_id}}"data-ng-repeat="equipmentslist in equipmentsTypes" value="{{equipmentslist.typeId}}">{{equipmentslist.typeName}}</option>
					        	</select></span> </td>
					        <td><span> <input ng-model="product.modellPris"></span></td>
					        <td> 
					        <label>
    						<input type="radio"  name="visible" ng-change="RadioChangeVisible(visibleSelected)" ng-model="visibleSelected" ng-value="1">
    							Product is visibele 	  						
    						</label><br/>
    						<label>
    						<input type="radio" name="visible" ng-change="RadioChangeVisible(visibleSelected)" ng-model="visibleSelected" ng-value="0">
   								Product is not visibele
  							</label><br/>
					        {{product.isVisible}}
					      
					        </td>
                      	</tr>
                      	<tr>
                      		<td colspan="6">
                      			<button type="button" ng-click="saveProduct(product.productId)" class="btn btn-success custom-width">Spara endring</button>
                      		</td>
                      	</tr>
                      	<tr> 
                      		 <td colspan="6"> 
                   	
                      		 </td> 
                      		 <td > <div id="ViewerContainer"> ViewerContainer</div> </td>
                      	</tr>
                      </tbody>
                  </table>
                  <table>
                      			
                      			<tbody> 
                          			<tr ng-repeat="imge in imgs" ng-model="imgs" track by $index >
                          				<td><img ng-src="{{imge.jspPath}}\img\{{imge.name}}" ng-click="getImgInfo(imge)"/></td>
                      		 		</tr>
                      		 		
                      		</tbody>
                  		</table>
                      		 	
              
      			</div>
	      			<div class="row">
	 					<div class="col-lg-12">
	 					<input type="file" class="thumb" accept="image/*" image="image" onchange="angular.element(this).scope().setFile(this)" style="width:400px"/>
	 					<img ng-src="{{img}}" style="width:200px;">
	 					<label class="col-md-3 control-lable" for="imageName">Name on image</label>
	 					<input type="text" ng-model="imageName"/>
	 					<button type="button" ng-click="saveImage()" class="btn btn-success custom-width">Spara</button>
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

			
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
			<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
  			<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-resource.js"></script>
  			<script type="text/javascript" src="<c:url value='/static/js/app.js' />"></script>
  			<script type="text/javascript"  src="<c:url value='/static/js/controller/controller.js' />"></script>
  			<script type="text/javascript" src="<c:url value='/static/js/service/service.js' />"></script> 
  			<script type="text/javascript" src="<c:url value='/static/js/angular-img-cropper.js' />"></script>                


	
</body>
</html>