'use strict';

myApp.controller('CostomerController',['$scope','Search','$window',function($scope, Search, $window){
	
	
	
	function fetchCurrentSearchItems(){
			
			Search.query(function(result, responseHeaders){
				
				$scope.items = result;
				
				//preLoad(result);
				//result.length
				buildTwodimensionalArray(result.length,3)
				
			},function(httpResponse){
	  		    //console.log('Error while fetching users list');
	  		    alert("Error while fetching currentUser") 
	   	 });
			
			
 			//alert(" fet " + items.length );
		
	}
		
		fetchCurrentSearchItems();
		
		
		function buildTable(data){
		
		var table = document.createElement("table");
		
		table.className="gridtable";
		
		//alert("load " + data.length)
		
		var index = 0;
		var countTr = 0;
		var countTd = 0;
		var index = 0;
		var indexTr = 0;
		var size = data.length;
		var next = true;
		
			while(next){
			
			if(countTr == 0){
				
				countTr += 3;
				console.log(" add tr " + countTr )
				var tr = document.createElement("tr");
			}else if(indexTr < 3){
				var td = document.createElement("td");
				td.appendChild(document.createTextNode(data[index].jspFullPathAndImgName));
		        tr.appendChild(td);
				indexTr++;
				index++;
				console.log(" add td " + indexTr );
			}
			
			if(indexTr == 3){
				table.appendChild(tr); 
				countTr = 0;
				indexTr = 0;
				console.log(" 3 tr appendChild ");
			}
			console.log(" index " + index);
			console.log(" size " + size);
			
			if(index == size-1){
				
				next = false;
				console.log(" next " + size);
			}
			
			
			
		}
		
			return table;
			
		}
		
		function buildTwodimensionalArray(size,tdSize){
			"use strict"	
			console.log(" start >  " + size);
			var index = 0;
			
			var arrayValues=[];
			
			var next = true;
			
			var arraySize = 0;
			
			if((size != 0) || (size != "undefined")){
				
					arraySize = 0;
					
					while(next){
						
						if(size > tdSize){
							
							arraySize++;
							size -=tdSize;
							arrayValues[index]=tdSize;
							index++;
							console.log(" size >  " + size);		
						}
						else if(size <= tdSize){
							
							arraySize++;
							next = false;	
							arrayValues[index]=size;
							console.log(" next " + size);	
						}
						
					}
			}
			console.log(" arraySize " + arrayValues);
			console.log(" arraySize " + arrayValues.length);
			
			var nextItem = true;
			var valuesIndex = 0;
			var indexItem = 0;
			var itemsSize = $scope.items.length;
			
			var MultiItems = new Array(arrayValues.length);
			
				for(var indexValue = 0; indexValue < arrayValues.length;indexValue++){
					
					console.log(" MultiItems[indexValue] " + indexValue);
					MultiItems[indexValue]= new Array(arrayValues[indexValue]);
					var countTd = arrayValues[indexValue];
					var dimensionTwoIndex = 0;
					nextItem = true;
					
					while(nextItem){
						
						if(dimensionTwoIndex < countTd){
							console.log(" MultiItems[indexValue][dim] " + dimensionTwoIndex);
							MultiItems[indexValue][dimensionTwoIndex]=$scope.items[indexItem];
							indexItem++;
							dimensionTwoIndex++;
							
						}else if(dimensionTwoIndex <= countTd){
							nextItem = false;
							console.log(" nextItem ");	
						}
						
						
					}
						
			}
				console.log(MultiItems);
				console.log(MultiItems[0][0].imgName);
				console.log(MultiItems[0].length);
				
				
				//for(var i = 0; i < MultiItems.length;i++){
				//	for(var x = 0; x < MultiItems[i].length;x++){
						
				//		console.log(MultiItems[i][x].imgName);
						
				//	}
					
				$scope.images = MultiItems;			
		}
	
		function preLoad(data) {
		
		  document.getElementById("content").appendChild(buildTable(data));
		}
		
		$scope.getImgInfo = function(image){
			
			console.log(" image " + image.productId);
		}
	
}]);
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

