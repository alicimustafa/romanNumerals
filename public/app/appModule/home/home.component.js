angular.module('appModule')
.component('home',{
	templateUrl: 'app/appModule/home/home.component.html',
	controller: function(homeService){
		var vm = this;
		vm.numberToRoman = true;
		vm.number = null;
		vm.roman = null;
		vm.romanResult = null;
		vm.numberResult = null;
		
		vm.switch = function(){
			vm.numberToRoman = vm.numberToRoman ? false : true;
			vm.romanResult = null;
			vm.numberResult = null;
			vm.number = null;
			vm.roman = null;
		}
		
		vm.submitNumber = function(number){
			homeService.postNumber(number)
			.then(function(res){
				vm.romanResult = res.data;
			})
			.catch(function(err){
				console.log(err);
				vm.romanResult = "You need to enter a whole number";
			});
		}
		
		vm.submitRoman = function(roman){
			homeService.postRoman(roman)
			.then(function(res){
				vm.numberResult = res.data;
			})
			.catch(function(err){
				console.log(err);
				vm.numberResult = "You need to enter a Proper roman numeral"
			})
		}
	},
	controllerAs: 'vm'
})