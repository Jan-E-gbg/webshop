'use strict';

myApp.controller('UserController', ['$scope', 'Authentication', function($scope, Authentication) {
	
	function fetchCurrentUser(){
		
		Authentication.query(function(result, responseHeaders){
			
			$scope.currnetUser = result;
			
		},function(httpResponse){
  		    //console.log('Error while fetching users list');
  		    alert("Error while fetching currentUser") 
   	 });	
	}
	
	fetchCurrentUser();
	
}]);

myApp.controller('CompanyController', ['$scope', 'Company', function($scope, Company) {
	
    
    function fetchAllCompanys(){
   	 
   	 Company.query(function(result, responseHeaders){
   		$scope.companys = result;	 
   		$scope.selectedCompany = $scope.companys[0].companyId;
   	 
   	 },function(httpResponse){
  		    //console.log('Error while fetching users list');
  		    alert("Error while fetching users list") 
   	 });
    }
  	  

    
    fetchAllCompanys();
	 		    
	    $scope.changedValue = function(item){       
	       // alert(item);
	    	$scope.$emit('company_id', item);
	       
	    } 
   	   
 }]);

myApp.controller('SourcesFormController', ['$http','$scope','Models','Model','ScreenSizes','ProductNames', function($http, $scope, Models, Model, ScreenSizes, ProductNames) {
	
	var company_id;
	var isChoiceEmpty;
	var screenSizes;
	var product;
	
	$scope.$on('company_id', function (event, data) {
		    //console.log(data); // 'Some data'
		company_id = data;
		isChoiceEmpty = false;
		    
			if( company_id != " " ){
		    	
		    		Models.query({company_id: company_id},function(result, responseHeaders){
  
		    			isChoiceEmpty = false;
		    			$scope.models = result;	    		
			 	 
		    		},function(httpResponse){
		    		//console.log('Error while fetching users list');
		    		alert("Error while fetching Companys list") 
		    		});
		    	}else{ 
		    		$scope.models = ""; 
		    		isChoiceEmpty = true;
		    	}
 		//alert("submit: "+ data) 
		  });
	
	
	$scope.isChoiceEmpty = function(models){
		
		if((typeof models === "undefined") || (isChoiceEmpty)){
			//alert("undefined");
			return false;
		}else if(models.length <= 0){
				return true;		
		}
	}

	$scope.showAndHideList= function(value){
		
		if((typeof value === "undefined") || (isChoiceEmpty)){
			
			return false;
		} else if(value.length > 0){
			
			return true;
		}
		
	}
	
	
	$scope.edit = function(productId){
		
		Model.get({productId: productId}).$promise.then(function(product) {

			$scope.product = {};
			$scope.product = product;
			$scope.imgs = product.listOfImages;
			
			
				
				$scope.visibleSelected = $scope.product.isVisible;
			
			//alert(" size of img " + $scope.imgs[0].jspPath)
				
		});
	}
	
		$scope.saveProduct = function(productId){
		
		
		$scope.product.$update({productId: productId},function(){
			
		});
		
	}
		
		
		$scope.RadioChangeVisible = function (s) {
			
			//alert(" visible " + s);
			$scope.product.isVisible = s;
			
        };
		
		ScreenSizes.query(function(result, responseHeaders){
	   		$scope.screenSizes = result;	
	   		screenSizes = result;
	   		
	   		//for(var index = 0; index < screenSizes.length;index++ ){
			//	
	   		//	if($scope.product.modell_size_id == $scope.screenSizes[index].screenSizeId ){
	
					//alert($scope.product.modell_size_id + " S "+ $scope.screenSizes[index].screenSizeId)
	   		//	}
			//}
	   		//alert(" length " + $scope.screenSizes.length);
	   		//$scope.selectedCompany = $scope.companys[0].companyId;
	   	 
	   	 },function(httpResponse){
	  		    //console.log('Error while fetching users list');
	  		    alert("Error while fetching users list") 
	   	 });
		
		ProductNames.query(function(result, responseHeaders){
			
			$scope.equipmentsTypes = result;
			//alert(" ProductN " + result.length)
			
		},function(httpResponse){
  		    //console.log('Error while fetching users list');
  		    alert("Error while fetching users list") 
   	 });
		
		
	
	$scope.setFile = function(element){
		
		
		var files = element.files;
		$scope.files = files;

        for (var i = 0; i < files.length; i++) {
            var file = files[i];
            var reader = new FileReader();
            reader.onload = $scope.imageIsLoaded;
            reader.readAsDataURL(file);
        }
    }

    $scope.imageIsLoaded = function (e) {
        $scope.$apply(function () {
            $scope.img = e.target.result;            
        });
    }
	
$scope.saveImage = function(){
		
		alert(" imageName " + $scope.imageName)
		var productId = $scope.product.productId;
		var imagetheName = $scope.imageName;
		var uploadUrl = "restmain/previewImage";
		
		var element = $scope.files;
		var fd = new FormData();
		for (var i = 0; i < element.length; i++) {
			fd.append('file', element[i]);
		}
	
		$http.post(uploadUrl, fd, {
			transformRequest : angular.identity,
			headers : {
			'Content-Type' : undefined
			},
				params: { imgName : imagetheName, productId : productId}
			}).success(function(response) {
			//console.log('success');
				alert("resopnse " + response );	
			}).error(function() {
			//console.log('error');
			});	
	}

$scope.imgIndex = function(index){
	
	alert(" index " + index )
}

               
		
}]);// end SourcesFormController

myApp.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            
            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };


}]);

