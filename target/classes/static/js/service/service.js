
'use strict';

myApp.factory('Authentication', ['$resource', function ($resource) {
	//$resource() function returns an object of resource class
    return $resource(
    		'http://localhost:8080/WebShop/restmain/authentication',{},
    		{
    			update: {
    			      method: 'PUT' // To send the HTTP Put request when calling this custom update method.
    			}
    			
    		}
    	);
}]);

myApp.factory('Company', ['$resource', function ($resource) {
	//$resource() function returns an object of resource class
    return $resource(
    		'http://localhost:8080/WebShop/restmain/listAllCompanys', {},
    		//{id: '@id'},//Handy for update & delete. id will be set with id of instance
    		{
    			update: {
    			      method: 'PUT' // To send the HTTP Put request when calling this custom update method.
    			}
    			
    		}
    );
}]);

myApp.factory('Models', ['$resource', function ($resource) {
	//$resource() function returns an object of resource class
    return $resource(
    		'http://localhost:8080/WebShop/restmain/listCompanyModels/:company_id',
    		//Handy for update & delete. id will be set with id of instance
    		{
    			update: { 
    			      method: 'PUT'// To send the HTTP Put request when calling this custom update method.
    			}

    		}
    			
    		
    );
}]);

myApp.factory('TokenHandler', function() {
	  var tokenHandler = {};
	  var token = "none";

	  tokenHandler.set = function( newToken ) {
	    token = newToken;
	  };

	  tokenHandler.get = function() {
	    return token;
	};
	// wrap given actions of a resource to send auth token with every
	  // request
	  tokenHandler.wrapActions = function( resource, actions ) {
	    // copy original resource
	    var wrappedResource = resource;
	    for (var i=0; i < actions.length; i++) {
	      tokenWrapper( wrappedResource, actions[i] );
	    };
	    // return modified copy of resource
	    return wrappedResource;
	  };

	  // wraps resource action to send request with auth token
	  var tokenWrapper = function( resource, action ) {
	    // copy original action
	    resource['_' + action]  = resource[action];
	    // create new action wrapping the original and sending token
	    resource[action] = function( data, success, error){
	      return resource['_' + action](
	        angular.extend({}, data || {}, {access_token: tokenHandler.get()}),
	        success,
	        error
	      );
	    };
	  };

	  return tokenHandler;
	});

myApp.factory('Model', ['$resource','TokenHandler', function ($resource) {
	//$resource() function returns an object of resource class
	return  $resource(
		'http://localhost:8080/WebShop/restmain/modelItem/:productId',{productId: '@_productId'},
		//Handy for update & delete. id will be set with id of instance
		{
			update: { 
			      method: 'PUT'// To send the HTTP Put request when calling this custom update method.
			},
            get: {
                method: 'GET'
          }
      }, 
      {
          stripTrailingSlashes: false
      }					
	);
}]);
myApp.factory('ImgAndDoc', ['$resource','TokenHandler', function ($resource) {
	//$resource() function returns an object of resource class
	return $resource(
		'http://localhost:8080/WebShop/restmain/imgAndDoc/:id',{id: '@_id'},
		//Handy for update & delete. id will be set with id of instance
		{
			update: { 
			      method: 'PUT'// To send the HTTP Put request when calling this custom update method.
			},
            get: {
                method: 'GET'
          }
      }, 
      {
          stripTrailingSlashes: false
      }					
	);
}]);
	
//resource = tokenHandler.wrapActions( resource,
//	    ["query", "update", "save"] );

	//  return resource;
//}]);

myApp.factory('ScreenSizes', ['$resource', function ($resource) {
	//$resource() function returns an object of resource class
    return $resource(
    		'http://localhost:8080/WebShop/restmain/listAllScreenSizes', 
    		//{id: '@id'},//Handy for update & delete. id will be set with id of instance
    		{
    			update: {
    			      method: 'PUT' // To send the HTTP Put request when calling this custom update method.
    			}
    			
    		}
    );
}]);

myApp.factory('ProductNames', ['$resource', function ($resource) {
	//$resource() function returns an object of resource class
    return $resource(
    		'http://localhost:8080/WebShop/restmain/listAllProductNames', 
    		//{id: '@id'},//Handy for update & delete. id will be set with id of instance
    		{
    			update: {
    			      method: 'PUT' // To send the HTTP Put request when calling this custom update method.
    			}
    			
    		}
    );
}]);