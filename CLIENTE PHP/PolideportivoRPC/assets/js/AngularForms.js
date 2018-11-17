app = angular.module('AngularForms', []);
app.controller('ControllerForms', function($scope, $http){
	
	$scope.validPass = "";
	$scope.colorPss = "";
	
	//Validar Contraseña
	$scope.validarPass = function() {
		if($scope.pass != $scope.passrepeat) {
			$scope.colorPss = "red";
			$scope.validPass = "Las contraseñas no coinciden";
		}
		else {
			$scope.colorPss = "green";
			$scope.validPass = "Contraseñas correctas";
		}
	}
	
	/*
	//Cargar Array con nombres de Usuario
	$scope.us = [];
	$http.get('http://localhost/Polideportivo/RegistrarSocio/TraerUsuarios').  
    then(function(response) {
    	
    	$scope.usuarios = response.data;
    	
    	var length = $scope.usuarios.length;
        
        for (i = 0; i < length; i++) {
        	$scope.us.push($scope.usuarios[i].us);
        }

    });
	
	//Validar Nombre de Usuario
	$scope.validUser = "";
	$scope.colorUs = "";
	$scope.validarUser = function() {
		
		for(i = 0; i < $scope.us.length; i++) {
			if($scope.user.length < 5) {
				$scope.colorUs = "red";
				$scope.validUser = "El Nombre de Usuarios es Demasiado Corto";
			}
			else if($scope.user == $scope.us[i]) {
				$scope.colorUs = "red";
				$scope.validUser = "El Nombre de Usuario Ya Está en Uso";
			}
			else {
				$scope.colorUs = "green";
				$scope.validUser = "El Nombre de Usuario es Valido";
			}
		}
	}
	*/
});