myApp.controller('CompanyController', ['$scope', 'Company','Categories', function($scope, Company, Categories) {
	
    
    function fetchAllCompanys(){
   	 
   	 Company.query(function(result, responseHeaders){
   		$scope.companys = result;	 
   		$scope.selectedCompany = $scope.companys[0].companyId;
   	 
   	 },function(httpResponse){
  		    //console.log('Error while fetching users list');
  		    alert("Error while fetching users list") 
   	 });
    }
  	  
    $scope.selectedCategories = null;
    
    fetchAllCompanys();
	 		    
	    $scope.changedValue = function(item){       
	       // alert(item);
	    	
	    	Categories.query({company_id: item},function(result, responseHeaders){
	    		
	    		$scope.categories = result;
	    		
	    	},function(httpResponse){
	    		//console.log('Error while fetching users list');
	    		alert("Error while fetching Categories list") 
	    	});
	    	
	    	
	    	$scope.companyId = item;
	    	//$scope.$emit('company_id',{'companyId': item,'categoriesId': 'topp'});
	       
	    } 
	    
	    $scope.changeValueCategories = function(item){
	    	
	    	$scope.$emit('company_id',{'companyId': $scope.companyId,'categoriesId': item});
	    }
	    
   	   
 }]);

myApp.controller('SourcesFormController', ['$http','$scope','Models','Model','ScreenSizes','ProductNames','ImgAndDoc',function($http, $scope, Models, Model, ScreenSizes, ProductNames, ImgAndDoc) {
	
	var company_id;
	var isChoiceEmpty;
	var screenSizes;
	var product;
	$scope.HideProduct = false;
	$scope.copyImage   = null;
	
	$scope.$on('company_id', function (event,data) {
		    //console.log(data); // 'Some data'
		//alert(data.categoriesId);
		company_id = data.companyId;
		isChoiceEmpty = false;
		    
			if( company_id != " " ){
		    	
		    		Models.query({company_id: company_id, categories_id: data.categoriesId },function(result, responseHeaders){
  
		    			$scope.copyImage   = null;
		    			$scope.HideProduct = false;
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
			$scope.HideProduct = true;
			$scope.copyImage = null;
			$scope.visibleSelected = $scope.product.isVisible;	
		});
	}
	
	$scope.saveProduct = function(productId){
		
		$scope.product.$update({productId: productId},function(){
			
		});
	}
		
		
	$scope.RadioChangeVisible = function (s) {
			
			//alert(" visible " + s);
		$scope.product.isVisible = s;	
     }
	
	$scope.RadioChangeImage = function (s) {
		
		$scope.copyImage.isVisible = s;
		UpdateCompanyImgAndDoc();
		
	}		
	
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
		
	$scope.ShowAndHideProduct = function(productStatus){
		return productStatus;
	}
	
	$scope.ShowAndHideImage = function(){
		
		if( $scope.copyImage != null){
			
			return true;
		}
		
		return false;
	}
		
		
	
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
    
    function UpdateCompanyImgAndDoc() {
        
    	$scope.copyImage.$update({id: $scope.copyImage.id},function(){
			
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
    
    $scope.getImgInfo = function(image){
    	
    	ImgAndDoc.get({id: image.id}).$promise.then(function(imageAndDoc) {
    	$scope.copyImage = imageAndDoc;
    	//alert(" id " + image.id )
    	});
    }
    

               
		
}]);// end SourcesFormController

angular.module('myApp').controller("ImageCropperCtrl",[ '$scope', function($scope)
    {
        $scope.cropper = {};
        $scope.cropper.sourceImage = null;
        $scope.cropper.croppedImage   = null;
        $scope.bounds = {};
        $scope.bounds.left = 0;
        $scope.bounds.right = 0;
        $scope.bounds.top = 0;
        $scope.bounds.bottom = 0;
    }]);

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

