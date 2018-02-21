angular.module('appModule')
.factory('homeService',function($http){
	var service = {};
	
	service.postNumber = function(number){
		return $http({
			method: 'POST',
			url:'numberRoman',
			headers : {
				'ContentType' : 'text/plain'
			},
			data : number,
			transformResponse: [function (data) {
			      return data;
			  }]
		})
	}
	
	service.postRoman = function(roman){
		return $http({
			method: 'POST',
			url:'romanNumber',
			headers : {
				'ContentType' : 'text/plain'
			},
			data : roman,
			transformResponse: [function (data) {
			      return data;
			  }]
		})
	}
	return service;
});